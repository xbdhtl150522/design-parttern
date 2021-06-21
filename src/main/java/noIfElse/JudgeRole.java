package noIfElse;

/*
 * 最原始if、else写法
 * */
public class JudgeRole {

    public String judge(String rolename) {
        String s = "";
        if ("ROOT_ADMIN".equals(rolename)) {
            s="ROOT_ADMIN:"+"有A权限";
        } else if ("ORDER_ADMIN".equals(rolename)) {
            s="ORDER_ADMIN:"+"有B权限";
        } else if ("NORMAL".equals(rolename)) {
            s="NORMAL:"+"有C权限";
        }
        return s;
    }

}
