/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.mybatis.mapper;

import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.javaxml.XmlElement;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/16
 */
public class EmptyXMLMapperGenerator<T extends AbstractAttributes> extends AbstractXmlMapperGenerator<T> {

    public void getSqlMapElement(XmlElement answer) {
        answer.setEnd(false);
    }
}
