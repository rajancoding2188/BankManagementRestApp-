package in.bank.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bank.main.entities.UserAccount;
import in.bank.main.services.UserAccountService;

@RestController
@RequestMapping("/account")
public class MyController {
	@Autowired
	 private UserAccountService userService;
	

	@PostMapping("/create")//1.create the  bank  account
    public ResponseEntity<UserAccount> createAccount(@RequestBody UserAccount userAccount)
       { UserAccount createAccount=userService.createAccount(userAccount);
	     return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
       }    

	@GetMapping("/{accountNumber}")//2.get account by accountNumber
	public ResponseEntity<UserAccount> getAccountByAccountNumber(@PathVariable Long accountNumber)
	{
		UserAccount account=userService.getAccountDetailByAccountNumber(accountNumber);
		if(account!=null)
		{
			return ResponseEntity.ok().body(account);
		}
		else {
			return ResponseEntity.notFound().build();
		}
      }
    @GetMapping("/allAccountUser")//3.get allAccount user 
    public List<UserAccount> getAllUserDetails()
    {
		 List<UserAccount> allAccountDetaiList=userService.getAllAccountDetails();
    	return allAccountDetaiList;// we can directly return userService.getAllAccountDetails();
    }
    @PutMapping("/deposite/{accountNumber}/{amount}")// 4.deposite the money by accountNumber with amount
    public UserAccount depositeAccount(@PathVariable Long  accountNumber,@PathVariable Double  amount)
    {   
    	UserAccount account=userService.depositeAmount(accountNumber, amount);
    	return account;
    }
    
   @PutMapping("/withdraw/{accountNumber}/{amount}")// 4.deposite the money by accountNumber with amount
    public UserAccount withdrawAccount(@PathVariable Long  accountNumber,@PathVariable Double  amount)
    {   
    	UserAccount account=userService.withdrawAmount(accountNumber,amount);
    	return account;
    }
   
    @DeleteMapping("/delete/{accountNumber}")//5. delete UserAccount by accountNumber 
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber)
    {
    	//userService.closeAccount(accountNumber);
    //	return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account Closed");
    	boolean deleted = userService.closeAccount(accountNumber);
        if (deleted) {
            return ResponseEntity.ok("Account Closed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
    	
    	
    }
}







