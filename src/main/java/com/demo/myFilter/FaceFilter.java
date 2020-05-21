package com.demo.myFilter;

import java.util.Random;

public class FaceFilter implements Ifilters {
    private Random random = new Random();
    @Override
    public String doFilter(String msg) {
        System.err.println(random.nextInt());
        return msg.replace(":)","^v^");
    }
}
