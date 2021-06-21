package noIfElse;

/*
 * 测试
 * */
public class Test {
    public static void main(String[] args) {
        //原始做法
        JudgeRole judgeRole = new JudgeRole();
        String s = judgeRole.judge("ORDER_ADMIN");
        System.out.println(s);
        //枚举方式
        System.out.println(RoleEnum.valueOf("NORMAL").roleOperator());
        System.out.println(RoleEnum.getByRolename("NORMAL").roleOperator());
        //工厂模式
        System.out.println(RoleFactory.instance("ROOT_ADMIN").roleOperator());
        //策略模式
        System.out.println(new RoleContext(new RootRole()).excute());
    }
}
