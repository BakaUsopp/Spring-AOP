package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

//    @Before("execution(* services.HelloService.hello(..))")
//    public void before(){
//        System.out.println("Aspect");
//    }

    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("A");
        Object result = null;
        try {
             result = joinPoint.proceed(new Object[]{"Bill"});
            System.out.println("B");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return result;

    }
}
