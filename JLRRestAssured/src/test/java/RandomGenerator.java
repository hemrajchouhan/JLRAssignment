import java.util.Random;

public class RandomGenerator {

	// Array of dog names
	private static final String[] DOG_NAMES = {"Buddy", "Max", "Charlie", "Cooper", "Rocky", "Bear", "Duke", "Tucker", "Jack", "Oliver"};
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
	
	// Method to generate a random photo URL
	public static String generateRandomPhotoUrl() {
		Random random = new Random();
		return PHOTO_URLS[random.nextInt(PHOTO_URLS.length)];
	}

	// Method to generate a random status value
	public static String generateRandomStatus() {
		Random random = new Random();
		return STATUSES[random.nextInt(STATUSES.length)];
	}

	// Method to generate a random dog name
	public static String generateRandomDogName() {
		Random random = new Random();
		return DOG_NAMES[random.nextInt(DOG_NAMES.length)];
	}

	// Method to generate a random integer ID within a specified range
	public static int generateRandomID(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

}
