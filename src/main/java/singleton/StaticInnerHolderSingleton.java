package singleton;

/*静态内部类单例*/
public class StaticInnerHolderSingleton {

    private StaticInnerHolderSingleton() {

    }

    /* 获取实例 */
    public static StaticInnerHolderSingleton getSingletonInstance() {
        return SingletonFactory.staticInnerHolderSingleton;
    }

    /*
     * 此处使⽤⼀个内部类来维护单例 JVM在类加载的时候，是互斥的，所以可以由此保证线程安全问题
     */
    public static class SingletonFactory {
        private static StaticInnerHolderSingleton staticInnerHolderSingleton = new StaticInnerHolderSingleton();
    }
}
