package AopPractice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    /**
     * @param joinPoint contains the key info of the target method
     * @Before means this is a 'before' advice, which runs before the method execution
     */
    @Before(value = "@annotation(Action)")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "Start implementing the method...");
    }

    /**
     * @param joinPoint contains the key info of the target method
     * @After means this is a 'after' advice, which runs after the method execution
     */
    @After("@annotation(Action)")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "Complete implementing the method...");
    }

    /**
     * @param joinPoint
     * @AfterReturning only if the method completes successfully. 'returning' in this annotation means the variable of returned value from the target method
     *                 The type fo the returned value from the target method should be the same with the type of the returned parameter in this method.
     */
    @AfterReturning(value = "@annotation(Action)", returning = "r")
    public void returning(JoinPoint joinPoint, Integer r) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "The method returns: " + r);
    }

    /**
     * After-throwing
     * @param joinPoint
     * @param e the exception thrown by the target method.
     */
    @AfterThrowing(value = "@annotation(Action)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "The method throws an exception: " + e.getMessage());
    }

    /**
     * 'Around' advice
     * @param pjp
     * @return In this case, it is better to define the type of the returned value to be 'Object'.
     */
    @Around("@annotation(Action)")
    public Object around(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
