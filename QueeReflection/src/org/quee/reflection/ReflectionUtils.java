package org.quee.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.junit.Test;
import org.quee.domain.Student;

public class ReflectionUtils {
	

	/**
	 * 结果method返回的type(getGeneticParams)比class(getParams)的信息更多, 支持map,collection泛型里面的具体值
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test() throws ClassNotFoundException {

		
		Class<?> clazz = Student.class;
		
		Method[] methods = clazz.getMethods();
		
		
		
		for (Method method : methods) {
			Class<?>[] paraTypes = method.getParameterTypes();
			Type[] genericParameterTypes = method.getGenericParameterTypes();
			
			
			System.out.println(method.getName());
			System.out.println("classes:" + Arrays.toString(paraTypes));
			System.out.println("types:" + Arrays.toString(genericParameterTypes));
			System.out.println(method.toGenericString());
			System.out.println("=======================");
		}
		
	}
	
	
	

}
