
/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for Cafe class, extends attributes of Building class
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors); // initilizes building from super class (Building)
        this.nCoffeeOunces = 10; // initilizes values for each attribute
        this.nSugarPackets = 5; 
        this.nCreams = 7; 
        this.nCups = 4; 
        System.out.println("You have built a cafe: ☕"); 
    }
// builds cafe but you only have so much money, so the number of things is set by the budget 
    public Cafe(String name, String address, int nFloors, Double Budget) {
        super(name, address, nFloors); // initilizes building from super class (Building)
        this.nCoffeeOunces = Budget.intValue()/4; // initilizes values for each attribute
        this.nSugarPackets = Budget.intValue()/4;
        this.nCreams = Budget.intValue()/4;
        this.nCups = Budget.intValue()/4;
        System.out.println("You have built a cafe on a budget: ☕"); 
    }
/**
 * Sells a coffee with a user input size, sugar packets, creams, and one cup. 
 * If there is not enough of any material left, code restocks up to the missing amount to make the order
 * @param size : size of coffee in oz 
 * @param nSugarPackets : number of sugar packets in coffee
 * @param nCreams : number of creams in coffee
 * does not return anything but prints message indicating coffee has been made successfully.
 */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        boolean restock = false; // initilizes restock true/false 
        int diffCoffeeOunces = 0; 
        int diffCreams = 0; 
        int diffCups = 0; 
        int diffSugarPackets = 0; 

        if (this.nCoffeeOunces - size < 0){ // checks if the current number of coffee ounces is enough to fill the order 
            diffCoffeeOunces = size - this.nCoffeeOunces;  // checks how much coffee is needed 
            restock = true;  // sets restock variable to true 
        }
        if (this.nSugarPackets-nSugarPackets < 0){ //"", sugar packets
            diffSugarPackets = nSugarPackets - this.nSugarPackets; 
            restock = true; 
        }
        if (this.nCreams-nCreams < 0){ //"" creams 
            diffCreams = nCreams - this.nCreams; 
            restock = true; 
        }
        if (this.nCups - 1 < 0){ //"" cups 
            diffCups = 10; // just add 10 more cups bc diff cups will always be 1 
            restock = true; 
        } 

        if (restock){ // if any of the 4 inventory items is missing, restock 
            System.out.println("Restocking!");
            this.restock(diffCoffeeOunces, diffSugarPackets, diffCreams, diffCups); // adds just enough items to the inventory to complete the order
        }
        // subtracts order counts from inventory counts to fill the order
        this.nCoffeeOunces = this.nCoffeeOunces - size; 
        this.nSugarPackets = this.nSugarPackets - nSugarPackets; 
        this.nCups = this.nCups - 1; 
        this.nCreams = this.nCreams - nCreams; 
    }
    /**
     * restocks materials 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;  // increases each item by a certain amount specified in the input
        this.nSugarPackets += nSugarPackets; 
        this.nCreams += nCreams; 
        this.nCups += nCups; 

        System.out.println("Here's your coffee!");
    } 
    /**
     * Shows options of class, overrides showOptions of Building class by adding in sellCoffee function 
     * I did not ad in the restock() method because it is private to the class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(nCoffeeOunces, nSugarPackets, nCreams)");
    }

    public static void main(String[] args) {
       Cafe Compass = new Cafe("Compass", "1 Chapin Way", 1);
       Compass.showOptions();
       Compass.sellCoffee(10, 10, 10);
    }
    
    }
