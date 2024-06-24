public class App {
    public static void main(String[] args) {
        double[] temperaturMesswerte = { 0.1, 4.3, 32.9, 329, 18.5, 123.4, 1.8, -7.3, 0.0, 3.7, -2.1, -455.8, 31.1,
                38.1 };
        double minPlausiblerWert = -60.0;
        double maxPlausiblerWert = 60.0;

        System.out.println("Minimaler Wert: " + minValue(temperaturMesswerte, minPlausiblerWert, maxPlausiblerWert));
        double maximalerWert = maxValue(temperaturMesswerte, minPlausiblerWert, maxPlausiblerWert);
        System.out.println("Maximaler Wert: " + maximalerWert);
    }

    /*
     * minValue
     */
    public static double minValue(double[] messwerte, double minPlausibel, double maxPlausibel) {
        double minValue = Double.MAX_VALUE;
        for (int i = 0; i < messwerte.length; i++) {
            if (minValue > messwerte[i] && messwerte[i] >= minPlausibel && messwerte[i] <= maxPlausibel) {
                minValue = messwerte[i];
            }
        }
        return minValue;
    }

    /*
     * maxValue
     */
    public static double maxValue(double[] messwerte, double minPlausibel, double maxPlausibel) {
        double maxValue = Double.MIN_VALUE;
        for (int i = 0; i < messwerte.length; i++) {
            if (maxValue < messwerte[i] && messwerte[i] >= minPlausibel && messwerte[i] <= maxPlausibel) {
                maxValue = messwerte[i];
            }
        }
        return maxValue;
    }
}