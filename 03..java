class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    int getAccountNumber(){
        return accountNumber;
    }

    String getAccountHolder(){
        return accountHolder;
    }

    double getBalance(){
        return balance;
    }

     void setBalance(double balance){
        this.balance = balance;
    }

     void withdraw(double amount){
        if (amount > balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    
}

 class Bank {
private BankAccount[] accounts;
    private int count;

     Bank(){
        accounts = new BankAccount[5]; // max 5 accounts
        count = 0;
    }

     void addAccount(BankAccount account) {
        if (count < 5) {
            accounts[count++] = account;
        } else {
            System.out.println("Bank is full. Cannot add more accounts.");
        }
    }

    void withdraw(int accNum, double amount){
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNum){
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful.");
                } catch (IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    void displayAccounts(){
        for (int i = 0; i < count; i++){
            accounts[i].display();
        }
    }
}

