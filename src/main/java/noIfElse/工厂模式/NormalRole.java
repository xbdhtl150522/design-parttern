package noIfElse.工厂模式;

import noIfElse.枚举方式.RoleOperator;

//普通角色
public class NormalRole implements RoleOperator {
    @Override
    public String roleOperator() {
        return "NORMAL:" + "有C权限";
    }
}
