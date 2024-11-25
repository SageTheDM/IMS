public class Break {
    private Time start;
    private Time end;

    public Break(Time start, Time end) {
        this.start = start;
        this.end = end;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    /**
     * Generates a Thingspeak API link based on channel number, date, and break
     * period.
     * 
     * @param channelNumber The Thingspeak channel number.
     * @param date          The date in format "YYYY-MM-DD".
     * @param breakPeriod   The Break object containing start and end times.
     * @return A formatted URL for fetching data from the Thingspeak API.
     */
    public static String generateLink(int channelNumber, String date, Break breakPeriod) {
        String baseUrl = "https://api.thingspeak.com/channels/";
        String formattedStartDateTime = date + " " + breakPeriod.getStart().toString();
        String formattedEndDateTime = date + " " + breakPeriod.getEnd().toString();

        return baseUrl + channelNumber + "/feeds.csv?start=" + formattedStartDateTime.replace(" ", "%20")
                + "&end=" + formattedEndDateTime.replace(" ", "%20");
    }

    public static void main(String[] args) {
        // Example usage
        Time start = Time.valueOf("00:00:00");
        Time end = Time.valueOf("23:59:59");
        Break breakPeriod = new Break(start, end);

        String date = "2024-11-17";
        int channelNumber = 1364580;

        String link = Break.generateLink(channelNumber, date, breakPeriod);
        System.out.println(link);
    }
}
