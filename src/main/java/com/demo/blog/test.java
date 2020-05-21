package com.demo.blog;

public  class   test {
     /// 泛型demon
    public static void main(String[] args) {
        String[] a = new String[0];
        int c =1 ,b=2;


//        System.out.println(b+c>3);


        System.out.println( FX(a));
    }

    private static <T>  Boolean  FX(T t){  /// 泛型测试类 且给泛型设置了上限

        return t.toString().isEmpty();
    }


}
