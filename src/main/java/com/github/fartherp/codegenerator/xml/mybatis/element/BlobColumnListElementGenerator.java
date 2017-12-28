/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.xml.mybatis.element;

import com.github.fartherp.codegenerator.db.AbstractAttributes;
import com.github.fartherp.codegenerator.db.ColumnInfo;
import com.github.fartherp.codegenerator.util.MyBatis3FormattingUtils;
import com.github.fartherp.javaxml.TextElement;

import java.util.Iterator;

/**
 * BLOB字段
 * Author: CK
 * Date: 2015/6/7
 */
public class BlobColumnListElementGenerator<T extends AbstractAttributes> extends AbstractXmlElementGenerator<T> {

    public void prepareXmlElement() {
        name = "sql";
        id = attributes.getBlobColumnList();
    }

    public void dealElements() {
        StringBuilder sb = new StringBuilder();

        Iterator<ColumnInfo> iter = tableInfoWrapper.getBlobColumns().iterator();
        while (iter.hasNext()) {
            sb.append(MyBatis3FormattingUtils.getSelectListPhrase(iter.next()));

            if (iter.hasNext()) {
                sb.append(", ");
            }

            if (sb.length() > 120) {
                answer.addElement(new TextElement(sb.toString()));
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            answer.addElement((new TextElement(sb.toString())));
        }
    }
}
