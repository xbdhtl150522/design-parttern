package singleton;

import java.io.Serializable;

/*双重检查锁单例*/
public class DoubleCheckLockSingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private DoubleCheckLockSingleton() {

    }

    // 存储单例实例
    // volatile：
    // 1、禁止指令重排序
    // 2、保证可见性
    private volatile static transient DoubleCheckLockSingleton doubleCheckLockSingleton;

    public static DoubleCheckLockSingleton getInstance() {
        if (null == doubleCheckLockSingleton) {
            // B线程检测到student不为空
            synchronized (DoubleCheckLockSingleton.class) {
                if (null == doubleCheckLockSingleton) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                    // A线程被指令重排了，刚好先赋值了；但还没执行完构造函数。
                }
            }
        }
        return doubleCheckLockSingleton;// 后面B线程执行时将引发：对象尚未初始化错误。
    }

    private Object readResolve() {
        return doubleCheckLockSingleton;
    }

}
