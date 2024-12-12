/**
 * Single Linked List class
 *
 * @author kuzoto
 * @version September 2024
 */
public class SingleLL
{
    // This representation uses a sentinel node at the start of
    // the chain to make it easier to insert at the start in constant time.
    private SLLNode head;

    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new, empty list.
     */
    public SingleLL() {
        this.clear();
    }

    // ~ Public Methods ........................................................

    
    // ----------------------------------------------------------
    /**
     * Resets this list to be empty by removing all its values.
     */
    public void clear() {
        // throws away any existing chain of nodes and replaces it with
        // a new empty chain containing just the sentinel nodes at start
        // and end.
        //this.tail = new DLLNode(-1, this.head, null);
        this.head = new SLLNode(null, null);
    }
    
    /**
     * Return the head of the List
     * 
     * @return
     *      The head of the list
     */
    public SLLNode getHead()
    {
        return this.head;
    }
    
    /**
     * Replace the head node of the list
     * 
     * @param head
     *      The node we are replacing head with
     */
    public void setHead(SLLNode head)
    {
        this.head = head;
    }

    // Other operations, like various other remove() methods, or inserting
    // at a specified position, are left as an exercise for the reader.


    // ----------------------------------------------------------
    /**
     * The internal SLLNode class that represents nodes in the linked chain.
     */
    public static class SLLNode {
        private Seminar data;
        private SLLNode next;
        
        // ~ Constructor ............................................

        // ----------------------------------------------------------
        /**
         * Create a new DLLNode
         * 
         * @param data
         *      The vertex of the node
         * @param next
         *      Pointer to the following node 
         */
        public SLLNode(Seminar data, SLLNode next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Return the vertex of the node
         * 
         * @return
         *      The vertex of the node
         */
        public Seminar getData() {
            return this.data;
        }

        /**
         * Set the vertex of a node to value
         * 
         * @param value
         *      The new vertex value
         */
        public void setData(Seminar value) {
            this.data = value;
        }

        /**
         * Return the pointer to the next node
         * 
         * @return
         *      The pointer to the next node
         */
        public SLLNode getNext() {
            return this.next;
        }

        /**
         * Change the pointer to the next node
         * 
         * @param next
         *      The pointer we want to change next to
         */
        public void setNext(SLLNode next) {
            this.next = next;
        }
    }
}