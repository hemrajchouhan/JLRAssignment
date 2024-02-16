import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomJSONGenerator {

    // Array of possible photo URLs
    private static final String[] PHOTO_URLS = {
            "https://example.com/photo1.jpg",
            "https://example.com/photo2.jpg",
            "https://example.com/photo3.jpg",
            "https://example.com/photo4.jpg",
            "https://example.com/photo5.jpg"
    };

    // Array of possible status values
    private static final String[] STATUSES = {"available", "pending", "sold"};

    // Method to generate a random JSON string
    public static String generateRandomJSON() {
        Random random = new Random();
        
        // Generate random values for id, category id, and tag id
        int id = random.nextInt(10000) + 1;
        int categoryId = random.nextInt(100) + 1;
        int tagId = random.nextInt(100) + 1;

        // Generate a random name
        String name = "TestPET" + id;

        // Generate a random photo URL
        String photoUrl = PHOTO_URLS[random.nextInt(PHOTO_URLS.length)];

        // Generate a random status
        String status = STATUSES[random.nextInt(STATUSES.length)];

        // Create the JSON object
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);

        JsonObject category = new JsonObject();
        category.addProperty("id", categoryId);
        category.addProperty("name", name);
        jsonObject.add("category", category);

        jsonObject.addProperty("name", name);

        JsonArray photoUrls = new JsonArray();
        photoUrls.add(photoUrl);
        jsonObject.add("photoUrls", photoUrls);

        JsonObject tag = new JsonObject();
        tag.addProperty("id", tagId);
        tag.addProperty("name", name);
        
        JsonArray tags = new JsonArray();
        tags.add(tag);
        jsonObject.add("tags", tags);

        jsonObject.addProperty("status", status);

        // Convert JSON object to string
        Gson gson = new Gson();
     // Convert Map to JSON string
        String jsonString = gson.toJson(jsonObject);

        // Write JSON string to a file
        try (FileWriter writer = new FileWriter("D:\\Json\\data.json")) {
            writer.write(jsonString);
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return gson.toJson(jsonObject);
    }

    public static void main(String[] args) {
    	  // Convert Map to JSON string
    	// Generate and print a random JSON string
        String randomJSON = generateRandomJSON();
        System.out.println("Random JSON: " + randomJSON);

        
        
    }
}
