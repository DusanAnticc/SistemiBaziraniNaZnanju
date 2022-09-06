package sbnz.integracija.example.repository;

import sbnz.integracija.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select user from User user where user.deleted = false" )
	    List<User> findAll();

    @Query("select user from User user where user.username = ?1 and user.deleted = false" )
    	User findByUsername(String username);
}
