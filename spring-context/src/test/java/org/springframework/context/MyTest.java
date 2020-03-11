package org.springframework.context;

import org.junit.Test;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tangmingjian 2020-02-29 下午7:21
 **/
public class MyTest {
	@Test
	public void test(){

		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
		RootBeanDefinition bd = new RootBeanDefinition();
		bd.setBeanClass(A.class);
		bd.getPropertyValues().add("name","jack");
		bd.getPropertyValues().add("email","jack@126.com");
		context.registerBeanDefinition("a",bd);

		final String beanClassName = bd.getBeanClassName();
		ChildBeanDefinition cbd = new ChildBeanDefinition("a");
		cbd.setBeanClass(B.class);
		context.registerBeanDefinition("b",cbd);

		final Object a = context.getBean("a");

		final Object b = context.getBean("b");
	}

	public static class A{
		private String name;
		private String email;

		public A() {
		}

		public A(String name, String email) {
			this.name = name;
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

	public static  class B{
		private String name;
		private int age;
//		private String email;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

//		public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}
	}
}
