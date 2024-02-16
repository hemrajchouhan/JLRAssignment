import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WriteJSONToFile {
	public static RandomGenerator randomGenrator=new RandomGenerator();

	// Method to generate a random JSON object
	public static JsonObject generateRandomJSONObject() {

		// Create the JSON object
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", RandomGenerator.generateRandomID(1, 100));

		JsonObject category = new JsonObject();
		category.addProperty("id", RandomGenerator.generateRandomID(1, 10));
		category.addProperty("name", RandomGenerator.generateRandomDogName());
		jsonObject.add("category", category);
		jsonObject.addProperty("name", RandomGenerator.generateRandomDogName());

		JsonArray photoUrls = new JsonArray();
		photoUrls.add(RandomGenerator.generateRandomPhotoUrl());
		jsonObject.add("photoUrls", photoUrls);

		JsonObject tag = new JsonObject();
		tag.addProperty("id", RandomGenerator.generateRandomID(1, 100));
		tag.addProperty("name", RandomGenerator.generateRandomDogName());

		JsonArray tags = new JsonArray();
		tags.add(tag);
		jsonObject.add("tags", tags);
		jsonObject.addProperty("status", RandomGenerator.generateRandomStatus());
		return jsonObject;
	}

	public static void main(String[] args) throws IOException {
		// Generate a random JSON object
		JsonObject randomJSONObject = generateRandomJSONObject();
		// Convert JSON object to string
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(randomJSONObject);
		// Write JSON string to a file
		try (FileWriter writer = new FileWriter("C:\\Users\\admin\\eclipse-workspace\\JLRRestAssured\\src\\test\\resources\\Create_Pet1.json")) {
				writer.write(jsonString);
				System.out.println("JSON file created successfully.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
