import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Teacher {
    // #region Fields
    private String name;
    private Map<String, String[]> timetable = new HashMap<>(); // Map of Day -> Teachers in class for that day
    private Points points; // Points field to store teacher's points

    public static final Map<String, String> nameMap = new HashMap<>();

    // #region Initialization
    static {
        // Mapping short names to full teacher names
        nameMap.put("Hm", "Hummel");
        nameMap.put("Bd", "Bender");
        nameMap.put("Bu", "Burger");
        nameMap.put("Cg", "Chung");
        nameMap.put("Do", "Doe");
        nameMap.put("Eh", "Ehrlich");
        nameMap.put("Fh", "Fischer");
        nameMap.put("Gi", "Giordano");
        nameMap.put("Gr", "Graham");
        nameMap.put("Hi", "Higgins");
        nameMap.put("Kg", "Kang");
        nameMap.put("Kh", "Khan");
        nameMap.put("Lz", "Lozano");
        nameMap.put("Lu", "Lund");
        nameMap.put("Or", "Ortega");
        nameMap.put("Re", "Reyes");
        nameMap.put("Se", "Seng");
        nameMap.put("Ts", "Tanaka");
        nameMap.put("Vt", "Vetter");
        nameMap.put("Zu", "Zuniga");
    }

    // #region Constructor
    public Teacher(String name) {
        // Use the short name to find the full name from the nameMap
        this.name = nameMap.getOrDefault(name, "Unknown");
        this.points = new Points(); // Initialize Points object when Teacher is created
    }

    // #region Getters and Setters
    public String getName() {
        return name; // Return the teacher's full name
    }

    public Map<String, String[]> getTimetable() {
        return Collections.unmodifiableMap(timetable); // Return an unmodifiable view of the timetable
    }

    public Points getPoints() {
        return points; // Return the Points object associated with the teacher
    }

    public void setPoints(int fiveMinute, int tenMinutes, int bonusPoints) {
        this.points.setFiveMinuteBreak(fiveMinute);
        this.points.setLongerBreak(tenMinutes);
        this.points.setBonusPoints(bonusPoints);
    }

    public void addPoints(int fiveMinute, int tenMinutes, int bonusPoints) {
        this.points.addFiveMinuteBreakPoints(fiveMinute);
        this.points.addLongerBreakPoints(tenMinutes);
        this.points.addBonusPoints(bonusPoints);
    }

    public int getTotalPoints() {
        return this.points.getTotalPoints();
    }
}
