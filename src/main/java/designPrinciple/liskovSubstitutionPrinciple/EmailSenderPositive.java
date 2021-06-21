package designPrinciple.liskovSubstitutionPrinciple;

/*
 * 在本实例中，可以考虑增加⼀个新的抽象客户类Customer，⽽将CommonCustomer和
 * VIPCustomer类作为其⼦类，邮件发送类EmailSender类针对抽象客户类Customer编程，根据⾥
 * ⽒代换原则，能够接受基类对象的地⽅必然能够接受⼦类对象，因此将EmailSender中的send()⽅
 * 法的参数类型改为Customer，如果需要增加新类型的客户，只需将其作为Customer类的⼦类即
 * 可
 * */
public class EmailSenderPositive {
    public void send(Customer customer) {

    }
}
