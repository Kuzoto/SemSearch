/**
 * Binary tree node ADT
 *
 * @author kuzoto
 * @version September 2024
 */
public interface BinNode {
    /**
     * Get the value for a node
     * @return
     *       The value of a node
     */
    public Object value();
    /**
     * Set the value of a node
     * @param v
     *       The new value for the node
     */
    public void setValue(Object v);

    /**
     * Get the left child of a node
     * @return
     *       The left child of a node
     */
    public BinNode left();
    /**
     * Get the right child of a node
     * @return
     *       The right child of a node
     */
    public BinNode right();

    /**
     * Check whether or not a node is a leaf
     * @return
     *       true if a node is a leaf else false
     */
    public boolean isLeaf();
}

