package designPrinciple.liskovSubstitutionPrinciple;

import lombok.Data;

@Data
public class CommonCustomer extends Customer {
    private String name;
    private String email;
}
