import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private int classRomNumber; // either 37 or 38
    private int co2Level; // value in ppm
    private String day; // the name of the day
    private String date; // example 12.08.2024

    // Constructor
    public Data(int classRomNumber, int co2Level, String day, String date) {
        this.classRomNumber = classRomNumber;
        this.co2Level = co2Level;
        this.day = day;
        this.date = date;
    }

    // Getters
    public int getClassRomNumber() {
        return classRomNumber;
    }

    public int getCo2Level() {
        return co2Level;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public static List<Data> getData(String csvURL, int classRomNumber) {
        List<Data> dataList = new ArrayList<>();

        try {
            URL url = new URL(csvURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/csv");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;

            // Skip header line
            br.readLine();

            while ((output = br.readLine()) != null) {
                Data data = parseData(output, classRomNumber);
                if (data != null) {
                    dataList.add(data);
                }
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet: " + e);
        }

        return dataList; // Return the list of Data objects
    }

    private static Data parseData(String csvLine, int classRomNumber) {
        String[] fields = csvLine.split(",");
        if (fields.length < 5) {
            return null; // or handle error
        }

        String createdAt = fields[0]; // created_at field
        int co2Level = Integer.parseInt(fields[2]); // field1 as CO2 level
        String date = createdAt.split(" ")[0]; // Extract date
        String day = createdAt.split(" ")[0]; // You can implement logic to determine the day from the date if needed

        return new Data(classRomNumber, co2Level, day, date);
    }
}
