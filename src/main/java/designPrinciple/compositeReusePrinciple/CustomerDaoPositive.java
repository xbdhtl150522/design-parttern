package designPrinciple.compositeReusePrinciple;

import lombok.Data;

@Data
public class CustomerDaoPositive {
    private DBUtil dbUtil;
    public void addCustomer() {
        dbUtil.getConnection();
    }
}
