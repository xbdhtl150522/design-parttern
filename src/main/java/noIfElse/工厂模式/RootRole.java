package noIfElse.工厂模式;

import noIfElse.枚举方式.RoleOperator;

//管理员角色
public class RootRole implements RoleOperator {
    @Override
    public String roleOperator() {
        return "ROOT_ADMIN:" + "有A权限";
    }
}
