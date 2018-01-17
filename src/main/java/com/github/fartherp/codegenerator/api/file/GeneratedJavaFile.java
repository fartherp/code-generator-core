/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api.file;

import com.github.fartherp.javacode.CompilationUnit;
import com.github.fartherp.javacode.formatter.JavaFormatter;

/**
 * JAVA自动生成文件类
 * Author: CK.
 * Date: 2015/6/6.
 */
public class GeneratedJavaFile extends GeneratedFile {

    /** JAVA类接口 */
    private CompilationUnit compilationUnit;

    /** 文件编码 */
    private String fileEncoding;

    /** JAVA格式 */
    private JavaFormatter javaFormatter;

    public GeneratedJavaFile(CompilationUnit compilationUnit,
                             String targetProject,
                             String fileEncoding,
                             JavaFormatter javaFormatter) {
        super(targetProject);
        this.compilationUnit = compilationUnit;
        this.fileEncoding = fileEncoding;
        this.javaFormatter = javaFormatter;
    }

    public String getFormattedContent() {
        return javaFormatter.getFormattedContent(compilationUnit);
    }

    public String getFileName() {
        return compilationUnit.getType().getShortName() + ".java";
    }

    public String getTargetPackage() {
        return compilationUnit.getType().getPackageName();
    }

    public String getModule() {
        return compilationUnit.getModule();
    }
}
