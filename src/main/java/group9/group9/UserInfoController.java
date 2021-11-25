package group9.group9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller 
public class UserInfoController {
    
@Autowired
UserInfoRepository userinfoRepo;

@Autowired
UserRepository userRepository;

@Autowired
TableRepository tableRepository;


@GetMapping(value= "/registration")
public String showRegistrationPage(Model model){
    UserInfoModel userInfoModel=new UserInfoModel();
    model.addAttribute("userInfoModel",userInfoModel);
    return "register";
}



///This controller will insert the userInformation comoing 
/// from register Page 
@PostMapping("/register") 
public String registerUser(@ModelAttribute("userInfoModel")UserInfoModel userInfo, Model model){
   UserInfoEntity userInfoEntity=new UserInfoEntity();
   userInfoEntity.setFullname(userInfo.getFullname());
   userInfoEntity.setEmail(userInfo.getEmail());
   userInfoEntity.setPhone(userInfo.getPhone());
   userInfoEntity.setAddress1(userInfo.getAddress1());
   userInfoEntity.setAddress2(userInfo.getAddress2());
   userInfoEntity.setCity(userInfo.getCity());
   userInfoEntity.setState(userInfo.getState());
   userInfoEntity.setZipcode(userInfo.getZipcode());
   userInfoEntity.setPassword(userInfo.getPassword());
   userinfoRepo.save(userInfoEntity);

   UserEntity userEntity=new UserEntity();
   userEntity.setUsername(userInfo.getEmail());
   userEntity.setPassword(userInfo.getPassword());
   userEntity.setAdmin(false);

   userRepository.save(userEntity);
   TableModel tableModel=new TableModel();
   List <TableEntity> list=null;
   try{
   list= tableRepository.findAll();
   }
  catch(Exception e){

    
 System.out.println("\n\n\n  YOu got null pointer exception \n\n\n"+e);


  }


   model.addAttribute("list",list);
   ReservationModel reservationModel= new ReservationModel();
   model.addAttribute("userInfoModel",reservationModel);
   

    return "reservation";
}

















}
