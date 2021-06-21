package noIfElse;

//订单角色
public class OrderRole implements RoleOperator {
    public String roleOperator() {
        return "ORDER_ADMIN:" + "有B权限";
    }
}
