/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package io.mine.ft.train.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * MQ消息记录MODEL
 */
@Getter
@Setter
public class MqMessage implements Serializable {

    private static final long serialVersionUID = 6424222763020785678L;

    /**
     * PK
     */
    private Long id;

    /**
     * 业务流水号
     */
    private String bizSeq;

    /**
     * 请求流水号
     */
    private String sysSeq;

    /**
     * 分表 key
     */
    private String patitionKey;

    /**
     * 发送方IP
     */
    private String sendIp;

    /**
     * 接收方IP
     */
    private String receiveIp;

    /**
     * rabbitmq routing key
     */
    private String mqRoutingKey;

    /**
     * 消息报文体
     */
    private String mqMessage;

    /**
     * rabbitmq exchange
     */
    private String mqExchange;

    /**
     * 附件信息
     */
    private String extInfo;

    /**
     * 发送状态
     */
    private String status;

    /**
     * 下次重发时间
     */
    private Integer resendTimes;
}
