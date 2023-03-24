package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//자동으로 객체를 만들어야 한다.
//Aspect 설정도 되야하고 
@Component
@Aspect
public class AdviceUsingAnnotation {

	@Pointcut("execution(public * com.kosa.mycompany.*Serviceimpl.*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		//ProceedingJointPoint - 매개변수 타입
		System.out.println("arround start*******************************************");
		
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
		System.out.println("arround end*******************************************");
		
		return retVal; //함수의 반환값을 보낸다.
	}
	
}
