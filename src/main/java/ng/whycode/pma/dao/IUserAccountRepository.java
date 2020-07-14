package ng.whycode.pma.dao;

import org.springframework.data.repository.CrudRepository;

import ng.whycode.pma.entites.UserAccount;

public interface IUserAccountRepository  extends CrudRepository<UserAccount,Long>{

}
