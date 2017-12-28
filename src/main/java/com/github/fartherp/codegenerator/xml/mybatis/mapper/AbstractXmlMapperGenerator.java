/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.mybatis.mapper;

import com.github.fartherp.codegenerator.api.AbstractGenerator;
import com.github.fartherp.codegenerator.config.XmlConstants;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.xml.mybatis.element.AbstractXmlElementGenerator;
import com.github.fartherp.codegenerator.xml.mybatis.element.BaseColumnListElementGenerator;
import com.github.fartherp.codegenerator.xml.mybatis.element.BlobColumnListElementGenerator;
import com.github.fartherp.codegenerator.xml.mybatis.element.ResultMapWithBLOBsElementGenerator;
import com.github.fartherp.codegenerator.xml.mybatis.element.ResultMapWithoutBLOBsElementGenerator;
import com.github.fartherp.javaxml.Attribute;
import com.github.fartherp.javaxml.Document;
import com.github.fartherp.javaxml.XmlElement;

/**
 * 公共的XML的MAPPER类
 * Author: CK.
 * Date: 2015/6/6.
 */
public abstract class AbstractXmlMapperGenerator<T extends AbstractAttributes> extends AbstractGenerator<T> {

    /**
     * 获取文档信息
     * @return 文档信息
     */
    public Document getDocument() {
        Document document = new Document(XmlConstants.MYBATIS3_MAPPER_PUBLIC_ID,
                XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);

        XmlElement answer = new XmlElement("mapper");
        String namespace = tableInfoWrapper.getAttributes().getNamespace();
        answer.addAttribute(new Attribute("namespace", namespace));
        getSqlMapElement(answer);
        document.setRootElement(answer);
        return document;
    }

    public abstract void getSqlMapElement(XmlElement answer);

    protected void initializeAndExecuteGenerator(AbstractXmlElementGenerator<T> elementGenerator,
                                                 XmlElement parentElement) {
        elementGenerator.setTableInfoWrapper(tableInfoWrapper);
        elementGenerator.addElements(parentElement);
    }

    /**
     * resultMap
     * @param parentElement XmlElement
     */
    protected void addResultMapWithoutBLOBsElement(XmlElement parentElement) {
        if (rules.generateBaseResultMap()) {
            AbstractXmlElementGenerator<T> elementGenerator = new ResultMapWithoutBLOBsElementGenerator<T>(false);
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addResultMapWithBLOBsElement(XmlElement parentElement) {
        if (rules.generateResultMapWithBLOBs()) {
            AbstractXmlElementGenerator<T> elementGenerator = new ResultMapWithBLOBsElementGenerator<T>();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    /**
     * 所有列基本信息
     * @param parentElement XmlElement
     */
    protected void addBaseColumnListElement(XmlElement parentElement) {
        if (rules.generateBaseColumnList()) {
            AbstractXmlElementGenerator<T> elementGenerator = new BaseColumnListElementGenerator<T>();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }

    protected void addBlobColumnListElement(XmlElement parentElement) {
        if (rules.generateBlobColumnList()) {
            AbstractXmlElementGenerator<T> elementGenerator = new BlobColumnListElementGenerator<T>();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
        }
    }
}
