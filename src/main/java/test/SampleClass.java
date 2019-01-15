package test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SampleClass {

    public Response response;
    public RequestSpecification httpRequest;
    private  String  url;

    private JsonPath jsonPath;

    public void setUrl(String s){

        this.url=s;
    }

    public Response getRequest(){
        this.httpRequest= RestAssured.given();
        this.response=this.httpRequest.request(Method.GET,url);

        return  this.response;
    }

    public int getStatusCode(Response r){

        return r.getStatusCode();

    }

    public String getValueForKey(Response r,String key){

        this.jsonPath=r.jsonPath();
        String value=jsonPath.get(key);
        return value;
    }
}
