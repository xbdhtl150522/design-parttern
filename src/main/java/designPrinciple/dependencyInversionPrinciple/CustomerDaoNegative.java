package designPrinciple.dependencyInversionPrinciple;

import lombok.Data;

/*由于每次转换数据时数据来源不⼀定相同，
 *因此需要更换数据转换类，如有时候需要将TXTDataConvertor改为ExcelDataConvertor，
 * 此时，需要修改CustomerDAO的源代码，⽽且在引⼊并使⽤新的数据转换类时
 *也不得不修改CustomerDAO的源代码，系统扩展性较差，违反了开闭原则
 */
@Data
public class CustomerDaoNegative {

    private TXTDataConvertor txtDataConvertor;

    private ExcelDataConvertor excelDataConvertor;

    public void addCustomer() {
        /*
         * txtDataConvertor/excelDataConvertor
         */
    }

}
