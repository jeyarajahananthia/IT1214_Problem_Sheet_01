class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber,String accountHolder,double blance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	int getAccountNumber(){
		return accountNumber;
	}
	
	void deposit(double amount){
		if(amount>0){
			this.balance+=amount;
			System.out.println("Deposited. new balance is "+this.balance);
		}
		else{
			System.out.println("deposit amount must be positive");
		}
	}
	
	void withdraw(double amount)throws IllegalArgumentException{
		if(amount<=0){
			throw new IllegalArgumentException("withdrawal amount must be positive");
		}
		if(this.balance<amount){
			throw new IllegalArgumentException("Insufficient balance");
		}
		
		this.balance-=amount;
		System.out.println("withdraw amount is "+amount+" new balance is "+this.balance);
	}
}

class Bank{
	private BankAccount[] account;
	private int no_of_acc=0;
	final int max=5;
	
	
	Bank(){
		account=new BankAccount[max];
	}
	
	void addAccount(BankAccount account){
		if(no_of_acc<max){
		account[no_of_acc]=account;
		no_of_acc++;
		System.out.println(account.getNumber()+" successfully added here!");
	}
	else{
		System.out.println("Can't add into the classroom!");
	}
}

    void withdraw(int accountNumber,double balance){
		BankAccount targetAccount=null;
		for(int i=0; i<no_of_acc ; i++){
			if(account[i].getAccountNumber()==accountNumber){
				targetAccount=account[i];
				break;
			}
		}
		if(targetAccount!=null){
			try{
				targetAccount.withdraw(amount);
			}
			catch(Exception IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
		else{
			System.out.println("Account not found");
		}
	}
	
	void displayDetails(){
		if(no_of_acc==0){
			System.out.println("No Account in the bank");
		}
		//for(int i=0 ; i<no_of_acc ; i++)
	}

	
	
}

class BankManager{
	public static void main(String[] args){
		Bank b=new Bank();
		
		b.addAccount(new BankAccount(1001,"Alice",5000));
		b.addAccount(new BankAccount(1002,"Bob",3000));
		b.addAccount(new BankAccount(1003,"Charlie",1500));
		b.addAccount(new BankAccount(1004,"Diana",7000));
		b.addAccount(new BankAccount(1005,"Eve",200));
		b.addAccount(new BankAccount(1006,"Frank",1000));
		
		b.displayDetails();
		
		b.withdraw(1001,6000);
		
		b.withdraw(1002,1000);
		
		b.withdraw(1001,-100);
		
		b.withdraw(9999,500);
	}
}