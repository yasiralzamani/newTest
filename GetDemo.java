package Api;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetDemo {

	public static void main(String[] args) {

		String uri = "http://dummy.restapiexample.com/api/v1/employees";
		int expectedStatusCode = 200;

		Response response;

		response = given().when().get(uri).then().extract().response();

		response.prettyPrint();
		int actualStatusCode = response.getStatusCode();

		JsonPath jsonPath = response.jsonPath();

		System.out.println("**************");

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(actualStatusCode, expectedStatusCode);

		softAssert.assertAll();

	}

}
