public class App {
    public static void main(String[] args) throws Exception {

        // Variables
        byte byteLuca;
        short shortLuca;
        int intLuca;
        long longLuca;
        float floatLuca;
        double doubleLuca;

        // Strings to shorten the text
        String a = "\"byteLuca\"";
        String b = "\"shortLuca\"";
        String c = "\"intLuca\"";
        String d = "\"longLuca\"";
        String e = "\"floatLuca\"";
        String f = "\"doubleLuca\"";
        String g = "This is the worth of variable ";
        String h = " from the category ";

        // Worth
        byteLuca = 127;
        shortLuca = 128;
        intLuca = 999;
        longLuca = 878897;
        floatLuca = 3.54325f;
        doubleLuca = 3.35355353;

        // Text block + "Datetype" + category: worth
        System.out.println(g + a + h + "byte: " + byteLuca);
        System.out.println(g + b + h + "short: " + shortLuca);
        System.out.println(g + c + h + "int: " + intLuca);
        System.out.println(g + d + h + "long: " + longLuca);
        System.out.println(g + e + h + "float: " + floatLuca);
        System.out.println(g + f + h + "double: " + doubleLuca);

        /*
         * 
         * This comment just demonstrates that i can comment throw multible lines
         * There's no other use for this, please ignore, thank you
         */
    }
}
