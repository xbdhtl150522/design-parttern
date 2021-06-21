package designPrinciple.compositeReusePrinciple;

/*随着客户数量的增加，系统决定升级为Oracle数据库，因此需要增加⼀个新的OracleDBUtil类来连接
 *Oracle数据库，由于在初始设计⽅案中CustomerDAO和DBUtil之间是继承关系，因此在更换数据库连
 *接⽅式时需要修改CustomerDAO类的源代码，将CustomerDAO作为OracleDBUtil的⼦类，这将违反开
 *闭原则。【当然也可以修改DBUtil类的源代码，同样会违反开闭原则。】 现使⽤合成复⽤原则对其进
 *⾏重构。
 * */
public class CustomerDaoNegative extends DBUtil {

    public void addCustomer() {
        this.getConnection();
    }
}
