package fk;

public class Player {
	private String name;
	private double saldo;
	
	public Player (String name, double saldo) {
		this.name = name;
		this.saldo = saldo;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSaldo() {
		return saldo;
	}
   
    public void deposit(double amount) {
        saldo += amount;
    }
    
    public void withdraw(double amount) {
        saldo -= amount;
    }
}
