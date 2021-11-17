package noIfElse.策略模式;

import noIfElse.枚举方式.RoleOperator;

//策略模式
public class RoleContext {

    private RoleOperator roleOperator;

    public RoleContext(RoleOperator roleOperator) {
        this.roleOperator = roleOperator;
    }

    public String excute() {
        return roleOperator.roleOperator();
    }

}
