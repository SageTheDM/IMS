public static void main(String[] args) {
        try {
            // Example input for generating the URL
            String channelId = "123456";  // Replace with your actual channel ID
            String apiKey = "YOUR_READ_API_KEY";  // Replace with your actual API key
            int results = 50;  // Fetch 50 records
            String start = "2024-11-01 00:00:00";  // Start date-time
            String end = "2024-11-01 23:59:59";  // End date-time
            String timezone = "Europe/Zurich";  // Timezone

            // Generate the dynamic URL using the method
            String url = createThingSpeakURL(channelId, apiKey, results, start, end, timezone);

            // Output the generated URL
            System.out.println("Generated ThingSpeak URL: ");
            System.out.println(url);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}