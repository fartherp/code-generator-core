/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api.file;

import com.github.fartherp.javaxml.Document;
import com.github.fartherp.javaxml.formatter.XmlFormatter;

/**
 * XML文件
 * Author: CK.
 * Date: 2015/6/6.
 */
public class GeneratedXmlFile extends GeneratedFile {

    /** 生成文档信息 */
    private Document document;

    /** 生成Mapper.xml文件名 */
    private String fileName;

    /** 生成文件包名 */
    private String targetPackage;

    /** XML格式化接口 */
    private XmlFormatter xmlFormatter;

    public GeneratedXmlFile(Document document, String fileName,
                            String targetPackage, String targetProject,
                            XmlFormatter xmlFormatter) {
        super(targetProject);
        this.document = document;
        this.fileName = fileName;
        this.targetPackage = targetPackage;
        this.xmlFormatter = xmlFormatter;
    }

    public String getFormattedContent() {
        return xmlFormatter.getFormattedContent(document);
    }

    public String getFileName() {
        return fileName;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public String getModule() {
        return document.getModule();
    }
}
