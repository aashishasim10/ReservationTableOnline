package group9.group9;

import javax.persistence.*;

@Entity
public class UserEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
     private Integer id;

     private String username;

     private String password;

     private boolean isAdmin;

    public Integer getId() {
        return id;
    }

    public void setUserId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "UserEntity [isAdmin=" + isAdmin + ", password=" + password + ", user_id (aka. id) =" + id + ", username="
                + username + "]";
    }

     








}
