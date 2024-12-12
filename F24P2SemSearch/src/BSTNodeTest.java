import student.TestCase;

/**
 * @author kuzoto
 * @version September 2024
 */
public class BSTNodeTest extends TestCase {
    
    private BSTNode test;
    private BSTNode test2;
    private BSTNode test3;
    
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        test = new BSTNode(3, new Seminar());
        test2 = new BSTNode();
        test3 = new BSTNode(2, new Seminar(), test2, test);
    }
    
    /**
     * Check out the setValue method
     */
    public void testSetValue()
    {
        try
        {
            test2.setValue(new Seminar());
        }
        catch (ClassCastException e)
        {
            assertTrue(true);
        }
        test2.setValue(1);
        assertEquals(test2.value(), 1);
    }
    
    /**
     * Check out the isLeaf method
     */
    public void testIsLeaf()
    {
        assertTrue(test.isLeaf());
        assertFalse(test3.isLeaf());
        test3.setLeft(null);
        assertFalse(test3.isLeaf());
    }
    
}
