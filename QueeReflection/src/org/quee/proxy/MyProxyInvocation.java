package org.quee.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 传统的动态代理
 * @author 15161
 *
 * @param <T>
 */
public class MyProxyInvocation <T>implements InvocationHandler{
	private  T person;
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("haha!");
		Object result = method.invoke(person, args);
		return result;
	}
	
	public MyProxyInvocation(T person) {
		
		this.person = person;
	}
	
	
	public  Object lambdaInvoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("haha!");
		Object result = method.invoke(person, args);
		return result;
	}

	
	public <E>  T getProxyPerson() {
		
		
		MyProxyInvocation<T> proxy = new MyProxyInvocation<T>(person);
		
		@SuppressWarnings("unchecked")
		T proxyPerson = (T) Proxy.newProxyInstance(MyProxyInvocation.class.getClassLoader(),
				person.getClass().getInterfaces(),proxy);
		
		
		return proxyPerson;
	}

	
}
