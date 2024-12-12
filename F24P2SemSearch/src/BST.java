/**
 * Binary Search Tree class with tree access and altering methods.
 *
 * @author kuzoto
 * @version September 2024
 */
@SuppressWarnings("unchecked")
public class BST 
{
    private BSTNode root; // Root of the BST
    private int nodecount; // Number of nodes in the BST
    
    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new BST.
     */
    BST() 
    { 
        root = null; 
        nodecount = 0; 
    }
    
    private Seminar findhelp(BSTNode rt, Comparable key)
    {
        if (rt == null) return null;
        if (rt.value().compareTo(key) > 0)
        {
            return findhelp(rt.left(), key);
        }
        else if (rt.value().compareTo(key) == 0)
        {
            return rt.record();
        }
        else return findhelp(rt.right(), key);
    }
    
    private Seminar findhelp(BSTNode rt, Comparable key, Seminar target)
    {
        if (rt == null) return null;
        if (rt.value().compareTo(key) > 0)
        {
            return findhelp(rt.left(), key, target);
        }
        else if (rt.value().compareTo(key) == 0)
        {
            if (rt.record().id() != target.id())
            {
                return findhelp(rt.left(), key, target);
            }
            else
            {
                return rt.record();
            }
        }
        else return findhelp(rt.right(), key, target);
    }
    
    private BSTNode inserthelp(BSTNode rt, Comparable e, Seminar r)
    {
        if (rt == null) return new BSTNode(e, r);
        if (rt.value().compareTo(e) >= 0)
        {
            rt.setLeft(inserthelp(rt.left(), e, r));
        }
        else
        {
            rt.setRight(inserthelp(rt.right(), e, r));
        }
        return rt;
    }
    
