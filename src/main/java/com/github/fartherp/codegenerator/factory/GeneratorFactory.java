/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.factory;

import com.github.fartherp.codegenerator.api.Generator;
import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.framework.common.extension.ExtensionLoader;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/9/1
 */
public class GeneratorFactory {

    public static final String PATH = "generator";

    /**
     * SPI动态查询子类
     * @param context 全局变量
     * @return Generator
     */
    public static Generator getGenerator(CodeGenContext context) {
        Generator generator = ExtensionLoader.getExtensionLoader(Generator.class, PATH).getExtension(context.getGeneratorType());
        generator.build(context);
        return generator;
    }
}
