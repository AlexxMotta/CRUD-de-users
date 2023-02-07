package spring.beginner.ProjectDani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.beginner.ProjectDani.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    
    @Query("SELECT u from User u where u.id >= :id")
    public List<User> findAllMoreThan(@Param("id") Long id);

    //greater than - maior que
    public List<User> findByIdGreaterThan(Long id);

    //o codigo abaixo retorna erro caso mais de um user tem o mesmo name
    //um solução no JS seria usar o .first() mas aqui é java então ...
    public User findByName(String name);
}
