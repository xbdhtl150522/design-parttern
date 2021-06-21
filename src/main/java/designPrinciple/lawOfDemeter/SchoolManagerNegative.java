package designPrinciple.lawOfDemeter;

import java.util.ArrayList;
import java.util.List;

/*
 * 在类SchoolManager中，根据直接朋友的定义可知，类Employee和类CollegeManager是直接朋友，类
 * Employee是以⽅法的返回值作为直接朋友，⽽类CollegeManager是以⽅法的参数作为直接朋友。
 * 类CollegeEmployee不是SchoolManager的直接朋友，因为CollegeEmployee是以局部变量⽅式出现在
 * SchoolManager，违反了迪⽶特法则。
 * */
//学校管理类
public class SchoolManagerNegative {

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
        List<CollegeEmployee> collegeEmpList = sub.listCollegeEmployee();
        System.out.println("------------学院员⼯----------------");
        for (CollegeEmployee e : collegeEmpList) {
            System.out.println(e.getId());
        }
        List<Employee> empList = this.listEmployee();
        System.out.println("------------学校总部员⼯----------------");
        for (Employee e : empList) {
            System.out.println(e.getId());
        }
    }
}
