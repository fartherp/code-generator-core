/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api.formatter;

import com.github.fartherp.codegenerator.java.CompilationUnit;

/**
 * JAVA文件格式化接口
 * Author: CK.
 * Date: 2015/6/6.
 */
public interface JavaFormatter {
    /**
     * 生成JAVA内容
     * @param compilationUnit 内容
     * @return JAVA内容
     */
    String getFormattedContent(CompilationUnit compilationUnit);
}