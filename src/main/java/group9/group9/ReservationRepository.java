package group9.group9;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {
    
    List<ReservationEntity> findByUserid(Integer userid);

   List<ReservationEntity> findByDateAndTimeAndId(String date,String time,int id);
/*


  private String date;
    private String time;


*/

}
