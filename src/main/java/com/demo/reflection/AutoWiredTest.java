package com.demo.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lyz
 * 测试反射获取属性 赋值
 */
public class AutoWiredTest {
    @Test
    public void test() throws Exception {
        TestController controller = new TestController();
        Class<? extends TestController> clazz = controller.getClass();
        TestService t = new TestService();
        System.out.println(t);
        Field field = clazz.getDeclaredField("service");
        field.setAccessible(true);
        String fieldName = field.getName();
        String upperName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
        String methodName = "set" + upperName;
        Method method = clazz.getDeclaredMethod(methodName, TestService.class);
        method.setAccessible(true);
        method.invoke(controller, t);
        System.out.println(controller.getService());
    }
}
