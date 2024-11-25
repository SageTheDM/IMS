import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThingSpeakURLGenerator {

    // Constants for Room channel numbers
    private static final int ROOM_39_NUMBER = 1521262;
    private static final int ROOM_38_NUMBER = 1364580;
    private static final int ROOM_37_NUMBER = 1521263;

    // Example Dates for fetching data, dynamically generated
    private static final LocalDateTime START_DATE = LocalDateTime.of(2024, 11, 1, 0, 0);
    private static final LocalDateTime END_DATE = LocalDateTime.of(2024, 11, 1, 23, 59);

    // Room URLs
    private static final Map<Integer, String> ROOM_URLS = new HashMap<>();
    static {
        ROOM_URLS.put(39, createUrl(ROOM_39_NUMBER));
        ROOM_URLS.put(38, createUrl(ROOM_38_NUMBER));
        ROOM_URLS.put(37, createUrl(ROOM_37_NUMBER));
    }

    // Method to create the ThingSpeak API URL dynamically
    public static String createUrl(int channelNumber) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startDate = encodeUrlParam(START_DATE.format(formatter));
        String endDate = encodeUrlParam(END_DATE.format(formatter));

        return String.format("https://api.thingspeak.com/channels/%d/feeds.csv?start=%s&end=%s",
                channelNumber, startDate, endDate);
    }

    // Helper method to URL encode the date strings
    private static String encodeUrlParam(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error encoding URL parameter: " + e.getMessage());
            return value;
        }
    }

    // Method to calculate the average of a specific number of data points (e.g.,
    // CO2 levels)
    public static double calculateAverage(List<Co2Data> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Co2Data data : dataList) {
            sum += data.getCo2Level(); // Assuming Co2Data has a method getCo2Level() that returns the CO2 level
        }
        return sum / dataList.size();
    }

    public static void main(String[] args) {
        try {
            // Print out the generated URLs for each room
            for (Map.Entry<Integer, String> entry : ROOM_URLS.entrySet()) {
                System.out.println("Room " + entry.getKey() + " URL: " + entry.getValue());
            }

            // Example: Calculate and print the average CO2 level for each room (assuming
            // Co2Data.getData() method exists)
            List<Co2Data> room39Data = Co2Data.getData(ROOM_URLS.get(39));
            List<Co2Data> room38Data = Co2Data.getData(ROOM_URLS.get(38));
            List<Co2Data> room37Data = Co2Data.getData(ROOM_URLS.get(37));

            double avgRoom39 = calculateAverage(room39Data);
            double avgRoom38 = calculateAverage(room38Data);
            double avgRoom37 = calculateAverage(room37Data);

            System.out.println("Average CO2 Level in Room 39: " + avgRoom39);
            System.out.println("Average CO2 Level in Room 38: " + avgRoom38);
            System.out.println("Average CO2 Level in Room 37: " + avgRoom37);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
