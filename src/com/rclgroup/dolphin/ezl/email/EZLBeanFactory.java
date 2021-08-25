package com.rclgroup.dolphin.ezl.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

 
public class EZLBeanFactory {
	private static ApplicationContext ctx = null;
	private static ApplicationContext ctxSpringJdbc = null;

	private EZLBeanFactory() {

	}

	public static Object getBean(String beanName) {

		if (ctx == null) {
			ctx = new FileSystemXmlApplicationContext(
					EZLBeanFactory.class.getResource("./").toString()+"../../../../../../applicationContext-jdbc.xml");

		}
		return ctx.getBean(beanName);
	}
	public static Object getBeanSpringJdbc(String beanName) {

		if (ctxSpringJdbc == null) {
			ctxSpringJdbc = new FileSystemXmlApplicationContext(
					EZLBeanFactory.class.getResource("./").toString()+"../../rcl/resource/ES-SpringJdbc.xml");

		}
		return ctxSpringJdbc.getBean(beanName);
	}

}
