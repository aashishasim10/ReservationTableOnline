package group9.group9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends JpaRepository<TableEntity,Integer>     {

    public List<TableEntity> findByCapacityAndIsReserved(int  numGuest);
    public TableEntity findByCapacityAndIsReserved(int  numGuest,boolean flag);
   // public TableEntity findByCapacity(int  numGuest);

}
