package com.yedam.spring.tx.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
	//����Ʈ�� : ����Ͻ� ������ ���õ� �޼ҵ� �߿��� Advice(���� �ڵ�)�� ����� �޼ҵ�
	@Pointcut("within(com.yedam.spring.tx.service.*)")
	public void allPointCut() {}
	
	//Weaving : ����Ʈ�� + Advice + Ÿ�̹�
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		//Aop�� ����Ǵ� �޼ҵ��� �̸�
		String signatureStr = joinpoint.getSignature().toString();
		System.out.println("���� : " + signatureStr);
		
		//������
		System.out.println("�ٽ� ��� �� ���� - ���� ��� :" + System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			System.out.println("�ٽ� ��� �� ���� - ���� ��� :" + System.currentTimeMillis());
			System.out.println("�� : " + signatureStr);
		}
		
		
	}
}
