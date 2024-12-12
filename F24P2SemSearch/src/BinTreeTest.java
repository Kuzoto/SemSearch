import student.TestCase;

/**
 * @author kuzoto
 * @version September 2024
 */
public class BinTreeTest extends TestCase {
    
    //Test BinTree containing locations
    private BinTree trial;
    //Test seminars
    private Seminar mysem;
    private Seminar mysem2;
    private Seminar mysem3;
    private Seminar mysem4;
    private Seminar mysem5;
    private Seminar mysem6;
    private Seminar mysem7;
    private Seminar mysem8;
    private Seminar mysem9;
    private Seminar mysem10;
    private Seminar mysem11;
    //Test leafNode root
    private BinTreeNode root;
    
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        trial = new BinTree(128);
        String[] keywords = {"HCI", "Computer_Science", "VT", "Virginia_Tech"};
        String[] keywords2 = {"Bioinformatics", "computation_biology", 
            "Biology", "Computer_Science", "VT", "Virginia_Tech"};
        String[] keywords3 = {"high_performance_computing", "grids", 
            "VT", "computer", "science"};
        String[] keywords4 = {"HPC", "CSE", "computer_science"};
        String[] keywords5 = {"assembly", "machine_language", 
            "Computer_Science", "VT", "Virginia_Tech"};
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
            "0701250830", 30, (short)30, (short)10, 17, 
            keywords3, 
            "Seminar about the      Computing systems research at      VT");
        mysem4 = new Seminar(3, 
            "Overview of HPC and CSE Research at VT", 
            "1203301125", 35, (short)0, (short)0, 25, 
            keywords4, 
            "Learn what kind of    research is done on HPC  and CSE at VT");
        mysem5 = new Seminar(12, 
            "Computer Organization II", 
            "2405231000", 75, (short)10, (short)30, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem6 = new Seminar(8, 
            "Computer Organization II", 
            "2405231000", 75, (short)80, (short)80, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem7 = new Seminar(13, 
            "Computer Organization II", 
            "2405231000", 75, (short)81, (short)81, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem8 = new Seminar(6, 
            "Computer Organization II", 
            "2405231000", 75, (short)120, (short)120, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem9 = new Seminar(14, 
            "Computer Organization II", 
            "2405231000", 75, (short)81, (short)120, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem10 = new Seminar(17, 
            "Computer Organization II", 
            "2405231000", 75, (short)80, (short)40, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem11 = new Seminar(21, 
            "Computer Organization II", 
            "2405231000", 75, (short)40, (short)80, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
    }
    
    /**
     * Check out the insert method of BinTree
     */
    public void testInsert()
    {
        assertEquals(trial.size(), 0);
        trial.insert(mysem, mysem.x(), mysem.y());
        assertEquals(trial.size(), 1);
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        assertEquals(trial.size(), 1);
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        assertEquals(trial.size(), 7);
        trial.insert(mysem5, mysem5.x(), mysem5.y());
        trial = new BinTree(128);
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        trial.print();
        trial.insert(mysem6, mysem6.x(), mysem6.y());
        trial.print();
        trial.insert(mysem7, mysem7.x(), mysem7.y());
        trial.print();
        trial.insert(mysem8, mysem8.x(), mysem8.y());
        trial.print();
        trial = new BinTree(128);
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem5, mysem5.x(), mysem5.y());
        trial.print();
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        trial.insert(mysem6, mysem6.x(), mysem6.y());
        trial.insert(mysem7, mysem7.x(), mysem7.y());
        trial.insert(mysem8, mysem8.x(), mysem8.y());
        trial.insert(mysem9, mysem9.x(), mysem9.y());
        trial.print();
    }
    
    /**
     * Check out the print method of BinTree
     */
    public void testPrint()
    {
        trial.print();
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.print();
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.print();
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.print();
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        trial.print();
    }
    
    /**
     * Check out the search method of BinTree
     */
    public void testSearch()
    {
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        systemOut().clearHistory();
        trial.search(10, 10, 0);
        assertFuzzyEquals("Seminars within 0 units of 10, 10:\r\n"
            + "Found a record with key value 1 at 10, 10\r\n"
            + "Found a record with key value 2 at 10, 10\r\n"
            + "8 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(-1, 0, 2000);
        assertFuzzyEquals("Seminars within 2000 units of -1, 0:\r\n"
            + "Found a record with key value 3 at 0, 0\r\n"
            + "Found a record with key value 1 at 10, 10\r\n"
            + "Found a record with key value 2 at 10, 10\r\n"
            + "Found a record with key value 10 at 30, 10\r\n"
            + "15 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(-1, 0, 1);
        assertFuzzyEquals("Seminars within 1 units of -1, 0:\r\n"
            + "Found a record with key value 3 at 0, 0\r\n"
            + "8 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(11, 11, 0);
        assertFuzzyEquals("Seminars within 0 units of 11, 11:\r\n"
            + "8 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(10, 10, 20);
        assertEquals(0, trial.square((10 - mysem.x())));
        assertEquals(0, trial.square((10 - mysem.y())));
        assertEquals(0, trial.getDistance(10, 10, mysem));
        assertEquals(100, trial.square((10 - mysem4.x())));
        assertEquals(100, trial.square((10 - mysem4.y())));
        assertEquals(200, trial.getDistance(10, 10, mysem4));
        assertEquals(400, trial.square((10 - mysem3.x())));
        assertEquals(0, trial.square((10 - mysem3.y())));
        assertEquals(400, trial.getDistance(10, 10, mysem3));
        assertFuzzyEquals("Seminars within 20 units of 10, 10:\r\n"
            + "Found a record with key value 3 at 0, 0\r\n"
            + "Found a record with key value 1 at 10, 10\r\n"
            + "Found a record with key value 2 at 10, 10\r\n"
            + "Found a record with key value 10 at 30, 10\r\n"
            + "11 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(84, 10, 19);
        /*assertFuzzyEquals("Seminars within 2000 units of -1, 0:\r\n"
            + "Found a record with key value 3 at 0, 0\r\n"
            + "Found a record with key value 1 at 10, 10\r\n"
            + "Found a record with key value 2 at 10, 10\r\n"
            + "Found a record with key value 10 at 30, 10\r\n"
            + "15 nodes visited in this search", systemOut().getHistory());*/
        systemOut().clearHistory();
        trial.search(10, 84, 19);
        trial = new BinTree(128);
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem5, mysem5.x(), mysem5.y());
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        trial.insert(mysem6, mysem6.x(), mysem6.y());
        trial.insert(mysem7, mysem7.x(), mysem7.y());
        trial.insert(mysem8, mysem8.x(), mysem8.y());
        trial.insert(mysem9, mysem9.x(), mysem9.y());
        trial.insert(mysem10, mysem10.x(), mysem10.y());
        trial.insert(mysem11, mysem11.x(), mysem11.y());
        trial.print();
        trial.search(40, 40, 50);
        systemOut().clearHistory();
        trial.search(0, 0, 0);
        assertEquals(0, trial.square((0 - mysem4.x())));
        assertEquals(0, trial.square((0 - mysem4.y())));
        assertEquals(0, trial.getDistance(0, 0, mysem4));
        assertFuzzyEquals("Seminars within 0 units of 0, 0:\r\n"
            + "Found a record with key value 3 at 0, 0\r\n"
            + "8 nodes visited in this search", systemOut().getHistory());
    }
    
    /**
     * Check out the delete method of BinTree
     */
    public void testDelete()
    {
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        assertEquals(10, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                            (I)\r\n"
            + "                        (E)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (Leaf with 1 objects: 10)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 2 objects: 1 2)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        trial.delete(mysem);
        assertEquals(10, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                            (I)\r\n"
            + "                        (E)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (Leaf with 1 objects: 10)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 1 objects: 2)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        trial.delete(mysem3);
        assertEquals(9, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                            (I)\r\n"
            + "                        (E)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (E)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 1 objects: 2)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        trial = new BinTree(128);
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        assertEquals(10, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                            (I)\r\n"
            + "                        (E)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (Leaf with 1 objects: 10)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 2 objects: 1 2)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        trial.delete(mysem);
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                            (I)\r\n"
            + "                        (E)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (Leaf with 1 objects: 10)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 1 objects: 2)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        trial.delete(mysem2);
        assertEquals(7, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (E)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 1 objects: 10)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        trial.delete(mysem4);
        assertEquals(1, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "(Leaf with 1 objects: 10)\r\n", systemOut().getHistory());
        trial = new BinTree(128);
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "E", systemOut().getHistory());
        trial.delete(mysem);
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "E", systemOut().getHistory());
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        assertEquals(1, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "(Leaf with 2 objects: 1 2)", systemOut().getHistory());
        trial.delete(mysem);
        trial.delete(mysem2);
        assertEquals(0, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "E", systemOut().getHistory());
        trial = new BinTree(128);
        trial.insert(mysem, mysem.x(), mysem.y());
        trial.insert(mysem2, mysem2.x(), mysem2.y());
        trial.insert(mysem5, mysem5.x(), mysem5.y());
        trial.insert(mysem3, mysem3.x(), mysem3.y());
        trial.insert(mysem4, mysem4.x(), mysem4.y());
        trial.insert(mysem6, mysem6.x(), mysem6.y());
        trial.insert(mysem7, mysem7.x(), mysem7.y());
        assertEquals(25, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                                                    (I)\r\n"
            + "                                                (I)\r\n"
            + "                                            (I)\r\n"
            + "                                        (E)\r\n"
            + "                                        (I)\r\n"
            + "                                    (E)\r\n"
            + "                                    (I)\r\n"
            + "                                (I)\r\n"
            + "                            (I)\r\n"
            + "                        (E)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (E)\r\n"
            + "        (I)\r\n"
            + "    (E)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 1 objects: 13)\r\n"
            + "(Leaf with 1 objects: 8)\r\n"
            + "                            (E)\r\n"
            + "                                (E)\r\n"
            + "                                            (E)\r\n"
            + "                                                (I)\r\n"
            + "                                            (E)\r\n"
            + "                                            (I)\r\n"
            + "                                        (E)\r\n"
            + "                                        (I)\r\n"
            + "                                    (E)\r\n"
            + "                                    (I)\r\n"
            + "                                (Leaf with 1 objects: 10)\r\n"
            + "                                (I)\r\n"
            + "                            (Leaf with 1 objects: 12)\r\n"
            + "                            (I)\r\n"
            + "                        (Leaf with 2 objects: 1 2)\r\n"
            + "                        (Leaf with 1 objects: 3)", 
            systemOut().getHistory());
        trial.delete(mysem7);
        assertEquals(12, trial.size());
        systemOut().clearHistory();
        trial.print();
        assertFuzzyEquals("Location Tree:\r\n"
            + "                            (I)\r\n"
            + "                        (Leaf with 1 objects: 8)\r\n"
            + "                        (I)\r\n"
            + "                    (E)\r\n"
            + "                    (I)\r\n"
            + "                (E)\r\n"
            + "                (I)\r\n"
            + "            (E)\r\n"
            + "            (I)\r\n"
            + "        (Leaf with 1 objects: 10)\r\n"
            + "        (I)\r\n"
            + "    (Leaf with 1 objects: 12)\r\n"
            + "    (I)\r\n"
            + "(Leaf with 2 objects: 1 2)\r\n"
            + "(Leaf with 1 objects: 3)", systemOut().getHistory());
        
    }
}