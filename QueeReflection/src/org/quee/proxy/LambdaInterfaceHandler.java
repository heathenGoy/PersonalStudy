package org.quee.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.quee.domain.Person;
/**
 * lambda���ʽ����
 * @author 15161
 *
 */
public class LambdaInterfaceHandler {
	

	
	/**
	 * ʹ��lambda���ʽֱ�ӻ�ȡ��ȡ�÷���, 
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Throwable
	 */
	public static Object invoke(Object proxy, Method method, Object[] args){
		
		System.out.println("haha!");
		String name = method.getName();
		System.out.println("methodName:" + name);
		Class<?>[] parameterTypes = method.getParameterTypes();
		System.out.println("params:" + Arrays.toString(parameterTypes));
		//Class<?> returnType = method.getReturnType();
		Type returnType = method.getGenericReturnType();
		System.out.println("return:" + returnType);
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		System.out.println("genericParams:" + Arrays.toString(genericParameterTypes));
		
		
			
			if(((Class<?>) returnType).isPrimitive()) {
				System.out.println("�ǻ����������͵ķ���ֵ");
				
				if(returnType == int.class) {
					
					return 0;
				}
			}
			
			
		
	
		return null;
		
	}
	

	
	public static <T> T getProxy(Class<T> interfaceType) {
		Class<?>[] clazzs = new Class[] {interfaceType};
		@SuppressWarnings("unchecked")
		T proxyPerson = (T)Proxy.newProxyInstance(LambdaInterfaceHandler.class.getClassLoader(),
				clazzs, LambdaInterfaceHandler::invoke);
		//lambda���ʽʡ����new ������鷳, �������ܱ��ڲ���Ҫ��
		
		return proxyPerson;
	}

	
}
