package com.kosa.mycompany;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceimpl implements SampleService{

	@Override
	public void displayName() {
		System.out.println("홍길동");
	}

	@Override
	public void displayNumber() {
		int i, sum=0;
		for (i = 1; i <= 100; i++) {
			sum++;
		}
		System.out.println(String.format("합계 : %d", sum));
	}

	@Override
	public Object displayNumber(int limit) {
		int i, sum=0;
		for (i = 1; i <= limit; i++) {
			sum+=i;
		}
		return sum;
	}

	@Override
	public void guguDan(int dan) {
		for(int i=0; i<=9; i++) {
			System.out.println(String.format("%d x %d = %d", dan, i, dan*i));
		}
		
	}

	
}
