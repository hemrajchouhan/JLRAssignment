import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStoreCRUDTest {

	private static String baseUrl = "https://petstore.swagger.io/v2";



	@BeforeClass
	public void beforeClass(){
		RestAssured.baseURI = baseUrl;
	}


	@Test
	public void testCRUDOperations() throws IOException{
		createPet();
		getPetById();
		updatePet();
		deletePet();
	}
	@Test
	public void createPet() throws IOException{
		String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/Create_Pet.json")));
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/pet");
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals("46",response.jsonPath().getString("id"));
		Assert.assertEquals(response.jsonPath().getString("status"),"available");
		Assert.assertEquals(response.jsonPath().getString("category.id"),"6");
		Assert.assertEquals(response.jsonPath().getString("category.name"),"Rocky");
		Assert.assertEquals(response.jsonPath().getString("tags[0].id"),"15");
	}

	@Test
	public void getPetById() throws IOException {
		//Send a GET request to retrieve the pet
		Response response = given()
				.contentType("application/json").log().all()
				.when()
				.get("/pet/46")
				.then()
				.extract().response();
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals("46",response.jsonPath().getString("id"));
		Assert.assertEquals(response.jsonPath().getString("status"),"available");
		Assert.assertEquals(response.jsonPath().getString("category.id"),"6");
		Assert.assertEquals(response.jsonPath().getString("category.name"),"Rocky");
		Assert.assertEquals(response.jsonPath().getString("tags[0].id"),"15");
	}
	@Test
	public void updatePet() throws IOException {
		String putrequestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/Update_Pet.json")));
		// Verify the pet is updated
		Response response = given()
				.contentType("application/json")
				.body(putrequestBody)
				.when()
				.put("/pet");
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals(response.jsonPath().getString("status"),"pending");
	}
	@Test
	public void deletePet() {
		// Send the DELETE request
		Response response=given().when().delete("/pet/46");
		// Verify the pet is deleted
		Assert.assertEquals(200, response.statusCode());
	}
}
