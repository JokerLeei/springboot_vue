/*
package com.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.DirectReceiver;

*/
/**
 * spring boot 配置 aop
 *
 * JoinPoint(连接点)：类里面可以被增强的方法即为连接点。
 * 例如想修改哪个方法的功能，那它就是连接点
 * PointCut(切入点)：对JoinPoint进行拦截的定义即为切入点。
 * 例如拦截所有以insert开始的方法，那这个定义即为切入点
 * Advice(通知)：拦截到JoinPoint之后所要做的事情就是通知。
 * Aspect(切面)：PointCut + Advice
 * Target(目标对象)：要增强的类称为 Target
 *
 * LogAspect 自定义切面类
 *//*

*/
/*@DirectReceiver*//*

*/
/*@Aspect*//*

public class LogAspect {
    */
/*
        定义切入点
    *//*

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void pc1() {
    }

    */
/*
        前置通知：在目标方法执行前执行
        通过JoinPoint可以获取目标方法的方法名，修饰符等信息
    *//*

    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行...");
    }

    */
/*
        后置通知：在目标方法执行后执行
    *//*

    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束...");
    }

    */
/*
        返回通知：可以获取目标方法的返回值
        注意：若将参数result类型改变为Long或其他，则该方法只能处理目标方法返回值为Long或其他类型的情况
    *//*

    @AfterReturning(value = "pc1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值为：" + result);
    }

    */
/*
        异常通知：当目标方法抛出异常时这个通知会调用
        注意：若改变参数e的类型，则目标方法抛出这个类型时才会执行此通知
            此处为Exception，即目标方法抛出任何异常都会执行下面这个方法
    *//*

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
    }

    */
/*
        环绕通知：所有通知里最强大的通知，可以实现前置、后置、异常、返回通知的功能
            目标方法进入环绕通知后，通过调用 ProceedingJoinPoint 对欸选哪个的 proceed 方法使目标方法继续执行，开发者可以在此修改
        目标方法的执行参数，返回值等，并且可以再次处理目标方法的异常
    *//*

    @Around(value = "pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
*/
