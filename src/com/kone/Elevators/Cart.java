package com.kone.Elevators;
import java.util.ArrayList;
import java.util.List;


class Cart {
    Console logger = new Console();
    List<Elevator> cartItems = new ArrayList<Elevator>();
    
    public void addElevatorToCartByVID(int vid) {
       Elevator elevator = getElevatorByElevatorID(vid);
        addToCart(elevator);
    }

    private Elevator getElevatorByElevatorID(int vid) {
    	 Elevator elevator = null;
        List<Elevator> elevators = new Elevators().getElevators();
        for (Elevator vech: elevators) {
            if (vech.getvid() == vid) {
                elevator = vech;
                break;
            }
        }
        return elevator;
    }

    private void addToCart(Elevator vehicle) {
        cartItems.add(vehicle);
    }

    public void removeElevatorByVID(int vid) {
        Elevator vech = getElevatorByElevatorID(vid);
        cartItems.remove(vech);
    }

    void printCartItems() {
        for (Elevator vech: cartItems) {
            logger.writeInfo(vech.getName()+"  "+vech.getPrice());
        }
    }
}
