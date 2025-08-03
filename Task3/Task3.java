
import java.util.Scanner;
public class Task3 {
    private double cur = 1000.0; //cur means current balance

    void checkBalance() {
        System.out.println("Your current balance is: $" + cur);
    }

    void deposit(double amount) {
        System.out.println("Enter the amount to deposit:");
        Scanner scanner = new Scanner(System.in);
        double da = scanner.nextDouble();   //da means deposit amount
        if (da <= 0) {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
            return;
        }
        System.out.println("Your current balance is: $" + cur);
        System.out.println("You are about to deposit: $" + da);
        if(da>0){


        cur += da;}
        System.out.println("------Transaction successful.------");
        System.out.println("Your new balance is: $" + cur);
       
    }
    void withdraw(double amount){
        System.out.println("Your current balance is: "+ cur);
        System.out.println("Enter the amount to withdraw:");
        Scanner scanner = new Scanner(System.in);
        double wda = scanner.nextDouble(); //wda means withdraw amount
        try{
            if (wda <= 0) {
                System.out.println("Invalid withdrawal amount. Please enter a positive number.");
                return;
            }
        
        if (wda <= cur) {
            System.out.println("You have withdrawn: $" + wda);
            System.out.println("------Transaction successful.------");
            cur -= wda;
            System.out.println("Your new balance is: $" + cur);
        } else {
            System.out.println("Insufficient funds. Your current balance is $"+cur);
            System.out.println("You cannot withdraw: $" + wda);
            
        } 
    }
    catch (Exception e) {
            System.out.println("An error occurred during the transaction. Please try again.");
        }
    }
    public static void main(String[] args) {
       double amount=0;
        Task3 task = new Task3();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Welcome to ATM ---\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    task.checkBalance();
                    break;
                case 2:
                    task.deposit(amount);
                    break;
                case 3:
                    task.withdraw(amount);
                    break;
                case 4:
                    
                    System.out.println("\n-----------Thank you for using the ATM !!-------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }

    }
}
