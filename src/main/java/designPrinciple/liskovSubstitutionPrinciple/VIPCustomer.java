package designPrinciple.liskovSubstitutionPrinciple;

import lombok.Data;

@Data
public class VIPCustomer extends Customer {
    private String name;
    private String email;
}
