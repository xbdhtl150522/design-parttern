package designPrinciple.dependencyInversionPrinciple;

import lombok.Data;


/*
 * 我们可以通过引⼊抽象数据转换类解决该问题，在引
 * ⼊抽象数据转换类DataConvertor之后，CustomerDAO针对抽象类DataConvertor编程，⽽将具体数据
 * 转换类名存储在配置⽂件中，符合依赖倒转原则。根据⾥⽒代换原则，程序运⾏时，具体数据转换类对
 * 象将替换DataConvertor类型的对象，程序不会出现任何问题。更换具体数据转换类时⽆须修改源代
 * 码，只需要修改配置⽂件；如果需要增加新的具体数据转换类，只要将新增数据转换类作为
 * DataConvertor的⼦类并修改配置⽂件即可，原有代码⽆须做任何修改，满⾜开闭原则。
 *
 * 在上述重构过程中，我们使⽤了开闭原则、⾥⽒代换原则和依赖倒转原则，在⼤多数情况下，这三个设
 * 计原则会同时出现，开闭原则是⽬标，⾥⽒代换原则是基础，依赖倒转原则是⼿段，它们相辅相成，相
 * 互补充，⽬标⼀致，只是分析问题时所站⻆度不同⽽已
 * */
@Data
public class CustomerDaoPositive {

    DataConvertor dataConvertor;

    public void addCustomer() {
        /*
         * dataConvertor
         * */
    }

}
