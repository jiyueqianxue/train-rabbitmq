/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package io.mine.ft.train.sender.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mine.ft.train.bean.MqMessage;
import io.mine.ft.train.bean.base.BaseResult;
import io.mine.ft.train.dao.mapper.MqMessageMapper;
import io.mine.ft.train.enums.MessageQueueStatusEnum;
import io.mine.ft.train.sender.MqSender;
import io.mine.ft.train.utils.CreateSerialUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author feng.li
 * @since 2019-09-08
 */
@Slf4j
@Service
public class RabbitMqSender implements MqSender {

    @Autowired
    private MqMessageMapper mqMessageMapperExt;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @Override
    public BaseResult sendMQ(String message, String routingKey, String exchange) {
        return sendTxnMQ(message, CreateSerialUtil.getPatitionKey(), routingKey, exchange);
    }

    @Override
    public BaseResult sendTxnMQ(String message, String patitionKey, String routingKey, String exchange) {
        patitionKey = StringUtils.isBlank(patitionKey) ? CreateSerialUtil.getPatitionKey() : patitionKey;
        MqMessage mqMessage = new MqMessage();
        //mqMessage.setBizSeq(LogBizSysNoStore.getBizReqNo());
        //mqMessage.setSysSeq(LogBizSysNoStore.getSysReqNo());
        mqMessage.setPatitionKey(patitionKey);
        mqMessage.setSendIp("127.0.0.1");
        mqMessage.setReceiveIp("127.0.0.1");
        mqMessage.setMqExchange(exchange);
        mqMessage.setMqRoutingKey(routingKey);
        mqMessage.setMqMessage(message);
        mqMessage.setResendTimes(0);

        log.info("[ENTRY]MQ消息发送.mqMessage={}", mqMessage);
        BaseResult resp = null;
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            mqMessage.setStatus(MessageQueueStatusEnum.FINISH.getCode());
            resp = BaseResult.createSuccess();
        } catch (Exception e) {
            log.error("[ON_ERROR]MQ消息发送异常.mqMessage={}", mqMessage, e);
            mqMessage.setStatus(MessageQueueStatusEnum.FAILED.getCode());
            resp = BaseResult.createFail("", "MQ发送异常!");
        }
        
        try {
            mqMessageMapperExt.insertSelective(mqMessage);
            log.info("[OTHER]保存MQ消息发送记录.{}", mqMessage);
        } catch (Exception e) {
            log.error("[ON_ERROR]保存MQ消息发送记录异常.mqMessage={}", mqMessage, e);
        }

        log.info("[EXIT]MQ事务消息发送.resp={},mqMessage={}", resp, mqMessage);
        return resp;
    }

}
