package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;

//상속도 안받고 그냥 POJO(Plain old java Object)
//초창기에는 
public class AdviceUsingXML {

	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		//ProceedingJointPoint - 매개변수 타입
		System.out.println("arround start");
		
		//함수를 납치해온다. jointPoint에 함수에 대한 모든 정보가 있다.
		//proceed 함수를 이용해 원래의 함수를 호출한다.
		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		
		System.out.println("클래스명 : " + classname);
		System.out.println("클래스명 : " + methodname);
		
		long time1 = System.currentTimeMillis(); //시작시간을 가져온다
		Object retVal = joinPoint.proceed(); //원래의 함수 호출
		long time2 = System.currentTimeMillis(); //종료시간을 가져온다
		
		System.out.println("실행시간 : " + (time2-time1)+"밀리초");
		System.out.println("arround end");
		
		return retVal; //함수의 반환값을 보낸다.
	}
}
