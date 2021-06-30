package proxy.dynamical.jdk;

import com.sun.istack.internal.NotNull;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//仿写JDK动态代理
public class JdkProxyImitate {

    private static final String ln = "\r\n";

    public static void main(String[] args) {
        UserServiceImpl target = new UserServiceImpl();
        UserService proxy = (UserService) newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object result = method.invoke(target, args);
                System.out.println("关闭事务");
                return result;
            }
        });
        proxy.saveUser();
    }

    public static Object newProxyInstance(ClassLoader classLoader, @NotNull Class<?>[] interfaces, @NotNull InvocationHandler handler) {
        try {
            // 1.根据目标类的接口信息，去动态编写代理对象的源代码（java代码---字符串）
            String sourceCode = generateSourceCode(interfaces);
            String path = JdkProxyImitate.class.getResource("").getPath();
            File f = new File(path + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(sourceCode);
            fw.close();
            // 2.使用JDK自带的API完成javac编译功能，将java源代码编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            // 3.使用目标类对应的类加载器完成代理类的class文件的类加载
            Class<?> clazz = classLoader.loadClass("$Proxy0");
            // 4.而JVM就会根据代理类的class信息创建代理对象。
            Constructor<?> constructor = clazz.getDeclaredConstructor(InvocationHandler.class);
            // newInstance第三个参数也有用了
            Object proxy = constructor.newInstance(handler);
            return proxy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSourceCode(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package proxy.dynamical.jdk;" + ln);
        sb.append("import java.lang.reflect.InvocationHandler;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy" + 18 + " implements ");
        for (int i = 0; i < interfaces.length; i++) {
            sb.append(interfaces[0].getName());
            if (i != interfaces.length - 1) sb.append(",");
        }
        sb.append(" { " + ln);
        sb.append("private InvocationHandler h;" + ln);
        sb.append("public $Proxy" + 18 + "(InvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);
        //遍历接口中的方法
        sb.append("private static Method m1;" + ln);
        //遍历接口中的方法
        sb.append("public void saveUser() {" + ln);
        sb.append("try {" + ln);
        sb.append("h.invoke(this, m1, null);" + ln);
        sb.append("} catch (Throwable e) {" + ln);
        sb.append("e.printStackTrace();" + ln);
        sb.append("}" + ln);
        sb.append("}" + ln);
        sb.append("static {" + ln);
        sb.append("try {" + ln);
        //遍历接口中的方法
        sb.append("m1 = Class.forName(\"proxy.dynamical.jdk.UserServiceImpl\").getDeclaredMethod(\"saveUser\");" + ln);
        sb.append("} catch (Exception e) {" + ln);
        sb.append("e.printStackTrace();" + ln);
        sb.append("}" + ln);
        sb.append("}" + ln);
        sb.append("}" + ln);
        return sb.toString();
    }

}
