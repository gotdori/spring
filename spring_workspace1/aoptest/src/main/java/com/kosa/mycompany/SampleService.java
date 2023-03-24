package com.kosa.mycompany;

public interface SampleService {
	public void displayName();
	public void displayNumber();
	//중요사항 - AOP에서 사용 할 메서드는 반환갑이 Object 류여야 한다.
	public Object displayNumber(int limit);
	public void guguDan(int dan);
}
