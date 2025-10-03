package in.bank.main.services;

import java.util.List;

import in.bank.main.entities.UserAccount;

public interface UserAccountService 
{
  public UserAccount createAccount(UserAccount userAccount);
  public UserAccount getAccountDetailByAccountNumber(Long accountNumber);
  public List<UserAccount> getAllAccountDetails();
  public UserAccount depositeAmount(Long accountNumber,Double amount);
  public UserAccount withdrawAmount(Long accountNumber,Double amount);
  public boolean closeAccount(long accountNumber);
	 
}
