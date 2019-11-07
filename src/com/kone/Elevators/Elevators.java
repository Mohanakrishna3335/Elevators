package com.kone.Elevators;
import java.util.ArrayList;
import java.util.List;
/*
 *  provides information about our showRoom vehicles  cart.
 */

public class Elevators {
    private  List<Elevator> elevators = new ArrayList<Elevator>();

    public Elevators () {
        this.initStoreItems();
    }
    
    public List<Elevator> getElevators() {
        return elevators;
    }
    
    public void initStoreItems() {
    	
        String [] elevatorNames = {"Connected", "non-connected", "digital experience","Oits","ThyssenKrupp"};
        Double [] elevatorPrice = {5.82d, 4.69d, 9.0d, 4.3d,4.4d};
        Integer [] stock = {10, 16, 12, 13,9,7};
        
        for (int i=0; i < elevatorNames.length; i++) {
            this.elevators.add(new Elevator(i+100, elevatorNames[i], elevatorPrice[i], stock[i]));
        }
    }
}

