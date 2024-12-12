import student.TestCase;

/**
 * @author kuzoto
 * @version September 2024
 */
public class InternalNodeTest extends TestCase 
{
    
    private InternalNode root;
    private LeafNode flyweight;
    
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() 
    {
        flyweight = new LeafNode();
        root = new InternalNode(64, flyweight, flyweight);
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
        root.setValue("1");
        assertEquals(root.value(), "1");
        root.setValue(2);
        assertEquals(root.value(), 2);
        
    }
}    