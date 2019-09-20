/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package io.mine.ft.train.dao.mapper;

import io.mine.ft.train.bean.MqMessage;

/**
 * @author feng.li
 * @since 2019-09-08
 */
public interface MqMessageMapper {

    int insertSelective(MqMessage record);
}
