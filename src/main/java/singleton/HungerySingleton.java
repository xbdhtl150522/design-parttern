package singleton;

/*饿汉式*/
public class HungerySingleton {
    // 1：构造私有
    private HungerySingleton() {
    }

    // 2：成员变量初始化本身对象
    private static HungerySingleton hungerySingleton = new HungerySingleton();

    // 3：对外提供公共⽅法获取对象
    public static HungerySingleton getSingletonInstance() {
        return hungerySingleton;
    }

}
