/**
 * Leaf Node class with get and set methods
 *
 * @author kuzoto
 * @version September 2024
 */
public class LeafNode implements BinTreeNode 
{
    private SingleLL seminars;
    private int numSeminars;
    private LeafNode left;
    private LeafNode right;
    
    // ~ Constructors ..........................................

    // ----------------------------------------------------------
    /**
     * Create an empty BinTreeNode.
     */
    LeafNode() 
    { 
        left = null; 
        right = null; 
    }
    
    /**
     * Create a leaf BSTNode
     * @param rec
     *       The Seminar object associated with the key
     */
    LeafNode(Seminar rec) 
    { 
        left = null;
        right = null; 
        seminars = new SingleLL();
        seminars.getHead().setNext(new SingleLL.SLLNode(rec, null));
        numSeminars = 1;
    }
    
    /**
     * Return the link in the list that proceeds the
     * one with w (or where it would be)
     * 
     * @param w
     *      The id we of the seminar we want to insert
     * @return
     *      The node the proceeds w
     */
    public SingleLL.SLLNode find(int w) 
    {
        SingleLL.SLLNode curr = seminars.getHead();
        //Find the node proceeding w
        while ((curr.getNext() != null) && 
            (curr.getNext().getData().id() < w)) 
        {
            curr = curr.getNext();
        }
        return curr;
    }
    
    /**
     * Insert a seminar into the seminars list
     * 
     * @param rec
     *      The seminar we want to insert
     */
    public void insert(Seminar rec)
    {
        SingleLL.SLLNode curr = find(rec.id());
        curr.setNext(new SingleLL.SLLNode(rec, curr.getNext()));
        numSeminars++;
    }
    
    /**
     * Remove a seminar from the seminars list
     * 
     * @param rec
     *      The seminar we want to remove
     */
    public void remove(Seminar rec)
    {
        SingleLL.SLLNode curr = find(rec.id());
        if ((curr.getNext() == null) || 
            (curr.getNext().getData().id() != rec.id()))
        {
            System.out.println("Failed to remove seminar with ID " + 
                rec.id() + " from locations tree");
            return;
        }
        curr.setNext(curr.getNext().getNext());
        numSeminars--;
    }
    
    /**
     * Get the value of the key for a node
     * @return
     *      The value of the key for a node
     */
    public SingleLL value()
    {
        return seminars;
    }
    
    /**
     * We need this one to satisfy BinNode interface
     * 
     * @param v
     *       The new value for the node
     */
    public void setValue(Object v) {
        if (!(v instanceof SingleLL))
            throw new ClassCastException("A SingleLL object is required.");
        seminars = (SingleLL)v;
    }
    
    /**
     * Get the left child of a node
     * @return
     *      The left child of a node
     */
    public LeafNode left()
    {
        return left;
    }
    
    /**
     * Get the right child of a node
     * @return
     *      The right child of a node
     */
    public LeafNode right()
    {
        return right;
    }
    
    /**
     * Return whether a node is a leaf or not
     * @return
     *      true since a leaf node is a leaf
     */
    public boolean isLeaf()
    {
        return true;
    }
    
    /**
     * Print the contents of the node
     */
    public void print()
    {
        System.out.print("(Leaf with " + numSeminars + " objects:");
        SingleLL.SLLNode curr = seminars.getHead();
        while (curr.getNext() != null)
        {
            curr = curr.getNext();
            System.out.print(" " + curr.getData().id());
        }
        System.out.println(")");
    }
    
    /**
     * Get the number of seminars in this node
     * 
     * @return
     *      The number of seminars in this node
     */
    public int count()
    {
        return numSeminars;
    }
    
}
