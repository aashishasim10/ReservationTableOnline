package group9.group9;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//import com.uh.fuelratecheck.ClientEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    
    List<UserEntity> findByUsername(String username);

}
