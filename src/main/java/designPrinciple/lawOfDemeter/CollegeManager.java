package designPrinciple.lawOfDemeter;

import java.util.ArrayList;
import java.util.List;

//管理学院员⼯的管理类
public class CollegeManager {
    public List<CollegeEmployee> listCollegeEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int id = 0; id < 10; id++) {
            CollegeEmployee e = new CollegeEmployee();
            e.setId("学院员⼯id：" + id);
            list.add(e);
        }
        return list;
    }

    public void printCollegeEmp() {
        List<CollegeEmployee> collegeEmpList = this.listCollegeEmployee();
        System.out.println("------------学院员⼯----------------");
        for (CollegeEmployee e : collegeEmpList) {
            System.out.println(e.getId());
        }
    }
}
