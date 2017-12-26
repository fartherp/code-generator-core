/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.mybatis.element;

import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.ColumnInfo;
import com.github.fartherp.codegenerator.util.MyBatis3FormattingUtils;
import com.github.fartherp.codegenerator.xml.Attribute;
import com.github.fartherp.codegenerator.xml.XmlElement;
import org.apache.commons.lang.StringUtils;

/**
 * 基础resultMap（BLOB字段）
 * Author: CK
 * Date: 2015/6/7
 */
public class ResultMapWithBLOBsElementGenerator<T extends AbstractAttributes> extends AbstractXmlElementGenerator<T> {

    public void prepareXmlElement() {
        name = "resultMap";
        id = attributes.getResultMapWithBLOBs();
        String returnType;
        if (rules.generateRecordWithBLOBsClass()) {
            returnType = attributes.getRecordWithBLOBsType();
        } else {
            // table has BLOBs, but no BLOB class - BLOB fields must be
            // in the base class
            returnType = attributes.getBaseRecord();
        }
        type = returnType;
    }

    public void dealElements() {
        if (tableInfoWrapper.isConstructorBased()) {
            addResultMapConstructorElements(answer);
        } else {
            addResultMapElements(answer);
        }
    }

    private void addResultMapElements(XmlElement answer) {
        for (ColumnInfo c : tableInfoWrapper.getBlobColumns()) {
            XmlElement resultElement = new XmlElement("result");

            resultElement.addAttribute(new Attribute(
                    "column", MyBatis3FormattingUtils.getRenamedColumnNameForResultMap(c)));
            resultElement.addAttribute(new Attribute("property", c.getJavaProperty()));
            resultElement.addAttribute(new Attribute("jdbcType", c.getJdbcTypeName()));

            if (StringUtils.isNotBlank(c.getTypeHandler())) {
                resultElement.addAttribute(new Attribute("typeHandler", c.getTypeHandler()));
            }

            answer.addElement(resultElement);
        }
    }

    private void addResultMapConstructorElements(XmlElement answer) {
        XmlElement constructor = new XmlElement("constructor");

        for (ColumnInfo c : tableInfoWrapper.getPrimaryKeyColumns()) {
            XmlElement resultElement = new XmlElement("idArg");

            resultElement.addAttribute(new Attribute("column",
                    MyBatis3FormattingUtils.getRenamedColumnNameForResultMap(c)));
            resultElement.addAttribute(new Attribute("jdbcType", c.getJdbcTypeName()));
            resultElement.addAttribute(new Attribute("javaType", c.getJavaTypeInfo().getFullyQualifiedName()));

            if (StringUtils.isNotBlank(c.getTypeHandler())) {
                resultElement.addAttribute(new Attribute("typeHandler", c.getTypeHandler()));
            }

            constructor.addElement(resultElement);
        }

        for (ColumnInfo c : tableInfoWrapper.getNonPrimaryKeyColumns()) {
            XmlElement resultElement = new XmlElement("arg");

            resultElement.addAttribute(new Attribute("column",
                    MyBatis3FormattingUtils.getRenamedColumnNameForResultMap(c)));
            resultElement.addAttribute(new Attribute("jdbcType", c.getJdbcTypeName()));

            if (c.getJavaTypeInfo().isPrimitive()) {
                // need to use the MyBatis type alias for a primitive byte
                resultElement.addAttribute(new Attribute("javaType", "_" + c.getJavaTypeInfo().getShortName()));
            } else if ("byte[]".equals(c.getJavaTypeInfo().getFullyQualifiedName())) {
                // need to use the MyBatis type alias for a primitive byte arry
                resultElement.addAttribute(new Attribute("javaType", "_byte[]"));
            } else {
                resultElement.addAttribute(new Attribute("javaType", c.getJavaTypeInfo().getFullyQualifiedName()));
            }

            if (StringUtils.isNotBlank(c.getTypeHandler())) {
                resultElement.addAttribute(new Attribute("typeHandler", c.getTypeHandler()));
            }

            constructor.addElement(resultElement);
        }

        answer.addElement(constructor);
    }
}
