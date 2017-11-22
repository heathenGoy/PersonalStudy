package org.quee.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.quee.domain.Student;

public class DaoHandler{

	public static Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		
		
		if("add".equals(methodName)) {
			
			Long sum = 0L;
			for (Object eachNum : args) {
				Long num = ((Integer)eachNum).longValue();
				sum += num;
			}
			Class<?> returnType = method.getReturnType();
			if(returnType == int.class ||returnType == Integer.class) {
				
				return sum.intValue();
			}else {
				return sum;
			}
			
			
		}else if(methodName.startsWith("select")) {
			
			System.out.println("select * from " + method.getReturnType().getSimpleName()
					+ "where " +  methodName.substring(8) +" " + args[0]);
			Student s = new Student();
			s.setScore(333);
			return s;
			
		}
		return null;
	}
	
	public static <T> T getProxy(Class<T> interfaceType) {
		Class<?>[] clazzs = new Class[] {interfaceType};
		@SuppressWarnings("unchecked")
		T proxyPerson = (T)Proxy.newProxyInstance(LambdaInterfaceHandler.class.getClassLoader(),
				clazzs, DaoHandler::invoke);
		//lambda表达式省略了new 对象的麻烦, 并且性能比内部类要好
		
		return proxyPerson;
	}
}
