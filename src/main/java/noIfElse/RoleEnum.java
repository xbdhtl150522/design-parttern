package noIfElse;

/*
 * 角色枚举类
 * */
public enum RoleEnum implements RoleOperator {

    ROOT_ADMIN("ROOT_ADMIN") {
        public String roleOperator() {
            return "ROOT_ADMIN:" + "有A权限";
        }
    },
    ORDER_ADMIN("ORDER_ADMIN") {
        public String roleOperator() {
            return "ORDER_ADMIN:" + "有B权限";
        }
    },
    NORMAL("NORMAL") {
        public String roleOperator() {
            return "NORMAL:" + "有C权限";
        }
    };

    private String rolename;

    RoleEnum(String rolename) {
        this.rolename = rolename;
    }

    /*
     * 根据名字获取对应的枚举
     * */
    public static RoleEnum getByRolename(String rolename) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.rolename.equals(rolename)) {
                return roleEnum;
            }
        }
        return null;
    }

}
