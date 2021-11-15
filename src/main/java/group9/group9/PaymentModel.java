package group9.group9;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

////@Component
public class PaymentModel {
   
    
    
    private String cardName;
    private String cardNumber;
    private String expDate;
    private String SecCode;



    
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
        return SecCode;
    }
    public void setSecCode(String secCode) {
        SecCode = secCode;
    }


    @Override
    public String toString() {
        return "PaymentModel [SecCode=" + SecCode + ", cardName=" + cardName + ", cardNumber=" + cardNumber
                + ", expDate=" + expDate + "]";
    }




}
