package group9.group9;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Integer>{
    


}
