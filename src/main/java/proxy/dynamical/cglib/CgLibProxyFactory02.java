package proxy.dynamical.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//方式二
public class CgLibProxyFactory02 implements MethodInterceptor {

    /**
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz) {
        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置需要增强的类的类对象
        enhancer.setSuperclass(clazz);
        // 设置回调函数
        enhancer.setCallback(this);
        // 获取增强之后的代理对象
        return enhancer.create();
    }

    /***
     * Object proxy:这是代理对象，也就是[⽬标对象]的⼦类
     * Method method:[⽬标对象]的⽅法
     * Object[] arg:参数
     * MethodProxy methodProxy：代理对象的⽅法
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] arg,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        // 因为代理对象是⽬标对象的⼦类
        // 该⾏代码，实际调⽤的是⽗类⽬标对象的⽅法
        // 通过调⽤⼦类[代理类]的invokeSuper⽅法，去实际调⽤[⽬标对象]的⽅法
        // 代理对象调⽤代理对象的invokeSuper⽅法，⽽invokeSuper⽅法会去调⽤⽬标类的invoke⽅法完成⽬标对象的调⽤
        Object returnValue = methodProxy.invokeSuper(proxy, arg);
        System.out.println("结束事务");
        return returnValue;
    }
}
