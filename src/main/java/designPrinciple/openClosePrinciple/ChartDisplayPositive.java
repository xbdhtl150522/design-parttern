package designPrinciple.openClosePrinciple;

import lombok.Data;

/*
* 我们引⼊了抽象图表类AbstractChart，且ChartDisplay2针对抽象图表类进⾏编程，并通
* 过setChart()⽅法由客户端来设置实例化的具体图表对象，在ChartDisplay的display()⽅法中调⽤
* chart对象的display()⽅法显示图表。如果需要增加⼀种新的图表，如折线图LineChart，只需要将
* LineChart也作为AbstractChart的⼦类，在客户端向ChartDisplay中注⼊⼀个LineChart对象即
* 可，⽆须修改现有类库的源代码。
* */

@Data
public class ChartDisplayPositive {

    AbstractChart abstractChart;

    public void display() {
        abstractChart.display();
    }

}
