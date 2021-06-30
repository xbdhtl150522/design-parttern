package proxy.dynamical.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 方式1
public class JdkProxyFactory01 {
    // 只能为实现了接⼝的类产⽣代理对象
    public static Object getProxy(Object target) {
        // 1.⽬标类的类加载器
        // 2.⽬标类的接⼝集合
        // 3.代理对象被调⽤时的调⽤处理器
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        Object result = method.invoke(target, args);
                        System.out.println("结束事务");
                        return result;
                    }
                });
        // 1.JDK在运⾏时根据代理类的规则以及⽬标类相关信息，编写代理类的源代码（.java）
        // 2.JDK对java源代码进⾏编译（.class）
        // 3.JDK根据⽬标类的类加载器，去将代理类的class⽂件加载到JVM中
        // 4.JVM会根据加载到的class信息，产⽣⼀个代理对象
        return proxy;
    }

}
