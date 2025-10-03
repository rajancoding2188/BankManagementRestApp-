package in.bank.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserAccount
{  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long account_number;
  @Column
  private String account_holder_name;
  @Column
  private Double account_balance;
  
//GETTER AND SETTER METHOD GENERATE

public Long getAccount_number() {
	return account_number;
}
public void setAccount_number(Long account_number) {
	this.account_number = account_number;
}
public String getAccount_holder_name() {
	return account_holder_name;
}
public void setAccount_holder_name(String account_holder_name) {
	this.account_holder_name = account_holder_name;
}
public Double getAccount_balance() {
	return account_balance;
}
public void setAccount_balance(Double account_balance) {
	this.account_balance = account_balance;
}
 //TO stringMethod 
@Override
public String toString() {
	return "UserAccount [account_number=" + account_number + ", account_holder_name=" + account_holder_name
			+ ", account_balance=" + account_balance + "]";
}

    
 


  
  
}
