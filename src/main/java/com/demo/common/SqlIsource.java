package com.demo.common;

import com.jfinal.template.source.ISource;

public class  SqlIsource implements ISource {
    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public String getCacheKey() {
        return null;
    }

    @Override
    public StringBuilder getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/sql/blog.sql");
        return stringBuilder;
    }

    @Override
    public String getEncoding() {
        return null;
    }
}
