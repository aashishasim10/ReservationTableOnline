package group9.group9;

import javax.persistence.*;

@Entity
public class TableEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
     private int table_id;

     private int capacity;

     private boolean isReserved;

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

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

    @Override
    public String toString() {
        return "TableEntity [capacity=" + capacity + ", isReserved=" + isReserved + ", table_id=" + table_id + "]";
    }







}
