package group9.group9;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

////@Component
public class PaymentModel {
   
    private String cardName;
    private String cardNumber;
    private String expDate;
    private String secCode;

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
        return "PaymentModel [SecCode=" + secCode + ", cardName=" + cardName + ", cardNumber=" + cardNumber
                + ", expDate=" + expDate + "]";
    }




}
