package group9.group9;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer> {
    
    List<PaymentEntity> findByUserid(Integer userid);

}
