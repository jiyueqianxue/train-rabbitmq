/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package io.mine.ft.train.sender;

import io.mine.ft.train.bean.base.BaseResult;

/**
 * RabbitMQ消息发送服务封装
 *
 * @author feng.li
 * @since 2019-09-06
 */
public interface MqSender {

    /**
     * 发送rabbitmq消息
     *
     * @param message     消息报文体
     * @param routhingKey routhing key
     * @param exchange    exchange
     * @return {@link BaseRespDto}
     */
	BaseResult sendMQ(String message, String routhingKey, String exchange);

    /**
     * 发送MQ事务消息(保证一定发送成功)
     *
     * @param message     MQ消息内容
     * @param patitionKey 消息分区键
     * @param routingKey  RabbitMQ routing key
     * @param exchange    RabbitMQ exchange
     * @return {@link BaseRespDto}
     */
	BaseResult sendTxnMQ(String message, String patitionKey, String routingKey, String exchange);

}
