package org.quee.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Student implements Person{

	
	
	private Integer Score;
	
	
	
	public Integer getScore() {
		return Score;
	}
	public void setScore(Integer score) {
		Score = score;
	}
	
	
	@Override
	public void show(String word) {
		System.out.println(word);
		
	}

	public void test(String str,int i, Integer integer) {
		
	}
	
	public <T,E> void test2(Map<String,Object> col, Map<T,E> map, T[] ts, Collection<? extends Person> coll) {
		
	}
	
}
