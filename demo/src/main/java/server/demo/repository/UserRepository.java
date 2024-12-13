package server.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.demo.models.User.UserModel;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    // Здесь можно добавлять дополнительные методы, если это необходимо
    List<UserModel> findByUsername(String username);

}

