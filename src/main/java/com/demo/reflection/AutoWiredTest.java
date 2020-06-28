package com.demo.reflection;

import com.demo.reflection.annotation.AutoWired;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * @author lyz
 */
public class AutoWiredTest {
    @Test
   public void testAutoWired (){
        /**
         * 简易实现 直接new一个controller
         * 正常应该配置controller包路径, 然后读取配置
         * 根据包路径, 遍历所有controller 执行以下方法
         */
       TestController controller = new TestController();
        Class<? extends TestController> clazz = controller.getClass();
        Field[] fields = clazz.getDeclaredFields();
        // lamda表达式写法
        Stream.of(fields).filter(field -> field.getAnnotation(AutoWired.class) != null)
                .forEach(field ->{
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    try {
                        Object service = type.newInstance();
                        field.set(controller,service);
                        System.out.println(controller.getService());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }});
        // for循环
//        for (Field field : fields) {
//            field.setAccessible(true);
//            AutoWired annotation = field.getAnnotation(AutoWired.class);
//            if (null != annotation){
//                Class<?> type = field.getType();
//                try {
//                    Object service = type.newInstance();
//                    field.set(controller,service);
//                    System.out.println(controller.getService());
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
   }
}
