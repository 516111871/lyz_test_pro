package com.demo.myFilter;

public class MsgMain {
    public static void main(String[] args) {
        String msg = "<html>数量多付款健身房敏感:)";
        FilterChain chain = new FilterChain();
        chain.setMsg(msg);
        msg = chain.msgProsess();
        System.err.println(msg);
    }
}
