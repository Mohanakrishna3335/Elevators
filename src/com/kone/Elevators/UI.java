package com.kone.Elevators;
import java.util.List;
import java.util.Scanner;

/*
 * UI class contains the methods which are responsible to display in screen/console.
 */
public class UI {

    Cart cart = new Cart();
    private int ch = 0;
    Console logger=new Console();
    
    public UI () {  
        menu();
    }
    
    public void startScreen () {
    	//logger.writeInfo(message);
    	logger.writeInfo("   "+"Hello user please enter your choice!!!"+"  ");
    	logger.writeInfo("  ");
        logger.writeInfo("1. Display Showroom elevators");
        logger.writeInfo("2. Display Elevators in Cart");
        logger.writeInfo("0. Exit");
    }
    
    public void storeElevatorsDetails() {
        logger.writeInfo("1.Add Elevator to Cart");
        logger.writeInfo("2.Remove Elevators From Cart");
        logger.writeInfo("0. Exit");
    }
    
    public void menu () {
        do {
            startScreen();
            getUserInput();
            //Implemented single responsibility in SOLID principles.
            switch (ch) {
                case 1: 
                	columnHeader();
                    displayStoreElevators();
                    userIndication();
                    storeElevatorsDetails();
                    getUserInput();
                    innerChoice();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    
                    break;
            }
        } while (ch != 0);
    }
// inner choice method is used to add or remove vehicle from the vehicle cart.
    private void innerChoice() {
        switch (ch) {
            case 1:
                addElevatorToCart();
                showCart();
                break;
            case 2:
                removeElevatorFromCart();
                break;
            default:
                
                break;
        }
    }
    
   
    private int getUserInput()  {
        try{
    	Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        }
        catch(Exception e){
        	logger.writeError("please enter a valid value");
        	getUserInput();
        	//System.exit(0);
  
        }
       
        return ch;
      
   
    }
    private void columnHeader(){
    	logger.writeInfo("ElevatorType"+" "+"price"+" "+"stock");
    	logger.writeInfo("-------------------------------------");
    }
     private void userIndication(){
    	  logger.writeInfo("   ");
          logger.writeInfo("first choose add or remove option followed by select elevator");
          logger.writeInfo("   ");
    }
//This method is used to display the vehicles present in showRoom.
    private void displayStoreElevators() {
        List<Elevator> elevators = new Elevators().getElevators();
        for (Elevator vech: elevators) {
            logger.writeInfo(vech.getvid() + "- " +vech.getName() + " " +vech.getPrice() + " " +vech.getStock());
        }
    }

    private void addElevatorToCart() {
        int vid = getUserInput();
        cart.addElevatorToCartByVID(vid);      
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeElevatorFromCart() {
        int vid = getUserInput();
        cart.removeElevatorByVID(vid);
    }
}


