package DynamicProxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class CalculatorProxy {
    public static Object getInstance(final MyCalculatorImpl myCalculatorImpl) {
        return Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), myCalculatorImpl.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "Start implementing......");
                Object invoke = method.invoke(myCalculatorImpl, args);
                System.out.println(method.getName() + "Complete implementing");
                return invoke;
            }
        });
    }
}
