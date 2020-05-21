package com.demo.myFilter;

public class HtmlFilter implements Ifilters {
    @Override
    public String doFilter(String msg) {
        String aaa = msg.replace("<", "[").replace(">", "]");
        return aaa;
    }
}