    private BSTNode removehelp(BSTNode rt, Comparable key, Seminar target)
    {
        if (rt == null) return null;
        if (rt.value().compareTo(key) > 0)
        {
            rt.setLeft(removehelp(rt.left(), key, target));
        }
        else if (rt.value().compareTo(key) < 0)
        {
            rt.setRight(removehelp(rt.right(), key, target));
        }
        else if (rt.record().id() != target.id())
        {
            rt.setLeft(removehelp(rt.left(), key, target));
        }
        else
        {
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else
            {
                BSTNode temp = getmax(rt.left());
                rt.setValue(temp.value());
                rt.setRecord(temp.record());
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }
    
    private BSTNode removehelp(BSTNode rt, Comparable key)
    {
        if (rt == null) return null;
        if (rt.value().compareTo(key) > 0)
        {
            rt.setLeft(removehelp(rt.left(), key));
        }
        else if (rt.value().compareTo(key) < 0)
        {
            rt.setRight(removehelp(rt.right(), key));
        }
        else
        {
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else
            {
                BSTNode temp = getmax(rt.left());
                rt.setValue(temp.value());
                rt.setRecord(temp.record());
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }
    
    private BSTNode getmax(BSTNode rt) 
    {
        if (rt.right() == null) return rt;
        return getmax(rt.right());
    }
    
    private BSTNode deletemax(BSTNode rt)
    {
        if (rt.right() == null) return rt.left();
        rt.setRight(deletemax(rt.right()));
        return rt;
    }
    
    /**
     * Reinitialize the tree
     */
    public void clear() 
    { 
        root = null; 
        nodecount = 0; 
    }
    
    /**
     * Insert the keywords for a seminar into the BST
     * @param keywords
     *       The list of keywords for the seminar
     * @param r
     *       The seminar object associated with these keywords
     */
    public void insert(String[] keywords, Seminar r) 
    {
        for (String keyword:keywords)
        {
            root = inserthelp(root, keyword, r);
            nodecount++;
        }
    }
    
    /**
     * Insert a new Seminar and its value into a BST
     * @param e
     *       The value associated with the Seminar
     * @param r
     *       The Seminar object being added to the tree
     */
    public void insert(Comparable e, Seminar r) 
    {
        root = inserthelp(root, e, r);
        nodecount++;
    }
    
    /**
     * Remove a Seminar object and its keywords from a BST
     * @param keys
     *       The keywords associated with this Seminar
     * @param target
     *       The Seminar we want to remove from the tree
     * @return
     *       The Seminar object that was removed
     */
    public Seminar remove(String[] keys, Seminar target) 
    {
        Seminar temp = null;
        for (String key:keys)
        {
            temp = null;
            temp = findhelp(root, key, target); // First find it
            root = removehelp(root, key, target); // Now remove it
            if (temp != null) 
            {
                nodecount--;
            }
        }
        return temp;
    }
    
    /**
     * Remove a Seminar object and its associated value from a BST
     * @param key
     *       The value associated with this Seminar
     * @param target
     *       The Seminar we want to remove from the tree
     * @return
     *       The Seminar object that was removed
     */
    public Seminar remove(Comparable key, Seminar target) 
    {
        Seminar temp = findhelp(root, key, target); // First find it
        root = removehelp(root, key, target); // Now remove it
        if (temp != null) 
        {
            nodecount--;
        }
        return temp;
    }
    
    /**
     * Remove a Seminar object and its associated value from a BST
     * @param key
     *       The value we want to remove
     * @return
     *       The Seminar object that was removed
     */
    public Seminar remove(Comparable key) 
    {
        Seminar temp = findhelp(root, key); // First find it
        root = removehelp(root, key); // Now remove it
        if (temp != null) 
        {
            nodecount--;
        }
        return temp;
    }
    
    private void printhelp(BSTNode rt, int height) 
    {
        if (rt == null)
        {
            System.out.print("    ".repeat(height));
            System.out.println("(" + null + ")");
            return;
        }
        printhelp(rt.left(), height - 1);
        System.out.print("    ".repeat(height));
        System.out.println("\\");
        System.out.print("    ".repeat(height));
        System.out.println("(" + rt.value() + ")");
        System.out.print("    ".repeat(height));
        System.out.println("/");
        printhelp(rt.right(), height - 1);
    }
    
    /**
     * Calculate the height of the tree from the root
     * @param rt
     *       The root of the BST
     * @return
     *       The height of the BST
     */
    public int btheight(BSTNode rt)
    {
        if (rt == null) { return 0; }
        int leftMax = btheight(rt.left());
        int rightMax = btheight(rt.right());
        if (leftMax > rightMax)
        {
            return 1 + leftMax;
        }
        else
        {
            return 1 + rightMax;
        }
    }
    
    /**
     * Print the BST
     * 
     * @param name
     *       The name of the tree
     */
    public void print(String name)
    {
        System.out.println(name + " Tree:");
        if (nodecount == 0)
        {
            System.out.println("This tree is empty");
            return;
        }
        printhelp(root, btheight(root));
        System.out.println("Number of records: " + nodecount);
    }
    
    
    /**
     * Search for Seminars containing values within a given range
     * @param rt
     *       The current node being checked
     * @param low
     *       The lower bound of the range
     * @param high
     *       The upper bound of the range
     * @return
     *      The number of nodes visited during the search
     */
    public int search(BSTNode rt, Comparable low, Comparable high)
    {
        if (rt == null) { return 1; }
        int count = 1;
        if (rt.value().compareTo(low) >= 0)
        {
            count += search(rt.left(), low, high);
            if (rt.value().compareTo(high) <= 0)
            {
                System.out.println(rt.record().toString());
            }
        }
        if (rt.value().compareTo(high) < 0)
        {
            count += search(rt.right(), low, high);
        }
        return count;
    }
    
    /*
    public void search(short x, short y, int radius)
    {
        
    }
    */
    
    /**
     * Find the Seminar associated with a given key
     * @param key
     *       The value we are searching for
     * @return
     *       The Seminar associated with the key, if found
     */
    public Seminar find(Comparable key) { return findhelp(root, key); }
    
    /**
     * Return the number of nodes in the BST
     * @return
     *       The number of nodes in the BST
     */
    public int size() { return nodecount; }
    
    /**
     * Return the root of the BST
     * @return
     *       The root of the BST
     */
    public BSTNode root() { return root; }
}