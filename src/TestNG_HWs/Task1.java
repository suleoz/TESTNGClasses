package TestNG_HWs;

import org.testng.annotations.*;

public class Task1 {

    //1: Executing different test based TestNG annotations
    //Create class that will have:
    //Before and After Class annotation
    //Before and After Method annotation
    //2 methods with Test annotation
    //Observe the results!

    @BeforeClass
    public void beforeClass(){
        System.out.println("this is BEFORE CLASS");

    }

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("this is before Method");
    }

    @Test(priority = 1)
    public void name(){
        System.out.println("first test case");
    }

    @Test(priority = 2)
    public void surname(){
        System.out.println("second test case");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after Method");
        System.out.println("");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is AFTER class");
    }

}

