/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pravien
 */
public class ServiceIntegrationTest
{

    public ServiceIntegrationTest()
    {
    }

    @BeforeClass
    public static void setUpBeforeAll()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/Test1";
        RestAssured.defaultParser = Parser.JSON;
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }
    
    //test sever is running.
    @Test
    public void serverIsRunning()
    {
        given().
                when().get().
                then().
                statusCode(200);
    }
    
    @Test
public void addOperation() {
  given().pathParam("n1", 2).pathParam("n2", 2).
   when().get("/api/calculator/add/{n1}/{n2}").
   then().
   statusCode(200).
   body("result", equalTo(4), "operation", equalTo("2 + 2"));
}


@Test
public void addOperationv2() {
  given().
   when().get("/api/calculator/add/2/2").
   then().
   statusCode(200).
   body("result", equalTo(4), "operation", equalTo("2 + 2"));
}

@Test
public void subbOperation() {
  given().
   when().get("/api/calculator/sub/2/2").
   then().
   statusCode(200).
   body("result", equalTo(0), "operation", equalTo("2 - 2"));
}

@Test
public void mulOperation() {
  given().
   when().get("/api/calculator/mul/2/2").
   then().
   statusCode(200).
   body("result", equalTo(4), "operation", equalTo("2 * 2"));
}

@Test
public void divOperation() {
  given().
   when().get("/api/calculator/div/2/2").
   then().
   statusCode(200).
   body("result", equalTo(1), "operation", equalTo("2 / 2"));
}

@Test
public void addOperationWrongArguments() {
 given().pathParam("n1", 2).pathParam("n2", 2.2).
  when().get("/api/calculator/add/{n1}/{n2}").
  then().
  statusCode(400).
  body("code", equalTo(400));
}


@Test
public void notExistingPath() {
 given().
  when().get("/api/calculator/add/sdsd").
  then().
  statusCode(404).
  body("code", equalTo(404));
}

@Test
public void divZero() {
 given().pathParam("n1", 2).pathParam("n2", 0).
  when().get("/api/calculator/div/{n1}/{n2}").
  then().
  statusCode(500).
  body("code", equalTo(500));
}




    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
