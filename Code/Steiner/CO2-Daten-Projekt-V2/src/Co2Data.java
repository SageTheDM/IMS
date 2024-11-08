import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Co2Data {
    private Date date;
    private int co2Level;

    // #region Constructor
    public Co2Data(Date date, int co2Level) {
        this.date = date;
        this.co2Level = co2Level;
    }

    // #region Getters Setters
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

    // #region Fetching & Parsing
    public static List<Co2Data> getData(String csvURL, int classRoomNumber) {
        List<Co2Data> dataList = new ArrayList<>();

        // Reference date: August 11, 2024
        Date referenceDate = new Date(11, 8, 2024, 0, 0); // Set time to 00:00 as we only care about the date

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
                Co2Data data = parseData(output, classRoomNumber);
                if (data != null && isNewerThanReferenceDate(data.getDate(), referenceDate)) {
                    dataList.add(data);
                }
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet: " + e);
        }

        return dataList; // Return the list of Co2Data objects
    }

    // Helper method to compare dates
    private static boolean isNewerThanReferenceDate(Date dataDate, Date referenceDate) {
        // Compare year, month, and day only (ignoring the time part)
        if (dataDate.getYear() > referenceDate.getYear()) {
            return true;
        } else if (dataDate.getYear() == referenceDate.getYear()) {
            if (dataDate.getMonth() > referenceDate.getMonth()) {
                return true;
            } else if (dataDate.getMonth() == referenceDate.getMonth()) {
                return dataDate.getDay() > referenceDate.getDay();
            }
        }
        return false;
    }

    private static Co2Data parseData(String csvLine, int classRoomNumber) {
        String[] fields = csvLine.split(",");
        if (fields.length < 5) {
            return null; // Handle error or log it if needed
        }

        try {
            // Extract date and time from created_at field
            String createdAt = fields[0];
            String[] dateTime = createdAt.split(" ");
            String[] dateParts = dateTime[0].split("-");
            String[] timeParts = dateTime[1].split(":");

            // Create a Date object
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            Date date = new Date(day, month, year, hour, minute);

            // Parse CO2 level (field1)
            int co2Level = Integer.parseInt(fields[2]);

            return new Co2Data(date, co2Level);
        } catch (Exception e) {
            System.out.println("Error parsing data: " + e);
            return null;
        }
    }

    // #region toString Override
    @Override
    public String toString() {
        return this.date.toString() + "\n" + this.co2Level;
    }
}
