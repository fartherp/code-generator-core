/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml;

import com.github.fartherp.framework.common.util.OutputUtils;

/**
 * the XML of text content.
 * <p><code>Element attribute = new TextElement("select * from table");</code></p>
 * <p><code>attribute.getFormattedContent(1);</code></p>
 * <p>the result is <b>select * from table</b></p>
 * Author: CK.
 * Date: 2015/6/6.
 */
public class TextElement implements Element {

    private String content;

    public TextElement(String content) {
        this.content = content;
    }

    public String getFormattedContent(int indentLevel) {
        StringBuilder sb = new StringBuilder();
        OutputUtils.xmlIndent(sb, indentLevel);
        sb.append(content);
        return sb.toString();
    }
}
