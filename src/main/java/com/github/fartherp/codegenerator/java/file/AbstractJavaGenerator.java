/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.java.file;

import com.github.fartherp.codegenerator.api.AbstractGenerator;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;
import com.github.fartherp.codegenerator.java.element.AbstractJavaElementGenerator;
import com.github.fartherp.javacode.CompilationUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象JAVA类生成
 * Author: CK
 * Date: 2015/6/13
 */
public abstract class AbstractJavaGenerator<T extends AbstractAttributes> extends AbstractGenerator<T> {

    public AbstractJavaGenerator(TableInfoWrapper<T> t) {
        setTableInfoWrapper(t);
    }

    protected void initializeAndExecuteGenerator(AbstractJavaElementGenerator<T> elementGenerator,
                                                 List<CompilationUnit> answers) {
        elementGenerator.prepareElement();
        elementGenerator.addCompilationUnit(answers);
    }

    public List<CompilationUnit> getCompilationUnits() {
        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        getJavaFile(answer);
        return answer;
    }

    public abstract void getJavaFile(List<CompilationUnit> answer);
}
