package group9.group9;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class PaymentEntity {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Integer paymentID;

   private Integer userid;

   private String cardName;

   private String cardNumber;

   private String expDate;
   
   private String secCode;

public Integer getPaymentID() {
    return paymentID;
}

public void setPaymentID(Integer paymentID) {
    this.paymentID = paymentID;
}

public Integer getUserId() {
    return userid;
}

public void setUserId(Integer userid) {
    this.userid = userid;
}

public String getCardName() {
    return cardName;
}

public void setCardName(String cardName) {
    this.cardName = cardName;
}

public String getCardNumber() {
    return cardNumber;
}

public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
}

public String getExpDate() {
    return expDate;
}

public void setExpDate(String expDate) {
    this.expDate = expDate;
}



public String getSecCode() {
    return secCode;
}

public void setSecCode(String secCode) {
    this.secCode = secCode;
}

@Override
public String toString() {
    return "PaymentEntity [SecCode=" + secCode + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expDate="
            + expDate + ", paymentID=" + paymentID + ", userid=" + userid + "]";
}
   

  








}
