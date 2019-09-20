/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package io.mine.ft.train.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类AmountDirEnum.java的实现描述：资金方向
 *
 * @author zhaoxiaoliang 2017年5月10日 下午6:29:54
 */
@Getter
@AllArgsConstructor
public enum MessageQueueStatusEnum {

    INIT("INIT", "初始"),

    SENDING("SENDING", "发送中"),

    FINISH("FINISH", "成功"),

    FAILED("FAILED", "失败");

    private String code;
    
    private String message;

}
