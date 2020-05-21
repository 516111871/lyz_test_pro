package com.demo.Interfaces;

import java.util.concurrent.atomic.AtomicInteger;

public interface IBrowseTimes {
    /**
     * 添加浏览次数
     */
    void addBrowse();
    /**
     * 获取浏览次数
     */
    AtomicInteger getBrowseTimes();
}
