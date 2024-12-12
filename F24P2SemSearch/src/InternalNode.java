/**
 * Leaf Node class with get and set methods
 *
 * @author kuzoto
 * @version September 2024
 */
public class InternalNode implements BinTreeNode 
{
    private Comparable key;
    private BinTreeNode left;
    private BinTreeNode right;
    
    // ~ Constructors ..........................................
    
    /**
     * Create a internal BinTreeNode
     * @param k
     *       The descriminator for this node
     * @param l
     *       The left child for this node
     * @param r
     *       The right child for this node
     */
    InternalNode(Comparable k, BinTreeNode l, BinTreeNode r) 
    { 
        left = l;
        right = r; 
        key = k;
    }
    
    /**
     * Get the value of the key in this Node
     * @return
     *      The value of the key in this Node
     */
    public Comparable value()
    {
        return key;
    }
    
    /**
     * Set the key of this Node to a given value
     * @param v
     *      The value to set the key to
     */
    public void setValue(int v)
    {
        key = v;
    }
    
    /**
     * We need this one to satisfy BinTreeNode interface
     * 
     * @param v
     *       The new value for the node
     */
    public void setValue(Object v) {
        if (!(v instanceof Comparable))
            throw new ClassCastException("A Comparable object is required.");
        key = (Comparable)v;
    }
    
    /**
     * Get the left child of a node
     * @return
     *      The left child of a node
     */
    public BinTreeNode left()
    {
        return left;
    }
    
    /**
     * Set the left child of a node
     * @param l
     *      The new left child of a node
     */
    public void setLeft(BinTreeNode l)
    {
        left = l;
    }
    
    /**
     * Get the right child of a node
     * @return
     *      The right child of a node
     */
    public BinTreeNode right()
    {
        return right;
    }
    
    /**
     * Set the right child of a node
     * @param r
     *      The new right child of a node
     */
    public void setRight(BinTreeNode r)
    {
        right = r;
    }
    
    /**
     * Return whether a node is a leaf or not
     * @return
     *      false since an internal node is not a leaf
     */
    public boolean isLeaf()
    {
        return false;
    }
    
    /**
     * Print the internal node
     */
    public void print()
    {
        System.out.println("(I)");
    }
    
}