/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.java.resolver;

import com.github.fartherp.codegenerator.db.ColumnInfo;
import com.github.fartherp.javacode.JavaTypeInfo;

/**
 * JAVA类型解析接口
 * Author: CK.
 * Date: 2015/6/6.
 */
public interface JavaTypeResolver {

    /**
     * 根据JDBC类型，长度，精度，计算JAVA类型名称
     *
     * @param columnInfo 列名
     * @return JAVA类型信息
     */
    JavaTypeInfo calculateJavaType(ColumnInfo columnInfo);

    /**
     * 根据JDBC类型，长度，精度，计算JDBC类型名称
     *
     * @param columnInfo 列名
     * @return JAVA类型名称
     */
    String calculateJdbcTypeName(ColumnInfo columnInfo);
}
