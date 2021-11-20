package group9.group9;

import javax.persistence.*;

@Entity
public class UserEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
     private int user_id;

     private String username;

     private String password;

     private boolean isAdmin;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "UserEntity [isAdmin=" + isAdmin + ", password=" + password + ", user_id=" + user_id + ", username="
                + username + "]";
    }

     








}
