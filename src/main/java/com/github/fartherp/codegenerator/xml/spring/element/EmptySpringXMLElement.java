/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.spring.element;

import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.config.SpringXMLConstants;
import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.TableInfoWrapper;
import com.github.fartherp.javaxml.Attribute;
import com.github.fartherp.javaxml.XmlElement;

import java.util.List;

/**
 * empty Spring generator
 * Author: CK.
 * Date: 2015/6/6.
 */
public class EmptySpringXMLElement extends AbstractSpringXMLElement<AbstractAttributes> {

    public EmptySpringXMLElement(String name, CodeGenContext context, List<TableInfoWrapper<AbstractAttributes>> ts) {
        super(name, context, ts);
    }

    public void getElement(XmlElement answer) {
        answer.addAttribute(new Attribute("\n\t\t\t\t" + SpringXMLConstants.XMLNS_SCHEMA_LOCATION,
                SpringXMLConstants.SPRING_BEANS + "\n\t\t\t\t" + SpringXMLConstants.SPRING_BEANS_XSD));
    }
}
