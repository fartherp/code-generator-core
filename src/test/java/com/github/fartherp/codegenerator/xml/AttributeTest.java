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
public class AttributeTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        Attribute attribute = new Attribute("id", "update");
        System.out.println(attribute.getFormattedContent(1));
    }

}