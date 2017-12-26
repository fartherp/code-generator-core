/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api;

import com.github.fartherp.codegenerator.api.file.GeneratedJavaFile;
import com.github.fartherp.codegenerator.api.file.GeneratedXmlFile;
import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.DatabaseWrapper;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;
import com.github.fartherp.codegenerator.util.JavaBeansUtils;
import com.github.fartherp.framework.common.util.FileUtilies;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 统一生成抽象类
 * Author: CK.
 * Date: 2015/6/6.
 */
public abstract class MyBatisGenerator<T extends AbstractAttributes> implements Generator {

    protected CodeGenContext context;

    /** JAVA文件列表 */
    protected List<GeneratedJavaFile> generatedJavaFiles;

    /** XML文件列表 */
    protected List<GeneratedXmlFile> generatedXmlFiles;

    protected List<TableInfoWrapper<T>> tableInfoWrappers;

    /**
     * 自动生成文件
     */
    public void generate() {
        this.generateFiles();
        this.createDir();
        this.write();
    }

    public Generator build(CodeGenContext context) {
        this.context = context;
        this.generatedJavaFiles = new ArrayList<GeneratedJavaFile>();
        this.generatedXmlFiles = new ArrayList<GeneratedXmlFile>();
        return this;
    }

    /**
     * 自动生成文件
     */
    protected void generateFiles() {
        DatabaseWrapper databaseWrapper = context.getDatabaseWrapper();
        tableInfoWrappers = databaseWrapper.createTableInfoWrapper(this);
        if (null != tableInfoWrappers) {
            for (TableInfoWrapper tableInfoWrapper : tableInfoWrappers) {
                tableInfoWrapper.initialize();
                generatedJavaFiles.addAll(tableInfoWrapper.getGeneratedJavaFiles());
                generatedXmlFiles.addAll(tableInfoWrapper.getGeneratedXmlFiles());
            }
        }
    }

    /**
     * 写文件
     */
    protected void write() {
        for (GeneratedJavaFile gxf : generatedJavaFiles) {
            // 目标文件
            File targetFile = FileUtilies.getDirectory("main." + gxf.getTargetPackage(), gxf.getFileName(), context.getOut());
            // 目标内容
            String source = gxf.getFormattedContent();
            // 输出流写文件
            FileUtilies.writeFile(targetFile, source, "UTF-8");
        }

        for (GeneratedXmlFile gxf : generatedXmlFiles) {
            // 目标文件
            File targetFile = FileUtilies.getDirectory("resources." + gxf.getTargetPackage(), gxf.getFileName(), context.getOut());
            // 目标内容
            String source = gxf.getFormattedContent();
            // 输出流写文件
            FileUtilies.writeFile(targetFile, source, "UTF-8");
        }
    }

    /**
     * 创建生成文件夹
     */
    protected void createDir() {
        String out = this.getClass().getResource("/").getPath() + new Date().getTime() + File.separator;
        context.setOut(out);
        File file = new File(context.getOut());
        try {
            FileUtils.forceMkdir(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        context.setFile(file);
    }

    public String dealTableName(String tableName) {
        return JavaBeansUtils.dealTableName(tableName.toLowerCase());
    }

    public String dealColumnName(String columnName) {
        return JavaBeansUtils.dealColumnName(columnName.toLowerCase());
    }
}
