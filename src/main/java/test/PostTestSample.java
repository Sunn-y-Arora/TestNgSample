package test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class PostTestSample {

    private String URL;
    private RequestSpecification httprequest;
    private JSONObject requestParameters;
    public Response response;
    private JsonPath jsonPath;

    public void setbaseUrl(String s){
        this.URL=s;

    }

    public Response startRequest(String obj[]){

        RestAssured.baseURI = URL;
        httprequest= RestAssured.given();

        requestParameters=new JSONObject();
        requestParameters.put("FirstName",obj[0]);
        requestParameters.put("LastName",obj[1]);

        requestParameters.put("UserName",obj[2]);
        requestParameters.put("Password",obj[3]);
        requestParameters.put("Email",obj[4]);

        httprequest.header("Content-Type","application/json");
        httprequest.body(requestParameters.toJSONString());

        response= httprequest.request(Method.POST, "");


        return response;
    }


    public int getstatuscode(Response rp){


        return rp.getStatusCode();

        //return 201;
    }

    public void setJsonPath(Response rp){
        jsonPath=rp.jsonPath();
    }

    public String getValuebyKey(Response rp,String key){
        jsonPath=rp.jsonPath();
        String value=jsonPath.get(key);
        return value;
    }
}
