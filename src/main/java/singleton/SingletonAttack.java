package singleton;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonAttack {

    public static void main(String[] args) throws Exception {
        System.out.println(reflectionAttack());
        System.out.println(serializationAttack());
    }

    /*反射攻击*/
    public static boolean reflectionAttack() throws Exception {
        Constructor<DoubleCheckLockSingleton> constructor = DoubleCheckLockSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        DoubleCheckLockSingleton doubleCheckLockSingleton = constructor.newInstance();
        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
        return instance.equals(doubleCheckLockSingleton);
    }

    /*序列化攻击*/
    public static boolean serializationAttack() throws Exception {
        // 对象序列化流去对对象进⾏操作
        ObjectOutputStream outputStream = new ObjectOutputStream(new
                FileOutputStream("serFile"));
        //通过单例代码获取⼀个对象
        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
        //将单例对象，通过序列化流，序列化到⽂件中
        outputStream.writeObject(instance);
        // 通过序列化流，将⽂件中序列化的对象信息读取到内存中
        ObjectInputStream inputStream = new ObjectInputStream(new
                FileInputStream(new File("serFile")));
        //通过序列化流，去创建对象
        DoubleCheckLockSingleton instance2 = (DoubleCheckLockSingleton) inputStream.readObject();
        return instance.equals(instance2);
    }

    /*
     *要防御序列化攻击，就得将instance声明为transient，并且在单例中加⼊以下语句：
     *private Object readResolve() { return instance; }
     *注意static修饰的静态变量天然就是不可序列化的,所以上述例子不需要加transient
     * */


}
