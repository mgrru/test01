package com.mgrru.test01.aop;

import java.sql.Timestamp;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.mgrru.test01.dao.IMLog;
import com.mgrru.test01.model.MLog;

@Aspect
@Component
@Async
public class MyLogAspect {

  @Autowired
  private IMLog iLog;

  @Before("@annotation(com.mgrru.test01.anno.logAnno) || @within(com.mgrru.test01.anno.logAnno)")
  public void beforeMethod(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    MLog mLog = new MLog(new Timestamp(new Date().getTime()), methodName);
    iLog.addLog(mLog);
  }
}
