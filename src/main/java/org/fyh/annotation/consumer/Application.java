package org.fyh.annotation.consumer;

import java.io.IOException;

import org.fyh.annotation.consumer.service.ConsumerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args ) throws InterruptedException
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "application.xml" });
        context.start();
        
        ConsumerService cs = context.getBean(ConsumerService.class);
        cs.testRemoteDubboTest();
        try {
			System.in.read();// 让此程序一直跑，表示一直提供服务
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
