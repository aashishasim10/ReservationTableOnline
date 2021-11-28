package group9.group9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Integer> {
    
    
    //not sure about the following but makes sense
    public HolidayEntity findByDate(String date);

}
