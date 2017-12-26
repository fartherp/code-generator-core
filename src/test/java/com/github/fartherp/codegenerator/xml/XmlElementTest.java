/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml;

import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/9/25
 */
public class XmlElementTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        XmlElement xmlElement = new XmlElement("select");
        Attribute attribute = new Attribute("id", "findAll");
        xmlElement.addAttribute(attribute);
        TextElement textElement = new TextElement("select * from table");
        xmlElement.addElement(textElement);
        System.out.println(xmlElement.getFormattedContent(1));
    }

}