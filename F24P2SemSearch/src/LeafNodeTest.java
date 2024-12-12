import student.TestCase;

/**
 * @author kuzoto
 * @version September 2024
 */
public class LeafNodeTest extends TestCase 
{
    
    private LeafNode root;
    private Seminar mysem;
    private Seminar mysem2;
    private Seminar mysem3;
    
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() 
    {
        String[] keywords = {"HCI", "Computer_Science", "VT", "Virginia_Tech"};
        String[] keywords2 = {"Bioinformatics", "computation_biology", 
            "Biology", "Computer_Science", "VT", "Virginia_Tech"};
        String[] keywords3 = {"high_performance_computing", "grids", 
            "VT", "computer", "science"};
        mysem = new Seminar(1, 
            "Overview of HCI Research at VT", 
            "0610051600", 90, (short)10, (short)10, 45, 
            keywords, 
            "This seminar will present an overview of HCI research at VT");
        mysem2 = new Seminar(2, 
            "Computational Biology and Bioinformatics in CS at Virginia Tech", 
            "0610071600", 60, (short)10, (short)10, 30, 
            keywords2, 
            "Introduction to   bioinformatics and computation biology");
        mysem3 = new Seminar(10, 
            "Computing Systems Research at VT", 
            "0701250830", 30, (short)10, (short)10, 17, 
            keywords3, 
            "Seminar about the      Computing systems research at      VT");
        root = new LeafNode(mysem);
    }
    
    /**
     * Check out the remove method of LeafNode
     */
    public void testRemove()
    {
        assertEquals(root.value().getHead().getNext().getData().id(), 1);
        root.insert(mysem2);
        assertEquals(2, root.count());
        systemOut().clearHistory();
        root.remove(mysem3);
        assertFuzzyEquals("Failed to remove seminar with ID 10 "
            + "from locations tree\r\n", systemOut().getHistory());
        assertEquals(2, root.count());
        root.remove(mysem2);
        assertEquals(1, root.count());
        root.insert(mysem3);
        assertEquals(2, root.count());
        systemOut().clearHistory();
        root.remove(mysem2);
        assertEquals(2, root.count());
        assertFuzzyEquals("Failed to remove seminar with ID 2 "
            + "from locations tree\r\n", systemOut().getHistory());
    }
    
    /**
     * Check out the setValue method
     */
    public void testSetValue()
    {
        try
        {
            root.setValue(new Seminar());
        }
        catch (ClassCastException e)
        {
            assertTrue(true);
        }
        SingleLL temp = new SingleLL();
        temp.getHead().setNext(new SingleLL.SLLNode(mysem2, null));
        root.setValue(temp);
        assertEquals(root.value().getHead().getNext().getData().id(), 2);
    }
    
    /**
     * Check out the left method of leafNode
     */
    public void testLeft()
    {
        assertNull(root.left());
    }
    
    /**
     * Check out the right method of leafNode
     */
    public void testRight()
    {
        assertNull(root.right());
    }
}
    