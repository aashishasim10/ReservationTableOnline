package group9.group9;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;

/* this file can be combined into the reservation page */


@Controller
public class TableController {
  
  @Autowired
  TableRepository tableRepository;  

// this method will direst to addTable html Page
@GetMapping("/displayAvailableTable")
public String showAddTable(Model map, HttpServletRequest request){
    List<TableEntity> tableList= tableRepository.findByIsReserved(false);
  
    map.addAttribute("list", tableList);

    //fetch the cookie and find the userid
    Cookie cookie1[] = request.getCookies();
    String userid="";
    for(int i=0; i<cookie1.length; i++) {
        userid = cookie1[i].getValue();
        try{
            Integer.parseInt(userid);
        }
        catch(NumberFormatException e)
        {
            userid=null;
        }
        if(userid != null)
        {
            break;
        }
    }
    
    return "displayAvailableTable";
}


// this method will get Table Information from addtable html
// Save the information to Database on Table Entity 
@PostMapping("/saveTable")
public String insertTableDB(@ModelAttribute("tableModel")TableModel tableModel, ModelMap model){
TableEntity tableEntity= new TableEntity();
tableEntity.setCapacity(tableModel.getCapacity());
tableEntity.setReserved(tableModel.isReserved());
tableRepository.save(tableEntity);
String message ="Your Information is Successfully  Save to Our System ";
model.addAttribute("msg", message);
return "addTable";
}


//This Method will Show all the Table on the system 
@RequestMapping("/displayTable")
public String displayAvailableTable(ModelMap model){
    List<TableEntity> tableList= tableRepository.findAll();

  model.addAttribute("list", tableList);
    return "displayAvailableTable";

    
}

@RequestMapping("/selectTable")
public String selectTable(@RequestParam(name="tid")int tid,Model model){
    //int id=Integer.parseInt(tid);
    TableEntity tableList= tableRepository.findById(tid).get();
    
    tableList.setReserved(true);
    tableRepository.save(tableList);

    model.addAttribute("list", tableList);
    return "reservationHistory";
}

@RequestMapping("/checkReservation")
public String checkReservation(Model map){
    
    return "allReservation";
}



//@RequestMapping("/combineTable")
//public String combineTable(@RequestParam(name="guestNo") String  guest,Model map){

//return "reservationHistory";
//}



@RequestMapping("/combineTable")
public String combineTable( @RequestParam(name="num")String num, Model map){

    List<Integer> listTid=new ArrayList<>();
int guest=Integer.parseInt(num);
if(guest%2!=0){
    guest++;
}

if(guest>2 && guest<9){


if(guest==8){
   List<TableEntity> t1= tableRepository.findByCapacityAndIsReserved(6, false);
   List<TableEntity> t2= tableRepository.findByCapacityAndIsReserved(2, false);
   listTid.add(t1.get(0).getTable_id());
   listTid.add(t2.get(0).getTable_id());


}
else if(guest==6){
    List<TableEntity> t1= tableRepository.findByCapacityAndIsReserved(4, false);
    List<TableEntity> t2= tableRepository.findByCapacityAndIsReserved(2, false);
    listTid.add(t1.get(0).getTable_id());
    listTid.add(t2.get(0).getTable_id());
}

else{// guest ===4

    List<TableEntity> t1= tableRepository.findByCapacityAndIsReserved(2, false);
    List<TableEntity> t2= tableRepository.findByCapacityAndIsReserved(2, false);
    listTid.add(t1.get(0).getTable_id());
    listTid.add(t2.get(0).getTable_id());

}

}
else{
    return "displayAvailableTable";  
}
System.out.println("List if Table Id Is --");
System.out.println(listTid);
map.addAttribute("list", listTid);

TableEntity table1=tableRepository.findById(listTid.get(0)).get();
table1.setReserved(true);
tableRepository.save(table1);

TableEntity table2=tableRepository.findById(listTid.get(1)).get();
table2.setReserved(true);
tableRepository.save(table2);

/////I want use user Id And User_Info ID\
/*
 private Integer id;
    private Integer userid;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String date;
    private String time;
    private int numOfGuests;
    private boolean isHoliday;

*/


return "reservationHistory";
}



@RequestMapping("/selectTable")
public String selectTable(@RequestParam(name="tid")String tid,Model map){
    
    int tableId=Integer.parseInt(tid);


return null;
}







}
