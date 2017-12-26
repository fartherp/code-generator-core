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
public class TextElementTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        TextElement textElement = new TextElement("select * from table");
        System.out.println(textElement.getFormattedContent(1));
    }

}