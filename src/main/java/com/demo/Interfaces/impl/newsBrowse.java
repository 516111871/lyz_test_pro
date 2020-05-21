package com.demo.Interfaces.impl;

import com.demo.Interfaces.IBrowseTimes;

import java.util.concurrent.atomic.AtomicInteger;

public class newsBrowse implements IBrowseTimes {
    private AtomicInteger browseTimes = new AtomicInteger(0);

    @Override
    public AtomicInteger getBrowseTimes() {
        return browseTimes;
    }
    @Override
    public void addBrowse() {
        System.out.println("动态浏览量+1 : "+browseTimes.incrementAndGet());
    }
}
