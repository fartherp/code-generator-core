/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml;

/**
 * element interface
 * Author: CK.
 * Date: 2015/6/6.
 */
public interface Element {
    /**
     * element content
     * @param indentLevel the level is control out format, like <b>Tab</b>
     * @return the result String
     */
    String getFormattedContent(int indentLevel);
}
