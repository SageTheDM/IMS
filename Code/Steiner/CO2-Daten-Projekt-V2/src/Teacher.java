import java.util.HashMap;
import java.util.Map;

public class Teacher {
    private String name;
    private Points points;

    public static final Map<String, String> nameMap = new HashMap<>();
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
    }

    public Teacher(String name) {
        this.name = nameMap.getOrDefault(name, "Unknown");
        this.points = new Points();
    }

    public String getName() {
        return name;
    }

    public Points getPoints() {
        return points;
    }
}
