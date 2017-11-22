package org.quee.test;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.quee.domain.DaoInterface;
import org.quee.domain.Person;
import org.quee.domain.Student;
import org.quee.proxy.DaoHandler;
import org.quee.proxy.LambdaInterfaceHandler;
import org.quee.proxy.MyProxyInvocation;

public class ProxyTest {
	/**
	 * 传统的动态代理方式
	 */
	@Test
	public void  ConventionalProxy()	{
		
		Person person = new Student();
		
		//Person proxyPerson = new MyProxyInvocation(person).getProxyPerson();
		//使用泛型, 来对于任何实现类进行动态代理
		Person proxyPerson = new MyProxyInvocation<Person>(person).getProxyPerson();
		
		proxyPerson.show("hello");
		
		
	}
	
	/**
	 * 使用泛型, 对任何借口进行动态代理
	 * @throws InterruptedException 
	 */
	@Test
	public void InterfaceProxy() throws InterruptedException {
	/*	Person person = LambdaInterfaceHandler.getProxy(Person.class);
		System.out.println(person);
		person.show("he");
		Object hashCode = "" + person.hashCode();
		System.out.println(hashCode);*/
		
		DaoInterface proxy = DaoHandler.getProxy(DaoInterface.class);
		Student result = proxy.selectById("3");
		System.out.println("student's score: " + result.getScore());
		Integer add = proxy.add(4, 5);
		System.out.println("add:" + add);
		
	}
	
	
	
}
