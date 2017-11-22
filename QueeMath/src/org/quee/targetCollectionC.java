package org.quee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 使用了函数式接口BiConsumer来提供给用户操作组合的接口
 * 性能: 
 * @author 15161
 *
 */
public class targetCollectionC {
	//排列: combination, 组合: Arragement
	
	
	
	//change
	private static int sum = 0;
	private static int currentDepth;
	private static int[] currentDepthArr;
	
	//not change
	private static int depth;
	private static BiConsumer<int[], Integer> consumer;
	private static int[] targetArr;
	
	
	public static void cIterating(int[] arr,int depth, BiConsumer<int[], Integer> targetConsumer ) {
		targetArr = arr;
		cIterating(depth,targetConsumer);
		
	}
	
	public static void cIterating(int targetDepth, BiConsumer<int[], Integer> targetConsumer ) {
		//init
		depth  = targetDepth;
		currentDepth = targetDepth;
		currentDepthArr = new int[depth];
		System.out.println("create currentDepthArr, its length:" + currentDepthArr.length);
		consumer = targetConsumer;
		
		
		//do
		recursion(-1);
		
		//finally
		currentDepthArr = null;
		sum = 0;
	}
	
	public static void recursion(int last) {
		currentDepth--;
		
		if (currentDepth >= 0) {
			arrRecord(last);
		}
		
		currentDepth++ ;
		
	}

	private static void arrRecord(int last) {
		for (int i = last + 1; i < targetArr.length; i++) {
			
			//在数组合适的位置记录这次遍历的值
			currentDepthArr[depth - currentDepth -1 ] = i;
			//System.out.println("depth:" + depth + "  i:" + i);
			
			//到达了足够的深度(用户设定的组合数),返回给用户 
			if(currentDepth == 0) {
				//System.out.println("sum:" + ++sum);
				//System.out.println("array" + Arrays.toString(depthArr));
				
				//返回响应的数组, 以便用户处理
				sum ++;
				returnArr();
				
			}
			
			//递归开始!!
			recursion(i);
		}
	}
	
	public static void returnArr() {
		int[] returnArr = new int[depth];
		
		for (int i = 0; i< returnArr.length; i++) {
			
			returnArr[i] = targetArr[currentDepthArr[i]];
		}
		
		consumer.accept(returnArr , sum);
	}
	
	
	
		
	public static void main(String[] args) {
		
		int[] targetArr = {1,3,5,7,9,11};
		
		cIterating(targetArr,5, (int[] arr, Integer sum) ->{
			System.out.println("目前找到的组合总数: " + sum);
			System.out.println("这是遍历组合数的结果: " + Arrays.toString(arr));
			
		});
		
	}
		
	
}
