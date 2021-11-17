package noIfElse.工厂模式;

import noIfElse.枚举方式.RoleOperator;

import java.util.HashMap;
import java.util.Map;

//角色工厂
public class RoleFactory {

    static Map<String, RoleOperator> map = new HashMap();

    static {
        map.put("ROOT_ADMIN", new RootRole());
        map.put("ORDER_ADMIN", new OrderRole());
        map.put("NORMAL", new NormalRole());
    }

    public static RoleOperator instance(String roleName) {
        return map.get(roleName);
    }
}
