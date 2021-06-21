package designPrinciple.lawOfDemeter;

import java.util.ArrayList;
import java.util.List;

//学校管理类
public class SchoolManagerPositive {

    //返回总部所有员⼯
    public List<Employee> listEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员⼯id：" + i);
            list.add(emp);
        }
        return list;
    }

    //输出学校总部和学院员⼯信息
    public void printEmployee(CollegeManager sub) {
        sub.printCollegeEmp();
        List<Employee> empList = this.listEmployee();
        System.out.println("------------学校总部员⼯----------------");
        for (Employee e : empList) {
            System.out.println(e.getId());
        }
    }

}
