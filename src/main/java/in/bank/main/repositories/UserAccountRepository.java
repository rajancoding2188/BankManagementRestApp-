package in.bank.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bank.main.entities.UserAccount;

public interface UserAccountRepository  extends JpaRepository<UserAccount,Long>{

}
