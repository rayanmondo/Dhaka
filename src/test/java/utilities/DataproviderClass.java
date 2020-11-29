package utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderClass {
    @DataProvider(name = "singleValue")
    public Object[][] storeSingleValue() {
        return new Object[][]{{"Raihan"}, {"Saifan"}, {"David"}};
    }


    @DataProvider(name = "multipleValue")
    public Object[][] storeMultipleValue() {
        return new Object[][]{{"raihan", "saifan"}, {"daniel", "alex"}, {"azmain", "adel"}};
    }

//    @Test (dataProvider = "singleValue")
//    public void readSingleValue(String name){
//        System.out.println("[Single value] : " + name);
//    }
//
//    @Test (dataProvider = "multipleValue")
//    public void readMultipleValue(String name, String name1){
//        System.out.println("first name :" +name);
//        System.out.println("second name :" +name1);
//    }


    @DataProvider(name = "RefiCalculator")
    public Object[][] storeRefiValue() {
        return new Object[][]{{"500000", "70000", "25", "5", "$2,513.74"}};
    }
}
