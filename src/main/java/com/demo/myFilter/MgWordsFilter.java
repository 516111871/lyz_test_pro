package com.demo.myFilter;

public class MgWordsFilter implements Ifilters {
    @Override
    public String doFilter(String msg) {
        return msg.replace("敏感","666");
    }
}
