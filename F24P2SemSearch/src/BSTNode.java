/**
 * BST Node class with get and set methods.
 *
 * @author kuzoto
 * @version September 2024
 */
public class BSTNode implements BinNode 
{
    private Seminar record;
    private Comparable element; // Element for this node
    private BSTNode left;          // Pointer to left child
    private BSTNode right;         // Pointer to right child

    // ~ Constructors ..........................................

    // ----------------------------------------------------------
    /**
     * Create an empty BSTNode.
     */
    BSTNode() 
    { 
        left = null; 
        right = null; 
    }
    
    /**
     * Create a leaf BSTNode
     * @param val
     *       The key of the node
     * @param rec
     *       The Seminar object associated with the key
     */
    BSTNode(Comparable val, Seminar rec) 
    { 
        left = null;
        right = null; 
        element = val; 
        record = rec;
    }
    
    /**
     * Create a BSTNode with children
     * @param val
     *       The key of the node
     * @param rec
     *       The Seminar object associated with the key
     * @param l
     *       The left child
     * @param r
     *       The right child
     */
    BSTNode(Comparable val, Seminar rec, BSTNode l, BSTNode r)
    { 
        left = l; 
        right = r; 
        element = val; 
        record = rec; 
    }
    
    // Get and set the element record
    public Seminar record() { return record; }
    public void setRecord(Seminar r) { record = r; }
    
    // Get and set the element value
    public Comparable value() { return element; }
    public void setValue(Comparable v) { element = v; }
    /**
     * We need this one to satisfy BinNode interface
     * 
     * @param v
     *       The new value for the node
     */
    public void setValue(Object v) {
        if (!(v instanceof Comparable))
            throw new ClassCastException("A Comparable object is required.");
        element = (Comparable)v;
    }

    // Get and set the left child
    public BSTNode left() { return left; }
    public void setLeft(BSTNode p) { left = p; }

    // Get and set the right child
    public BSTNode right() { return right; }
    public void setRight(BSTNode p) { right = p; }

    // return TRUE if a leaf node, FALSE otherwise
    public boolean isLeaf() { return (left == null) && (right == null); }
}