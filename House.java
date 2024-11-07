import java.util.ArrayList; 

/* This is a stub for the House class */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean diningRoom; 
  private boolean elevator; 
  private String diningMeals;
/**
 * Constructor for the House class, which extends the Building class.
 * @param name string 
 * @param address string 
 * @param nFloors integer
 * @param diningRoom boolean true or false 
 * @param elevator boolean true or false 
 */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator) {
    super(name, address, nFloors); // initilizes building from super class (Building)
    this.diningRoom = diningRoom; // sets has dining room constructor 
    this.elevator = elevator; 
    this.residents = new ArrayList<>(); // initilizes empty array list for residents 
    System.out.println("You have built a house: 🏠");
  }

  // overloads constructor to change dining hall to string 
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator, String diningMeals) {
    super(name, address, nFloors); // initilizes building from super class (Building)
    this.diningRoom = diningRoom; // sets has dining room constructor 
    this.elevator = elevator; 
    if (!this.diningRoom){
      throw new RuntimeException("Cannot assign a meal type if house does not have a dining hall"); 
    }
    else{
      this.diningMeals = diningMeals; // corresponds to what food.. ex. Nogi = Vegetarian 
    }
    this.residents = new ArrayList<>(); // initilizes empty array list for residents 
    System.out.println("You have built a house: 🏠");
  }
  /**
   * Getter for if the house has a dining hall or not 
   * @return boolean true if dining hall, false is not 
   */
  public boolean hasDiningRoom(){
    return this.diningRoom; // returns true if has dining room 
  }
// overrides hasDiningRoom by returning meals if requested 
  public String hasDiningRoom(boolean menu){
    if (!this.diningRoom){
      throw new RuntimeException("Cannot assign a meal type if house does not have a dining hall"); 
    }
    else{
      return this.diningMeals; 
    }
  }
  /**
   * getter for the number of residents currently in the house
   * @return integer number of residents in the house 
   */
  public int nResidents(){
    return this.residents.size(); // returns length of arraylist containing students 
  }
  /**
   * Moves in a resident of an input name. If the resident already lives in the house, throws an exception.
   * @param name string of resident to move in 
   */
  public void moveIn(String name){
    if (this.residents.contains(name)){
      throw new RuntimeException("Student "+name+" already lives in "+this.name+"."); 
    }
    else{
      this.residents.add(name); // adds name to list if student is not already in house 
    }

  }
  /**
   * Move out a resident of an input name. If resident does not currently live in the house, 
   * throws an exception
   * @param name string of resident to remove 
   * @return name of student who moved out 
   */
  public String moveOut(String name){
    if (!this.residents.contains(name)){ // if does not contain name 
      throw new RuntimeException("Student "+name+" does not live in "+this.name+"."); 
    }
    else{
      this.residents.remove(name); // remove name from list 
    }

    return name; // return the name of the person who moved out
  }
  /**
   * Determines if a student of a certain name lives in the house 
   * @param person name of person to check if they live in the house
   * @return boolean true if resident is in house, false if they are not
   */
  public boolean isResident(String person){
    return this.residents.contains(person); // returns true if person lives in house 
  }

  public void goUp(int nfloors) {
    if (this.elevator){ 
      this.goToFloor(this.activeFloor + nfloors);
    }
    else{
      this.goToFloor(this.activeFloor + 1);
    }
}

public void goDown(int nfloors) {
  if (this.elevator){ 
    this.goToFloor(this.activeFloor - nfloors);
  }
  else{
    this.goToFloor(this.activeFloor - 1);
  }

}

/**
 * Overwrite showOptions method of parent Building class to include additional house methods
 */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResidents()\n + moveIn(name)\n + moveOut(name)\n + isResident(name)");
}

  public static void main(String[] args) {
    House Northrop = new House("Northrop", "10 Elm Street", 5, true, true);
    System.out.println(Northrop.getAddress()); 
    Northrop.moveIn("Ash"); 
    System.out.println("Number of residents:" + Northrop.nResidents()); 
    System.out.println("is Ash a resident of Northrop? " +Northrop.isResident("Ash"));
    Northrop.moveOut("Ash"); 
    System.out.println("Does Northrop have a dining hall? "+Northrop.hasDiningRoom());
    //Northrop.moveOut("Kira"); 
    Northrop.showOptions();


    

  }

}