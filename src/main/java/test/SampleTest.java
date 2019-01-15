package test;

import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SampleTest {

    private SampleClass sc;
    private Response rp;
    private int statuscode;
    private String msg;
    @BeforeTest
    public void intialize(){
        sc=new SampleClass();
        sc.setUrl("https://api.razorpay.com");

        rp=sc.getRequest();
        statuscode=sc.getStatusCode(rp);
        msg=sc.getValueForKey(rp,"message");
    }

    @AfterTest
    public void clear(){

        msg="";
        statuscode=0;
        rp=null;
    }

    @Test (priority = 1)
    public void startTest(){


        Assert.assertEquals(statuscode,200,"correct status code");
    }

    @Test (priority =2)
    public void startTest2(){

        Assert.assertNotNull(sc.getValueForKey(rp,"message"));
        Assert.assertEquals("Welcome to Razorpay API.",sc.getValueForKey(rp,"message"));
    }
}
