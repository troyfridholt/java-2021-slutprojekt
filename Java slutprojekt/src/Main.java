import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank;

    public static void main(String[] args) {

        boolean quit = false;
        startApplication();
        printActions();
        while (!quit) {
            System.out.println("\nAnge 1-6 : (6 för att se meny)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {

                case 0 :
                    System.out.println("\nStänger av...");
                    quit = true;
                    break;

                case 1 :
                    bankname();
                    break;

                case 2 :
                    branchname();
                    break;

                case 3 :
                    customername();
                    break;

                case 4 :
                    customertransactions();
                    break;

                case 5 :
                    listcustomers();
                    break;

                case 6 :
                    printActions();
                    break;

                default :
                    System.out.println("\nFinns inget.");
                    break;
            }
        }
    }

    private static void listcustomers() {

        System.out.println("\nAnge namn för att lägga till - ");
        String branchName = scanner.nextLine();
        System.out.println("\nAnge 'true' om du vill ha en lista på kundernas transaktioner, 'false' om du inte vill ha en lista  - ");
        boolean transactionprint = scanner.nextBoolean();
        bank.listCustomers(branchName,transactionprint);

    }


    private static void customertransactions() {

        System.out.println("\nAnge namn - ");
        String branchName = scanner.nextLine();
        System.out.println("\nAnge kund namn - ");
        String customerName = scanner.nextLine();
        System.out.println("\nAnge transaktions volym - ");
        double amount = scanner.nextDouble();
        bank.addCustomerTransactions(branchName,customerName,amount);

    }

    private static void customername() {

        System.out.println("\nAnge namn - ");
        String branchName = scanner.nextLine();
        System.out.println("\nAnge kund namn - ");
        String customerName = scanner.nextLine();
        System.out.println("\nAnge start volym - ");
        double amount = scanner.nextDouble();
        bank.addCustomer(branchName,customerName,amount);
    }

    private static void branchname() {

        System.out.println("\nAnge namn - ");
        String branchName = scanner.nextLine();
        bank.addBranch(branchName);
        System.out.println("Branch - "+branchName+" , is now Registered to be Used.");

    }

    private static void bankname() {

        System.out.println("\nAnge bank namn - ");
        String bankName = scanner.nextLine();
        bank=new Bank(bankName);
        System.out.println("Bank - "+bankName+" , är nu tillagd.");

    }

    private static void startApplication(){

        System.out.println("Startar systemet...");

    }

    private static void printActions(){

        System.out.println("\nMeny :");
        System.out.println("0. Avsluta.");
        System.out.println("1. Lägga till bank namn");
        System.out.println("2. Lägga till Bankens system.");
        System.out.println("3. Lägga till kund till Bankens system.");
        System.out.println("4. Lägga till kundens transaktioner till bankens system.");
        System.out.println("5. Se lista över bankens olika system och kunder");
        System.out.println("6. Se ny meny");
        System.out.println("\n Skriv 1-6 nedanför - ");

    }
}