/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.api;

import com.github.fartherp.codegenerator.api.rule.Rules;
import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;

/**
 * 公用类，JAVA/XML
 * Author: CK
 * Date: 2015/6/13
 */
public abstract class AbstractGenerator<T extends AbstractAttributes> {

    protected CodeGenContext context;

    protected TableInfoWrapper<T> tableInfoWrapper;

    protected Rules rules;

    protected CommentGenerator commentGenerator;

    public void setTableInfoWrapper(TableInfoWrapper<T> tableInfoWrapper) {
        this.tableInfoWrapper = tableInfoWrapper;
        this.context = tableInfoWrapper.getContext();
        this.rules = tableInfoWrapper.getRules();
        this.commentGenerator = tableInfoWrapper.getCommentGenerator();
    }
}
