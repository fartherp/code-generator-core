/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.java;

import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/9/22
 */
public class FieldTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
        Field field = new Field("age", javaTypeInfo);
        System.out.println(field.getFormattedContent(1));
    }

}