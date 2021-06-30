package proxy.dynamical.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 方式2（推荐）
public class JdkProxyFactory02 implements InvocationHandler {

    // ⽬标对象的引⽤
    private Object target;

    // 通过构造⽅法将⽬标对象注⼊到代理对象中
    public JdkProxyFactory02(Object target) {
        this.target = target;
    }

    // 只能为实现了接⼝的类产⽣代理对象
    public Object getProxy() {
        // 1.⽬标类的类加载器
        // 2.⽬标类的接⼝集合
        // 3.代理对象被调⽤时的调⽤处理器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    /**
     * 代理对象会执⾏的⽅法
     * 1.代理对象
     * 2.⽬标对象⽅法
     * 3.⽅法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强代码
        System.out.println("开启事务");
        // 下⾯的代码，是反射中的API⽤法
        // 该⾏代码，实际调⽤的是[⽬标对象]的⽅法
        // 利⽤反射，调⽤[⽬标对象]的⽅法
        Object result = method.invoke(target, args);
        // 增强代码
        System.out.println("结束事务");
        return result;
    }
}
