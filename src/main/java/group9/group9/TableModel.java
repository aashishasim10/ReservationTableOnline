package group9.group9;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableModel {
    

    @Autowired 
    TableRepository tableRepository;

    
    private int capacity;
    
    private boolean isReserved;
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean isReserved() {
        return isReserved;
    }
    
    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
    
    
//// Thsi method  will give take number of guest from User 
//// This  method will return the table id
  public boolean assignTable(int numGuest) throws NullPointerException{
     boolean flag =false;
       TableEntity list=null;
     
      try{
      list=tableRepository.findByCapacityAndIsReserved(numGuest,false);
      flag=list.isReserved();
      }
      catch(Exception e){
          System.out.println("Exception in TableModel --boolean assignTable(int numGuest)");
          System.out.println(e);
          return false;
      }

      if(flag){
          return true;
      }
      else{
        return false;
      }
    
  }    






 //// This method will give list of two table 
 ////it will take numof guest
public List<TableEntity> combineTable(int numGuest){
//// number of Guest can be  2,4,6 ,8 ..
List<TableEntity> list=new ArrayList<TableEntity>();

if(numGuest%2!=0){
    numGuest+=1;
}
else if(numGuest>8 && numGuest<1){

    return null;
}
else{
    ////// numGuest is 8 //---- we can combine 4 and 4 or 6 and 2 
   if(numGuest==8){

    TableEntity listTable1 =tableRepository.findByCapacityAndIsReserved(6,false);
    TableEntity listTable2 =tableRepository.findByCapacityAndIsReserved(2,false);

    if(listTable1==null && listTable2==null){
         listTable1 =tableRepository.findByCapacityAndIsReserved(4,false);
         listTable2 =tableRepository.findByCapacityAndIsReserved(4,false);
    }
    list.add(listTable1);
    list.add(listTable2);

   }
   ////// numGuest is 6 //---- we can combine 4 and 2 
   else if(numGuest==6){
    TableEntity listTable1 =tableRepository.findByCapacityAndIsReserved(4,false);
    TableEntity listTable2 =tableRepository.findByCapacityAndIsReserved(2,false);
    list.add(listTable1);
    list.add(listTable2);

   }
   ////// numGuest is 4  //---- we can combine 2 and 2 
   else if(numGuest==4){
    TableEntity listTable1 =tableRepository.findByCapacityAndIsReserved(2,false);
    TableEntity listTable2 =tableRepository.findByCapacityAndIsReserved(2,false);
    list.add(listTable1);
    list.add(listTable2);

    }
    else{

    }

}

    return list;
}











    
    }
