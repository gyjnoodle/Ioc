package com.gyj.ioc;

import com.gyj.ioc.annotations.MyAutowired;
import com.gyj.ioc.controller.UserController;

import java.lang.reflect.Field;

public class Application {
    public static void main(String[] args) {
        UserController userController = new UserController();
        //获取userController运行类
        Class<? extends UserController> clazz = userController.getClass();
        //获取所有声明的字段
        for(Field field:clazz.getDeclaredFields()){
            //获取注解类
            MyAutowired myAutowired = field.getAnnotation(MyAutowired.class);
            if(myAutowired != null){
                field.setAccessible(true);
                //获取类型
                Class<?> type = field.getType();
                try {
                    //实例化
                    Object o = type.newInstance();
                    //将实例化的类设置到userController
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(userController.getUserService().findById(1));

    }
}
