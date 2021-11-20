package group9.group9;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity,Integer>{
   
    
}
