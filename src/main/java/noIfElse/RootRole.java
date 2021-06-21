package noIfElse;

//管理员角色
public class RootRole implements RoleOperator {
    public String roleOperator() {
        return "ROOT_ADMIN:" + "有A权限";
    }
}
