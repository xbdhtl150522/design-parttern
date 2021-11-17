package noIfElse.工厂模式;

import noIfElse.枚举方式.RoleOperator;

//订单角色
public class OrderRole implements RoleOperator {
    @Override
    public String roleOperator() {
        return "ORDER_ADMIN:" + "有B权限";
    }
}
