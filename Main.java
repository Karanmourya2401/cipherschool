package summerClasses.BusTicketSystem;

//import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Press 1 for User Signup" +
                "\nPress 2 for User Login" +
                "\nPress 3 for Exit");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        SignUpLogin signUpLogin = new SignUpLogin();
        BusOperator busOperator = new BusOperator();
        busOperator.addBus("Bus101", "Amit travels", "Bhilwara", "Phagwara", 1200,5);
        busOperator.addBus("Bus102", "Chirag travels", "Bhilwara", "Shikar", 1200,3);
        busOperator.addBus("Bus103", "Laxmi travels", "Bhilwara", "Jaipur", 1200,2);
        busOperator.addBus("Bus104", "ZigZag travels", "Bhilwara", "Phagwara", 1200,1);
        while (choice != 3) {
            if (choice == 1) {
                System.out.println("Enter name");
                String name = sc.next();
                System.out.println("Enter Phone number");
                int number = sc.nextInt();
                System.out.println("Enter Email");
                String email = sc.next();
                System.out.println("Enter Street");
                String street = sc.next();
                System.out.println("Enter City");
                String city = sc.next();
                System.out.println("Enter State");
                String state = sc.next();
                System.out.println("Enter Password");
                String password = sc.next();
                System.out.println(signUpLogin.signup(name, number, email, street, city, state, password));
                System.out.println("Press 1 for User Signup" +
                        "\nPress 2 for User Login" +
                        "\nPress 3 for Exit");


                choice = sc.nextInt();
            }
            if (choice == 2) {
                System.out.println("Enter Email");
                String email = sc.next();

                System.out.println("Enter Password");
                String password = sc.next();

                String Log = signUpLogin.login(email, password);
                System.out.println(Log);

                if (Log == "Login succesfull") {
                    System.out.println("Press 4 to check bus" +
                            "\nPress 5 to change password" +
                            "\nPress 6 to go back");
                    int busDetail = sc.nextInt();
                    while (busDetail != 6) {

                        if (busDetail == 4) {
                            System.out.println("Enter source");
                            String source = sc.next();
                            System.out.println("Enter destination");
                            String destination = sc.next();
                            List result = busOperator.searchBus(source, destination);
                            System.out.println(result);
                            if(!result.isEmpty()) {
                                System.out.println("press \'b\' for booking and \'a\' to go back");
                                String book = sc.next();
                                if (book.equals("b")) {
                                    Scanner scanner=new Scanner(System.in);
                                    System.out.println("Enter Operators name which you want to book");
                                    String operator = scanner.nextLine();
                                    busOperator.busBooking(operator);
                                }
                            }
                        }
                        if (busDetail == 5) {
                            System.out.println("Enter new password");
                            String pass = sc.next();
                            System.out.println(signUpLogin.changePass(email, pass));
                        }
                        System.out.println("Press 4 to check bus" +
                                "\nPress 5 to change password" +
                                "\nPress 6 to go back");
                        busDetail = sc.nextInt();

                    }

                }
                System.out.println("Press 1 for User Signup" +
                        "\nPress 2 for User Login" +
                        "\nPress 3 for Exit");
                choice = sc.nextInt();
            }
        }
    }
}
