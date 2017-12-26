/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api;

import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;
import com.github.fartherp.framework.common.extension.SPI;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/9/25
 */
@SPI
public interface Generator {

    /**
     * 创建相应的generator对象
     * @param context 全局context
     * @return Generator
     */
    Generator build(CodeGenContext context);

    /**
     * 自动生成代码
     */
    void generate();

    /**
     * 创建自己的TableInfoWrapper
     * @param context 全局context
     * @return TableInfoWrapper
     */
    TableInfoWrapper createTableInfoWrapper(CodeGenContext context);

    /**
     * 处理表名
     * @param tableName 数据库表名
     * @return 自定义格式的表名
     */
    String dealTableName(String tableName);

    /**
     * 处理列名
     * @param columnName 数据库表的列名
     * @return 自定义格式的列名
     */
    String dealColumnName(String columnName);
}
