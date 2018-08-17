package com.revature.main;

import com.revature.config.HibernateConfig;
import com.revature.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Driver
{
    public static void main(String[] args)
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService.getAllUsers());

        context.close();

    }
}
