package group9.group9;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
    
    public List<TableEntity> giveAllTable(){ 
       List<TableEntity> list=tableRepository.findAll();
        return list;
    }
    
    }
