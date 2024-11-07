import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        // my new buildings 
        // tests overloading method: add dining hall food type 
        myMap.addBuilding(new House("Northrop House", "49 Elm Street, Northampton, MA 01063", 5, true, true, "Vegetarian"));
       
        // adds a house without elevator but dining hall (does Lamont have an elevator??) 
        House Lamont = new House("Lamont House", "17 Prospect Street, Northampton MA 01063", 4, true, false, "Allergen-Free");
        // prints out type of food served at Lamont house dining hall 
        System.out.println(Lamont.hasDiningRoom(true)); 
        myMap.addBuilding(Lamont); 

        // adds a house without elevator or dining hall 
        myMap.addBuilding(new House("Albright House", "7 Bedford Terrace, Northampton MA 01063", 4, false, false)); 

        // add Neilson library 
        Library Neilson = new Library("Neilson", "7 Neilson Drive, Northampton MA 01063", 5, true); 
        Neilson.addTitle("Don Quixote", true); // demonstrates adding title not present overload 
        Neilson.addTitle("The Outsiders", true); // demonstrates adding title not present overload 
        Neilson.addTitle("Twilight", false); // demonstrates adding title not present overload 

        ArrayList<String> titles = new ArrayList<String>();
        titles.add("Don Quixote");
        titles.add("The Outsiders"); 
        Neilson.checkOut(titles); // demonstrates overloading for checking out multiple titles 
        // adds Neilson library to map
        myMap.addBuilding(Neilson); 

        // adds another library (not sure on floors or elevator here either)
        myMap.addBuilding(new Library("Josten Library", "Mendenhall Center, 122 Green St, Northampton, MA 01063", 1, false));

        // adds one more library 
        myMap.addBuilding(new Library("Hillyer Library", "22 Elm St, Northampton, MA 01063", 2, true)); 

        // Adds some cafes 
        // makes cafe with budget 
        Cafe Compass = new Cafe("Compass Cafe", "7 Neilson Drive, Northampton MA 01063", 1, 10.); 
        Compass.sellCoffee(3, 2, 5); // sells coffee 
        myMap.addBuilding(Compass); 

        // adds Campus center cafe (no budget)
        myMap.addBuilding(new Cafe("Campus Center Cafe", "1 Chapin Way, Northampton MA 01063", 1)); 
        
        // adds some regular old buildings 
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct, Northampton, MA 01060", 4)); 
        myMap.addBuilding(new Building("Dewey Hall", "2 Seelye Dr, Northampton, MA 01063", 4)); 

        // prints map 
        System.out.println(myMap);

    }   
    
}
