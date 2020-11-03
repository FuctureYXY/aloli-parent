package com.aloli.service;

import com.aloli.annotation.aop.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


//目前配置aop步骤
// 1.配置aop依赖
// 然后设置这个aop 即可


/**
 * AOP注解说明：
 *
 * @Aspect 定义切面：切面由切点和增强（引介）组成(可以包含多个切点和多个增强)，
 * 它既包括了横切逻辑的定义，也包括了连接点的定义，
 * SpringAOP就是负责实施切面的框架，它将切面所定义的横切逻辑织入到切面所指定的链接点中。
 *
 *
 *
 * @Pointcut 定义切点：切点是一组连接点的集合。AOP通过“切点”定位特定的连接点。通过数据库查询的概念来理解切点和连接点的关系再适合不过了：连接点相当于数据库中的记录，而切点相当于查询条件。
 * @Before ：在目标方法被调用之前做增强处理,@Before只需要指定切入点表达式即可。
 * @AfterReturning ： 在目标方法正常完成后做增强,@AfterReturning除了指定切入点表达式后，还可以指定一个返回值形参名returning,代表目标方法的返回值。
 * @Afterthrowing： 主要用来处理程序中未处理的异常,@AfterThrowing除了指定切入点表达式后，还可以指定一个throwing的返回值形参名,可以通过该形参名来访问目标方法中所抛出的异常对象。
 * @After： 在目标方法完成之后做增强，无论目标方法时候成功完成。@After可以指定一个切入点表达式。
 * @Around： 环绕通知, 在目标方法完成前后做增强处理, 环绕通知是最重要的通知类型, 像事务, 日志等都是环绕通知, 注意编程中核心是一个ProceedingJoinPoint。
 */


@Aspect
@Component
public class LogAspect {
    //切点
    //@Pointcut("@annotation(com.aloli.annotation.aop.Action)")
    //public void annotationPoinCut(){}

    //@After("annotationPoinCut()")



    @After("@annotation(com.aloli.annotation.aop.Action)")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 "+action.name());
    }
    @Before("execution(* com.aloli.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("前置通知,"+method.getName());
    }
    @After("execution(* com.aloli.service.DemoMethodService.*(..))")
    public void After2(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("后置通知,"+method.getName());
    }

    @AfterReturning("execution(* com.aloli.service.DemoMethodService.*(..))")
    public void AfterReturning(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("后置通知returning,"+method.getName());
    }
    //可以知道 环绕通知是  在  前置通知前     方法执行完后   调用after 等后面的操作之前执行
    @Around("execution(* com.aloli.service.DemoMethodService.*(..))")
    public void Around(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("环绕通知开始,"+method.getName());
        joinPoint.proceed();
        System.out.println("环绕通知结束,"+method.getName());
    }
}
