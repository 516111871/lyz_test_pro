package com.demo.myFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    List<Ifilters> filterList = new ArrayList<>();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;


    public String msgProsess(){
        this.addFilter(new HtmlFilter()).addFilter(new MgWordsFilter()).addFilter(new FaceFilter());
        for (Ifilters f : filterList){
           msg = f.doFilter(msg);
        }
        return msg;
    }

    public  FilterChain addFilter(Ifilters f){
        filterList.add(f);
        return this;
    }
}
