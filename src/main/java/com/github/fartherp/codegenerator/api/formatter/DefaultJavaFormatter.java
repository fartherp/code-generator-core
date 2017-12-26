/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api.formatter;

import com.github.fartherp.codegenerator.java.CompilationUnit;

/**
 * JAVA文件格式化接口（默认）
 * Author: CK
 * Date: 2015/6/13
 */
public class DefaultJavaFormatter implements JavaFormatter {

    public String getFormattedContent(CompilationUnit compilationUnit) {
        return compilationUnit.getFormattedContent();
    }
}
