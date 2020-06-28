package com.demo;


import com.demo.Interfaces.IBrowseTimes;
import com.demo.check.factory.Factory;
import com.demo.common.untils.AjaxResult;
import com.demo.factory.BrowseFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String args[])  {
        HashMap<String,Object> map = new HashMap<>();
        map.put("status","1");
        System.err.println("1".equals(map.get("status")));
        System.err.println("mydev up to git for test merge");
//------------------------------------------------------------------------------------------------
        // optional

//        String abd = "";
//        sdfsf(abd);
//------------------------------------------------------------------------------------------------
        //        String text = "asdfgh";
//        System.out.println("A=========="+ StringUtils.startsWith(text,"A"));
//        System.out.println("ad=========="+ StringUtils.startsWith(text,"a"));
//        System.out.println("ad=========="+ StringUtils.startsWith(text," "));
//------------------------------------------------------------------------------------------------
        String type = "goods";
        addBrowse(type);
//------------------------------------------------------------------------------------------------
//        String checkType = "share";
//        Integer integral = 100;
//        addIntegral(checkType, integral);
//        //demo4
//        int[] a = {1,8,6,2,5,4,8,3,7};
//        System.out.println( arrMax(a));
//------------------------------------------------------------------------------------------------
//
//        // demo1
//        T ren = new T();
//        test(ren);
//------------------------------------------------------------------------------------------------
//
//
//        int[] b = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> list = Main.demo3(b);
//        System.out.println(list);
//------------------------------------------------------------------------------------------------
//         String[] demo5 = new String[]{"flower","flow","flight"};
//        String commonStr = longestCommonPrefix(demo5);
//        System.out.println(commonStr);

    }

    private static void sdfsf(String abd) {
        System.err.println(Optional.of(abd).isPresent());
    }


    private static void test(T t) {
        t.eat();
        t.sleep();
        t.work();

    }

    private static int arrMax(int[] a) {    // 双指针
        int last=0,l=0,r=a.length-1;
        while(l<r){
            last =Math.max(last,Math.min(a[l],a[r])*(r-l));
            if(a[l]>a[r]){
                r--;
            }else{
                l++;
            }
        }
        return last;
    }

    private static String longestCommonPrefix(String[] strs) {   // demo4
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    private static List<List<Integer>> demo3(int[] arr){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            List<Integer> myList = new ArrayList<>();
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if (sum == 0){
                        myList.add(arr[i]);
                        myList.add(arr[j]);
                        myList.add(arr[k]);
                    }
                }
            }
            if (!myList.isEmpty()){
                list.add(myList);
            }
        }
        return list;
    }


    private static void addBrowse(String type) {
//        if(type.equals("goods")){
//            News news = new News();
//            news.addBrowse();
//        }else if (type.equals("news")){
//            Goods goods = new Goods();
//            goods.addBrowse();
//        }

        for (int i = 0; i<2; i++) {
             new Thread(()->{
                IBrowseTimes browse = BrowseFactory.getBrowseService(type);
                for (int j = 0; j<100; j++){
                    browse.addBrowse();
                    browse.getBrowseTimes();
                }

            }).start();
        }
    }

    private static void addIntegral(String checkType, Integer integral) {

        AjaxResult res = Factory.getCheck(checkType).addIntegral(integral);
        if (res.isSuccess()) {
            System.out.println(res.getMsg());
//        }
        }

    }






}
