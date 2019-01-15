package test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostTestRestAssured {

    private int statusCode;
    private String SuccessCode;
    private String Message;
    private String faultId;
    private String fault;
    Response rp;
    private String baseUrl="http://restapi.demoqa.com/customer/register";
    private PostTestSample pts1;
    String arr1[]={"Sunny","Ara","sn@dds","Psw@rd1234","s@g.com"};
    String arr2[]={"1234"," ","124Su","eererfrt","sunny.arora@a.com"};

    @BeforeTest
    public void intialize(){

        pts1=new PostTestSample();


        pts1.setbaseUrl(baseUrl);
        rp= pts1.startRequest(arr1);


    }

    @AfterTest
    public void clear(){

    }

    @Test (priority = 1)
    public void Test1(){


        Assert.assertEquals(pts1.getstatuscode(rp),200,"Correct status code");
        System.out.println("Status code is:"+pts1.getstatuscode(rp));
        System.out.println("Response body is :"+rp.getBody().asString());
        Assert.assertEquals(pts1.getValuebyKey(rp,"SuccessCode"),"OPERATION_SUCCESS");
        Assert.assertEquals(pts1.getValuebyKey(rp,"Message"),"Operation completed sucessfully");

    }

  /*  @Test (priority = 2)
    public void Test2(){


        pts1.startRequest(arr2);

        Assert.assertEquals(pts1.getstatuscode(rp),200,"Correct status code");
        Assert.assertEquals(pts1.getValuebyKey("SuccessCode"),"OPERATION_SUCCESS");
        Assert.assertEquals(pts1.getValuebyKey("Message"),"Operation completed sucessfully");
    }
    */
}
