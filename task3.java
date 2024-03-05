import java.util.Scanner;
class BankAccount 
{
        private double balance;
        public BankAccount(double initialBalance) 
        {
                balance = initialBalance;
        }
        public double getBalance() 
        {
                return balance;
        }
        public void deposit(double amount) 
        {
                balance += amount;
        }
        public boolean withdraw(double amount) 
        {
                if (balance >= amount) 
                {
                        balance -= amount;
                        return true;
                } 
                else
                {
                        System.out.println("Insufficient funds.");
                        return false;
                }
        }
}
class ATM 
{
        private BankAccount account;
        private Scanner sc;
	public ATM(BankAccount account) 
	{
                this.account = account;
                sc = new Scanner(System.in); 
	}
	public void displayMenu() 
	{
                System.out.println("Welcome to the ATM Interface");
                System.out.println("1.: Withdraw");
                System.out.println("2.: Deposit");
                System.out.println("3.: Check Balance");
                System.out.println("4.: Exit");
                System.out.print("Enter choice:");
	}
	public void processOption(int option) 
	{
                switch (option) 
		{
                        case 1:
                                withdraw();
                                break;
                        case 2:
                                deposit();
                                break;
                        case 3:
                                checkBalance();
                                break;
                        case 4:
                                System.out.println("Thank you for using the ATM. Have a nice Day!");
                                System.exit(0);
                                break;
                        default:
                                System.out.println("Invalid option.");
                }
        }

        public void withdraw() 
	{
                System.out.println("Please enter amount:");
                double amount = sc.nextDouble();
                if (account.withdraw(amount)) 
		{
                        System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
                }
        }

        public void deposit() 
	{
                System.out.println("Enter amount to deposit:");
                double amount = sc.nextDouble();
                account.deposit(amount);
                System.out.println("Deposit successful. Updated balance is: " + account.getBalance());
        }

        public void checkBalance() 
	{
                System.out.println("Current balance is: " + account.getBalance());
        }
}

public class main
{
        public static void main(String[] args) 
	{
                BankAccount bankAccount = new BankAccount(1000.0);
                ATM atm = new ATM(bankAccount);
		while (true) 
		{
                  	atm.displayMenu();
                        Scanner scanner = new Scanner(System.in);
                        int choice = scanner.nextInt();
                        atm.processOption(choice);
                }
        }
}