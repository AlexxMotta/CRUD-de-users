package spring.beginner.ProjectDani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.beginner.ProjectDani.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    
    @Query("SELECT u from User u where u.id >= :id")
    public List<User> findAllMoreThan(@Param("id") Long id);
}
