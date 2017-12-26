/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml;

import com.github.fartherp.codegenerator.config.XmlConstants;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/9/25
 */
public class DocumentTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        Document document = new Document(XmlConstants.MYBATIS3_MAPPER_PUBLIC_ID,
                XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);
        XmlElement answer = new XmlElement("mapper");
        String namespace = "com.github.codegenerator.Mapper";
        answer.addAttribute(new Attribute("namespace", namespace));
        document.setRootElement(answer);
        System.out.println(document.getFormattedContent(1));
    }

}