import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Co2Data {
    private Date date;
    private int co2Level;

    // Constructor
    public Co2Data(Date date, int co2Level) {
        this.date = date;
        this.co2Level = co2Level;
    }

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(int co2Level) {
        this.co2Level = co2Level;
    }

    // Fetch and parse data from a CSV URL
    public static List<Co2Data> getData(String csvURL) {
        List<Co2Data> dataList = new ArrayList<>();

        try {
            URL url = new URL(csvURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/csv");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            br.readLine(); // Skip header line

            String output;
            while ((output = br.readLine()) != null) {
                Co2Data data = parseData(output);
                if (data != null) {
                    dataList.add(data);
                }
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Error in data fetching: " + e);
        }

        return dataList;
    }

    // Helper method to parse CSV data and create a Co2Data object
    private static Co2Data parseData(String line) {
        try {
            String[] parts = line.split(",");
            String dateStr = parts[0].trim(); // assuming date is in the first column
            int co2Level = Integer.parseInt(parts[1].trim()); // assuming CO2 level is in the second column

            // Convert the date string into a Date object (assumes CSV date format is
            // yyyy-MM-dd HH:mm:ss)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateStr);

            return new Co2Data(date, co2Level);
        } catch (Exception e) {
            System.out.println("Error parsing data line: " + e);
            return null;
        }
    }
}
