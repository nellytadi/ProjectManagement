package ng.whycode.pma.dao;

import org.springframework.data.repository.CrudRepository;

import ng.whycode.pma.entites.User;

public interface IUserRepository extends CrudRepository<User,Long> {
	
}
