/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.spring.document;

import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;
import com.github.fartherp.codegenerator.xml.Document;

import java.util.List;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/17
 */
public abstract class AbstractSpringXMLDocument<T extends AbstractAttributes> {
    protected CodeGenContext context;

    protected List<TableInfoWrapper<T>> tableInfoWrapper;

    protected AbstractSpringXMLDocument(CodeGenContext context, List<TableInfoWrapper<T>> tableInfoWrapper) {
        this.context = context;
        this.tableInfoWrapper = tableInfoWrapper;
    }

    public abstract List<Document> getDocument();
}
