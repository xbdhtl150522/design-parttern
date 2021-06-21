package designPrinciple.liskovSubstitutionPrinciple;

/*
* 在对系统进⾏进⼀步分析后发现，⽆论是普通客户还是VIP客户，发送邮件的过程都是相同的，也就是说
* 两个send()⽅法中的代码重复，⽽且在本系统中还将增加新类型的客户。
* */
public class EmailSenderNegative {
    public void send(CommonCustomer commonCustomer) {

    }

    public void send(VIPCustomer vipCustomer) {

    }
}
