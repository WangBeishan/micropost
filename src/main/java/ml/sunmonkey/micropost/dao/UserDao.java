package ml.sunmonkey.micropost.dao;

import ml.sunmonkey.micropost.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>{

    User findUserById(Long id);

    User findUserByEmail(String email);

    int removeUserById(Long id);
}
