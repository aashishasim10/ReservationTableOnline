package group9.group9;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HolidayRepository extends CrudRepository<HolidayEntity, Integer> {
    
    //List<HolidayEntity> findByUserid(Integer userid);
    //not sure about the following but makes sense
    public HolidayEntity findByDate(String date);

}
