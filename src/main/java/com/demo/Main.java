package com.demo;


import com.demo.Interfaces.IBrowseTimes;
import com.demo.entity.Goods;
import com.demo.entity.News;
import com.demo.factory.BrowseFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String args[])  {

            String type = "goods";
        if(type.equals("goods")){
            News news = new News();
            news.addBrowse();
        }else if (type.equals("news")){
            Goods goods = new Goods();
            goods.addBrowse();
        }



        for (int i = 0; i<2; i++) {
             new Thread(()->{
                IBrowseTimes browse = BrowseFactory.getBrowseService(type);
                for (int j = 0; j<100; j++){
                    browse.addBrowse();
                    browse.getBrowseTimes();
                }

            }).start();
        }



//        String checkType = "share";
//        Integer integral = 100;
//        AjaxResult res = Factory.getCheck(checkType).addIntegral(integral);
//        if (res.isSuccess()){
//            System.out.println(res.getMsg());
//        }






//        FilterChain chain = new FilterChain();
//        chain.setMsg("<sdfsdf>");
//        String msg = chain.msgProsess();
//        System.err.println(msg);


//        String text = "asdfgh";
//        System.out.println("A=========="+ StringUtils.startsWith(text,"A"));
//        System.out.println("ad=========="+ StringUtils.startsWith(text,"a"));
//        System.out.println("ad=========="+ StringUtils.startsWith(text," "));


//        int[] a = {1,8,6,2,5,4,8,3,7};        //demo4
//        System.out.println( arrMax(a));



//        T ren = new T();       demo1
//        test(ren);

//        int len = lengthOfLongestSubstring("28a9asd13456723456789asd");   //demo2
//        System.out.println(len);

//        int[] a = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> list = demo3(a);
//        System.out.println(list);

//         String[] demo5 = new String[]{"flower","flow","flight"};
//        String commonStr = longestCommonPrefix(demo5);
//        System.out.println(commonStr);

    }

    public static String longestCommonPrefix(String[] strs) {   // demo4
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }






    public static List<List<Integer>> demo3(int[] arr){
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

    public static int arrMax(int[] a){      //demo4  双指针
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


    public static int addSum(int a, int b){
        int sum = 0;
        for(int i=a; i<b;i++){
                sum +=i;
        }
        return sum;
    }
    // 滑动窗口式 返回字符串中 最大不重复子字符串长度
    public static int lengthOfLongestSubstring(String s) {          //demo2
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {

            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }



    static <T extends People> void test(T t){    // demo1
        t.eat();
        t.sleep();
        t.work();
    }
}
