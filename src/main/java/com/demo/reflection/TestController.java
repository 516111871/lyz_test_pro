package com.demo.reflection;

import com.demo.reflection.annotation.AutoWired;

/**
 * @author lyz
 * 实现AutoWired注解测试
 */
public class TestController {
    private void setService(TestService service) {
        this.service = service;
    }

    @AutoWired
    private TestService service;

    public TestService getService() {
        return service;
    }
}
