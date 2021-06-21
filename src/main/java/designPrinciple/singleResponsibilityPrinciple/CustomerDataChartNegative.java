package designPrinciple.singleResponsibilityPrinciple;


/* CustomerDataChart类承担了太多的职责，既包含与数据库相关的⽅法，⼜包含与图表⽣成和显示相关的⽅法。
 * 如果在其他类中也需要连接数据库或者使⽤findCustomers()⽅法查询客户信息，则难以实现代码
 * 的重⽤。⽆论是修改数据库连接⽅式还是修改图表显示⽅式都需要修改该类，它不⽌⼀个引起它变
 * 化的原因，违背了单⼀职责原则。
 * 因此需要对该类进⾏拆分，使其满⾜单⼀职责原则，类CustomerDataChart可拆分为如下三个类：
 * (1) DBUtil：负责连接数据库，包含数据库连接⽅法getConnection()；
 * (2) CustomerDAO：负责操作数据库中的Customer表，包含对Customer表的增删改查等⽅法，如findCustomers()；
 * (3) CustomerDataChart：负责图表的⽣成和显示，包含⽅法createChart()和displayChart()。
 * */
public class CustomerDataChartNegative {
    /*⽤于连接数据库*/
    public void getConnection() {

    }

    /*⽤于查询所有的客户信息*/
    public void findCustomers() {

    }

    /*⽤于创建图表*/
    public void createChart() {

    }

    /*⽤于显示图表*/
    public void displayChart() {

    }
}
