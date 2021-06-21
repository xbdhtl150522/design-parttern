package designPrinciple.interfaceSegregationPrinciple;

/*由于在接⼝CustomerDataDisplay中定义了太多⽅法，即该接⼝承担了太多职责，⼀⽅⾯导
 *致该接⼝的实现类很庞⼤，在不同的实现类中都不得不实现接⼝中定义的所有⽅法，灵活性较差，如果
 *出现⼤量的空⽅法，将导致系统中产⽣⼤量的⽆⽤代码，影响代码质量；另⼀⽅⾯由于客户端针对⼤接
 *⼝编程，将在⼀定程序上破坏程序的封装性，客户端看到了不应该看到的⽅法，没有为客户端定制接
 *⼝。因此需要将该接⼝按照接⼝隔离原则和单⼀职责原则进⾏重构，将其中的⼀些⽅法封装在不同的⼩
 *接⼝中，确保每⼀个接⼝使⽤起来都较为⽅便，并都承担某⼀单⼀⻆⾊，每个接⼝中只包含⼀个客户端
 *（如模块或类）所需的⽅法即可。
 * */
public interface CustomerDataDisplayNegative {
    /*⽤于从⽂件中读取数据*/
    void dataRead();

    /*⽤于将数据转换成XML格式*/
    void transformToXML();

    /*⽤于创建图表*/
    void createChart();

    /*⽤于显示图表*/
    void displayChart();

}
