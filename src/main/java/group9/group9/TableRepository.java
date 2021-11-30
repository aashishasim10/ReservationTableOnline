package group9.group9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends JpaRepository<TableEntity,Integer>     {
    
     List<TableEntity> findByIsReserved(boolean f);

     List<TableEntity> findByCapacityAndIsReserved(int num,boolean flag);
}
