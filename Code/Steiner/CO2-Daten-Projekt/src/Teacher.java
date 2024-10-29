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
        nameMap.put("Bä", "Bäcker");
        nameMap.put("Bd", "Bender");
        nameMap.put("Bu", "Burger");
        nameMap.put("Cg", "Chung");
        nameMap.put("Di", "Dimitrov");
        nameMap.put("Do", "Doe");
        nameMap.put("Eh", "Ehrlich");
        nameMap.put("Es", "Esposito");
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
        // Add more mappings as needed
    }

    // Constructor
    public Teacher(String name) {
        setName(name);
        points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = nameMap.getOrDefault(name, name); // Set the name based on the mapping
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
