import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Co2Data {
    // #region Fields
    private Date date;
    private int co2Level;

    // #region Constructor
    public Co2Data(Date date, int co2Level) {
        this.date = date;
        this.co2Level = co2Level;
    }

    // #region Getters and Setters
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

    // #region Data Fetching
    // Method to fetch and parse CO2 data from a URL
    public static List<Co2Data> getData(String csvURL, int classRoomNumber) {
        List<Co2Data> dataList = new ArrayList<>();
        Date referenceDate = new Date(11, 8, 2024, 0, 0); // Reference date: August 11, 2024

        try {
            URL url = new URL(csvURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/csv");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            br.readLine(); // Skip header line

            String output;
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

        return dataList;
    }

    // #region Date Comparison
    // Method to compare if the data date is newer than the reference date
    private static boolean isNewerThanReferenceDate(Date dataDate, Date referenceDate) {
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

    // #region Data Parsing
    // Method to parse CO2 data from a CSV line
    private static Co2Data parseData(String csvLine, int classRoomNumber) {
        String[] fields = csvLine.split(",");
        if (fields.length < 5)
            return null;

        try {
            String[] dateTime = fields[0].split(" ");
            String[] dateParts = dateTime[0].split("-");
            String[] timeParts = dateTime[1].split(":");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            Date date = new Date(day, month, year, hour, minute);

            int co2Level = Integer.parseInt(fields[2]);

            return new Co2Data(date, co2Level);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // #region ToString Method
    // Method to return a string representation of the CO2 data
    @Override
    public String toString() {
        return "Date: " + date + ", CO2 Level: " + co2Level;
    }
}
