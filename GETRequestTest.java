import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.restassured.response.Response;
import io.restassured.RestAssured;

public class GETRequestTest {

	private static Logger LOG = LoggerFactory.getLogger(GETRequestTest.class);

	@Test
	public void testGetAllStudentRecords() {

	    String url = "http://ezifyautomationlabs.com:6565/educative-rest/students";
		
		/**
		 * Example 1 - GET all the existing student's record
		 */
	     LOG.info("Step - 1 : Send GET Request");
		 Response response = RestAssured.given().get(url).andReturn();
		 
		 LOG.info("Step - 2 : Print the JSON response body");
		 response.getBody().prettyPrint();
		 
		 LOG.info("Step - 3 : Assert StatusCode = 200");
		 assertEquals(response.getStatusCode(), 200, "http status code");
		
		 LOG.info("Step - 4 : Verify that the response contains id = 101");
		 LOG.info("list of Student's Id " +response.getBody().jsonPath().getList("id"));
		 assertTrue(response.getBody().jsonPath().getList("id").contains(101));
	}	
}