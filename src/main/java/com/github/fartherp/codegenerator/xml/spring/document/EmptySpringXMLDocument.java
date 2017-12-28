/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.spring.document;

import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;
import com.github.fartherp.codegenerator.xml.spring.element.AbstractSpringXMLElement;
import com.github.fartherp.codegenerator.xml.spring.element.EmptySpringXMLElement;
import com.github.fartherp.javaxml.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/16
 */
public class EmptySpringXMLDocument extends AbstractSpringXMLDocument<AbstractAttributes> {

    public EmptySpringXMLDocument(CodeGenContext context, List<TableInfoWrapper<AbstractAttributes>> tableInfoWrapper) {
        super(context, tableInfoWrapper);
    }

    public List<Document> getDocument() {
        List<Document> documents = new ArrayList<Document>();

        addEmptyXML(documents);

        return documents;
    }

    public void addEmptyXML(List<Document> documents) {
        AbstractSpringXMLElement generator = new EmptySpringXMLElement("empty.xml", context,  tableInfoWrapper);
        documents.add(generator.getDocument());
    }
}
