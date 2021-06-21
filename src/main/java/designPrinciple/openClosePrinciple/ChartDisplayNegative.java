package designPrinciple.openClosePrinciple;

public class ChartDisplayNegative {

    /*
     * 在该代码中，如果需要增加⼀个新的图表类，如折线图LineChart，则需要修改ChartDisplay类的
     * display()⽅法的源代码，增加新的判断逻辑，违反了开闭原则。
     * */
    public void display(String type) {
        if (type.equals("pie")) {
            PieChart chart = new PieChart();
            chart.display();
        } else if (type.equals("bar")) {
            BarChart chart = new BarChart();
            chart.display();
        }
    }

}
