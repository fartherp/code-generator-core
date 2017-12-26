/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api.formatter;

import com.github.fartherp.codegenerator.xml.Document;

/**
 * XML文件格式化接口
 * Author: CK.
 * Date: 2015/6/6.
 */
public interface XmlFormatter {

    /**
     * 生成XML内容
     * @param document 目标文档
     * @return XML内容
     */
    String getFormattedContent(Document document);
}
