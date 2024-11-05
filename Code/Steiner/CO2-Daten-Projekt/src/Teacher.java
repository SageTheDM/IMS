import java.util.HashMap;
import java.util.Map;

public class Teacher {
    private String name;
    private int points;

    // Mapping of initials to full names
    private static final Map<String, String> nameMap = new HashMap<>();

    // Static block to initialize the name mappings
    static {
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
        // No additional mappings beyond those present in the timetable
    }

    // Constructor
    public Teacher(String name) {
        setName(name);
        points = 0; // Initialize points to zero
    }

    public String getName() {
        return name; // Return the full name of the teacher
    }

    public void setName(String name) {
        this.name = nameMap.getOrDefault(name, name); // Set the name based on the mapping
    }

    public int getPoints() {
        return points; // Return the current points
    }

    public void setPoints(int points) {
        this.points = points; // Set the points to a specific value
    }

    public void addPoints(int points) {
        this.points += points; // Add points to the current total
    }
}
