/**
 * Controller class
 *
 * @author kuzoto
 * @version September 2024
 */

public class Controller 
{
    //The ids Binary Search Tree
    private BST ids;
    //The dates Binary Search Tree
    private BST dates;
    //The costs Binary Search Tree 
    private BST costs;
    //The keywords Binary Search Tree
    private BST kw;
    //The locations Bintree
    private BinTree loc;
    private int worldSize;
    
    // ~ Constructor ............................................

    // ----------------------------------------------------------
    /**
     * Create a new controller.
     * 
     * @param worldSize
     *       The size of the world for the seminar location
     */
    public Controller(int worldSize)
    {
        ids = new BST();
        dates = new BST();
        costs = new BST();
        kw = new BST();
        loc = new BinTree(worldSize);
        this.worldSize = worldSize;
    }
    
    /**
     * Insert a new Seminar into each of the Binary Search Trees
     * 
     * @param id
     *            The ID of the new seminar we want to insert
     * @param title
     *            The title of the new seminar we want to insert
     * @param date
     *            The date of the new seminar we want to insert
     * @param len
     *            The len of the new seminar we want to insert
     * @param x
     *            The x position of the new seminar we want to insert
     * @param y
     *            The y position of the new seminar we want to insert
     * @param cost
     *            The cost of the new seminar we want to insert
     * @param keywords
     *            The keywords related to the new seminar we want to insert
     * @param desc
     *            The description of the new seminar we want to insert
     */
    public void insert(int id, String title, String date, int len, 
        short x, short y, int cost, String[] keywords, String desc)
    {
        //Check if ID is a duplicate
        if (ids.find(id) != null)
        {
            System.out.println("Insert FAILED - There is already "
                + "a record with ID " + id);
            return;
        }
      //Check if location is within world size
        if ((x < 0 || x >= worldSize) || 
            (y < 0 || y >= worldSize))
        {
            System.out.println("Insert FAILED - Bad x, y "
                + "coordinates: " + x + ", " + y);
            return;
        }
        Seminar temp = new Seminar(id, title, date, len, x, y, 
            cost, keywords, desc);
        ids.insert(temp.id(), temp);
        dates.insert(temp.date(), temp);
        costs.insert(temp.cost(), temp);
        kw.insert(temp.keywords(), temp);
        loc.insert(temp, x, y);
        System.out.println("Successfully inserted record with ID " + id);
        System.out.println(temp.toString());
    }
    
    /**
     * Delete the seminar with given ID from all search trees
     * 
     * @param id
     *            The ID we want to remove
     */
    public void delete(int id)
    {
        Seminar target = ids.remove(id);
        if (target == null)
        {
            System.out.println("Delete FAILED -- There "
                + "is no record with ID " + id);
            return;
        }
        dates.remove(target.date(), target);
        costs.remove(target.cost(), target);
        kw.remove(target.keywords(), target);
        loc.delete(target);
        System.out.println("Record with ID " + id 
            + " successfully deleted from the database");
    }
    
    /**
     * Search for a seminar with given id
     * @param id
     *       The id we want to search for
     */
    public void search(int id)
    {
        Seminar result = ids.find(id);
        if (result == null) 
        { 
            System.out.println("Search FAILED -- There is no record with ID " 
                + id);
            return; 
        }
        System.out.println("Found record with ID " + id + ":");
        ids.search(ids.root(), id, id);
    }
    
    /**
     * Search for seminars containing a given keyword
     * @param key
     *       The keyword we are searching for
     */
    public void search(String key)
    {
        System.out.println("Seminars matching keyword " + key + ":");
        kw.search(kw.root(), key, key);
    }
    
    /**
     * Search for seminars with cost in a given range
     * @param low
     *       The lower bound of the range
     * @param high
     *       The upper bound of the range
     */
    public void search(int low, int high)
    {
        System.out.println("Seminars with costs in range " 
            + low + " to " + high + ":");
        System.out.println(costs.search(costs.root(), low, high) 
            + " nodes visited in this search");
    }
    
    /**
     * Search for seminars with date in a given range
     * @param lowDate
     *       The lower bound of the range
     * @param highDate
     *       The upper bound of the range
     */
    public void search(String lowDate, String highDate)
    {
        System.out.println("Seminars with dates in range " 
            + lowDate + " to " + highDate + ":");
        System.out.println(dates.search(dates.root(), lowDate, highDate) 
            + " nodes visited in this search");
    }
    
    /**
     * Search for seminars within a given circle area
     * @param x
     *      The x position of the area
     * @param y
     *      The y position of the area
     * @param radius
     *      The radius of the circle
     */
    public void search(int x, int y, int radius)
    {
        loc.search(x, y, radius);
    }
    
    /**
     * Print the tree of the given type
     * 
     * @param type
     *            The tree we want to print
     */
    public void print(String type)
    {
        //Check the type we want to print
        if (type.equals("ID"))
        {
            ids.print(type);
        }
        else if (type.equals("date"))
        {
            dates.print("Date");
        }
        else if (type.equals("cost"))
        {
            costs.print("Cost");
        }
        else if (type.equals("keyword"))
        {
            kw.print("Keyword");
        }
        else if (type.equals("location"))
        {
            loc.print();
        }
    }
    
}