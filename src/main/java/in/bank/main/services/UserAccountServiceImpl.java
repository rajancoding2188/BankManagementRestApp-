package in.bank.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bank.main.entities.UserAccount;
import in.bank.main.repositories.UserAccountRepository;
@Service
public class UserAccountServiceImpl implements UserAccountService {
   
	@Autowired
	private UserAccountRepository repo;
	@Override
	public UserAccount createAccount(UserAccount userAccount) {
		UserAccount account_saved=repo.save(userAccount);
		return account_saved;
	}

	@Override
	public UserAccount getAccountDetailByAccountNumber(Long accountNumber) {
	Optional<UserAccount> account=repo.findById(accountNumber);
	if(account.isEmpty())
	{
		throw new RuntimeException("Account is not present");
	}
	UserAccount account_found=account.get();
	
		return account_found;
	}

	@Override
	public List<UserAccount> getAllAccountDetails() {
	List<UserAccount> listOfAccounts=repo.findAll();
		return listOfAccounts;
	}

	@Override
	public UserAccount depositeAmount(Long accountNumber, Double amount) {
	Optional<UserAccount> account=repo.findById(accountNumber);
	if(account.isEmpty())
	{
		throw new RuntimeException("Account is not present");
	}
	UserAccount accountPresent=account.get();

	Double totalBalance=accountPresent.getAccount_balance()+amount;
	accountPresent.setAccount_balance(totalBalance);
	repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public UserAccount withdrawAmount(Long accountNumber, Double amount) {
		Optional<UserAccount> account=repo.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account is not present");
		}
		UserAccount accountPresent=account.get();
	
	 Double accountBalance=accountPresent.getAccount_balance()-amount;
	 accountPresent.setAccount_balance(accountBalance);
	 repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public boolean closeAccount(long accountNumber) {
		 if (repo.existsById(accountNumber)) {   // check if account exists
		        repo.deleteById(accountNumber);     // delete it
		        return true;                        // success
		    } else {
		        return false;                       // account not found
		    }
		}
	}
