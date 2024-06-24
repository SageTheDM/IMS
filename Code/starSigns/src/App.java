import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        while (true) {
            // user Input birthday
            int birthMonth = userInput("Your month");
            int birthDay = userInput("Your Birthday");
            // Is the date real + String
            boolean validateDate = validateDate(birthDay, birthMonth);
            if (validateDate) {
                getStarSign(birthMonth, birthDay);
                int userInput = userInput("Do you want to continue? 1 yes, 2 no");
                if (userInput == 2) {
                    break;
                }
            } else {
                System.out.println("Invalid date please enter another one");
                System.out.println("******************************");
            }
        }
    }

    public static int userInput(String myText) {
        Scanner scan = new Scanner(System.in);
        System.out.println(myText);
        return scan.nextInt();
    }

    public static void getStarSign(int month, int day) {
        String starSign;
        switch (month) {
            case 1:
                if (day <= 20) {
                    starSign = "Capricorn";
                } else {
                    starSign = "Aquarius";
                }
                break;
            case 2:
                if (day <= 19) {
                    starSign = "Aquarius";
                } else {
                    starSign = "Pisces";
                }
                break;
            case 3:
                if (day <= 20) {
                    starSign = "Pisces";
                } else {
                    starSign = "Aries";
                }
                break;
            case 4:
                if (day <= 20) {
                    starSign = "Aries";
                } else {
                    starSign = "Taurus";
                }
                break;
            case 5:
                if (day <= 21) {
                    starSign = "Taurus";
                } else {
                    starSign = "Gemini";
                }
                break;
            case 6:
                if (day <= 21) {
                    starSign = "Gemini";
                } else {
                    starSign = "Cancer";
                }
                break;
            case 7:
                if (day <= 22) {
                    starSign = "Cancer";
                } else {
                    starSign = "Leo";
                }
                break;
            case 8:
                if (day <= 23) {
                    starSign = "Leo";
                } else {
                    starSign = "Virgo";
                }
                break;
            case 9:
                if (day <= 23) {
                    starSign = "Virgo";
                } else {
                    starSign = "Libra";
                }
                break;
            case 10:
                if (day <= 23) {
                    starSign = "Libra";
                } else {
                    starSign = "Scorpio";
                }
                break;
            case 11:
                if (day <= 22) {
                    starSign = "Scorpio";
                } else {
                    starSign = "Sagittarius";
                }
                break;
            case 12:
                if (day <= 21) {
                    starSign = "Sagittarius";
                } else {
                    starSign = "Capricorn";
                }
                break;
            default:
                starSign = "Invalid month";
        }

        System.out.println("with the birthday " + day + ". " + month + " your assigned star sign is: " + starSign);
    }

    public static boolean validateDate(int day, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return (day <= 31 && day > 0);
            case 4, 6, 9, 11:
                return (day <= 30 && day > 0);
            case 2:
                return (day <= 29 && day > 0);
            default:
                return false;
        }
    }
}
