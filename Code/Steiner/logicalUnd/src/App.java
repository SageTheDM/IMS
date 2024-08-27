/*
Formulieren Sie die folgenden Aussagen als if)-Bcdingung: 
a) y ist positiv. 
b) a liegt im Intervall —2 bis 5.3. 
c) Der Preis ist kleiner als 5% von 20.— CHE 
d) x ist kleiner als 5 und ungerade. 
e) t liegt im Intervall [—3, 6) oder im Intervall (2, 8). Die Intervallgrenlßn 
den üblicherweise mit eckigen oder runden Klammern angegeben. 
Bei eckigen Klammern gehören die Intervallgrenzen dazu (inklusive). Bei 
runden Klammern gehören die Grenzen nicht dazu (exklusive). In der Auf- 
gabe gehört also z. B. die Zahl —3 dazu, wohingegen die Zahl 8 nicht Teil des 
Intervalls ist. 
*/

public class App {
    public static void main(String[] args) throws Exception {
        int y = 0;
        double a = 5.3;
        double price = 0;
        int x = 3;
        int t = 4;

        if (y >= 0) {
            System.out.println("yes");
        }
        if (a >= -2 && a <= 5.3) {
            System.out.println("YES");
        }
        if (price < 20 * 0.05) {
            System.out.println("YES!");
        }
        if (x < 5 && x % 2 >= 0) {
            System.out.println("tricky");
        }
        if ((t >= -3 && t < 6) || (t > 2 && t < 8)) {
            System.out.println("YEEEEEES");
        }

    }

}
