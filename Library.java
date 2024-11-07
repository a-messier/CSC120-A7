import java.util.ArrayList;
import java.util.Hashtable; 

/* This is a stub for the Library class */
public class Library extends Building{
    private Hashtable<String, Boolean> collection; // initilizes collection hashtable
    private boolean elevator; 
    /**
     * Constructor for Library class extends Building class
     * @param name string
     * @param address string 
     * @param nFloors int 
     * @param elevator boolean
     */
    public Library(String name, String address, int nFloors, boolean elevator) {
      super(name, address, nFloors); 
      this.collection = new Hashtable<>();  // initilizes collection as empty hashtable
      this.elevator = elevator;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a book to the collection hashtable as key: value = book title/author : true,
     *  where true indicates that the boo is currently available 
     * @param title string name of book to add 
     */
    public void addTitle(String title){
      if (this.collection.containsKey(title)){ // if the title is already there...
        throw new RuntimeException("Title is already in collection"); 
      }
      else{ // if book not already there...
        this.collection.put(title, true); // adds to collection, true bc is there 
      }

    }
// overloads addTitle by adding option to add a book that is either available/unavailable rather than just available 
    public void addTitle(String title, boolean present){
      if (this.collection.containsKey(title)){ // if the title is already there...
        throw new RuntimeException("Title is already in collection"); 
      }
      else{ // if book not already there...
        this.collection.put(title, present); // adds to collection, true bc is there 
      }
    }

    /**
     * Removes a book from the collection hashtable
     * @param title name of book to remove 
     * @return name of book removed 
     */
    public String removeTitle(String title){
      if (this.collection.containsKey(title)){ // checks if title is in collection
        this.collection.remove(title); // removes title 
      }
      else{ // issue if title is not in collection, so cannot remove 
        throw new RuntimeException("Title "+title+" not in collection. Cannot be removed.");
      }

      return title; // return title of book 
    }
    /**
     * Checks out a book by making sure the book is in the collection and currently available
     * @param title name of book to check out 
     */
    public void checkOut(String title){
      if ((this.collection.containsKey(title)) && this.collection.get(title)){ // if title is in library andv value is true 
        this.collection.replace(title, false); // set contains value to false 
      }
    }

      // checks out multiple books at once overrides checkOut method 
    public void checkOut(ArrayList<String> titles){
      for (int i = 0; i < titles.size(); i++) {
          String title = titles.get(i); 
          if ((this.collection.containsKey(title)) && this.collection.get(title)){ // if title is in library andv value is true 
          this.collection.replace(title, false); // set contains value to false 
        }
      }
    }
    /**
     * returns book by setting value to true from false 
     * @param title name of book to return 
     */
  public void returnBook(String title){
    if ((this.collection.containsKey(title)) && !this.collection.get(title)){ // if title is in library andv value is false 
      this.collection.replace(title, true); // set contains value to false 
  }
}
  /**
   * Tells if a certain book is in the collection 
   * @param title name of book 
   * @return true if the library has the title (available or unavailable)
   */
  public boolean containsTitle(String title){
        return this.collection.containsKey(title);
  }
  /**
   * checks if a title is currently available for checkout 
   * @param title name of book
   * @return true if avaialble, false if not. 
   */
  public boolean isAvailable(String title){
    if (!this.collection.containsKey(title)){ // if not in collection
      System.out.println("Book "+ title + " is not in collection.");
    }
    return this.collection.get(title); // returns value corresponding to key of title 
  }
  /** 
   * prints all titles in the collection and if they are available or not 
   */
  public void printCollection(){
    System.out.println(this.collection); // prints collection?
  }
/**
 * Goes up (overrides goUp from building class if an elevator is present)
 * @param nfloors int floors to go up 
 */
  public void goUp(int nfloors) {
    if (this.elevator){ 
      this.goToFloor(this.activeFloor + nfloors);
    }
    else{
      this.goToFloor(this.activeFloor + 1);
    }
}
/**
 * Goes down (overrides goDown from building class if elevator present)
 * @param nfloors int floors to go down
 */
public void goDown(int nfloors) {
  if (this.elevator){ 
    this.goToFloor(this.activeFloor - nfloors);
  }
  else{
    this.goToFloor(this.activeFloor - 1);
  }

}

/**
 * Overwrite showOptions method of parent Building class to include additional library methods
 */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
}

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson", "1 Chapin Way", 4, true);
      Neilson.addTitle("1984 by George Orwell"); 
      System.out.println(Neilson.containsTitle("1984 by George Orwell")); 
      Neilson.printCollection();
      Neilson.showOptions();
    }
  
  }