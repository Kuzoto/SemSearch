import student.TestCase;

/**
 * @author kuzoto
 * @version September 2024
 */
public class BSTTest extends TestCase {
    
    //Test BST containing ids
    private BST trial;
    //Test BST containing dates
    private BST date;
    //Test BST containing costs
    private BST cost;
    //Test BST containing keywords
    private BST kw;
    //Test seminars
    private Seminar mysem;
    private Seminar mysem2;
    private Seminar mysem3;
    private Seminar mysem4;
    private Seminar mysem5;
    private Seminar mysem6;
    private Seminar mysem7;
    
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        trial = new BST();
        date = new BST();
        cost = new BST();
        kw = new BST();
        String[] keywords = {"HCI", "Computer_Science", "VT", "Virginia_Tech"};
        String[] keywords2 = {"Bioinformatics", "computation_biology", 
            "Biology", "Computer_Science", "VT", "Virginia_Tech"};
        String[] keywords3 = {"high_performance_computing", "grids", 
            "VT", "computer", "science"};
        String[] keywords4 = {"HPC", "CSE", "computer_science"};
        String[] keywords5 = {"assembly", "machine_language", 
            "Computer_science", "VT", "Virginia_Tech"};
        String[] keywords6 = {"Virginia_Tech", "computation_biology", 
            "Biology", "Computer_Science", "VT", "Bioinformatics"};
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
            "2405231000", 75, (short)15, (short)33, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem6 = new Seminar(5, 
            "Computer Organization II", 
            "2405231000", 75, (short)15, (short)33, 125, 
            keywords5, 
            "Seminar about how computers execute commands "
            + "and process information");
        mysem7 = new Seminar(4, 
            "Computer Organization II", 
            "2405231000", 75, (short)15, (short)33, 125, 
            keywords6, 
            "Seminar about how computers execute commands "
            + "and process information");
    }


    /**
     * Check out the size method;
     */
    public void testSize()
    {
        assertEquals(trial.size(), 0);
    }
    
    /**
     * Check out the insert method;
     */
    public void testInsert()
    {
        assertEquals(trial.size(), 0);
        trial.insert(mysem.id(), mysem);
        assertEquals(trial.size(), 1);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        assertEquals(trial.size(), 4);
    }
    
    /**
     * Check out the print method;
     */
    public void testPrint()
    {
        assertEquals(trial.size(), 0);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        assertEquals(trial.size(), 4);
        trial.print("ID");
        date.insert(mysem.date(), mysem);
        date.insert(mysem2.date(), mysem2);
        date.insert(mysem3.date(), mysem3);
        date.insert(mysem4.date(), mysem4);
        date.print("Date");
        cost.insert(mysem.cost(), mysem);
        cost.insert(mysem2.cost(), mysem2);
        cost.insert(mysem3.cost(), mysem3);
        cost.insert(mysem4.cost(), mysem4);
        cost.print("Cost");
        kw.insert(mysem.keywords(), mysem);
        kw.insert(mysem2.keywords(), mysem2);
        kw.insert(mysem3.keywords(), mysem3);
        kw.insert(mysem4.keywords(), mysem4);
        kw.print("Keyword");
    }
    
    /**
     * Check out the find method;
     */
    public void testFind()
    {
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        System.out.println(trial.find(3).toString());
        assertEquals(trial.find(3), mysem4);
        assertEquals(trial.find(1), mysem);
        assertNull(trial.find(4));
    }
    
    /**
     * Check out the remove method;
     */
    public void testRemove()
    {
        assertEquals(trial.size(), 0);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        kw.insert(mysem.keywords(), mysem);
        kw.insert(mysem2.keywords(), mysem2);
        kw.insert(mysem3.keywords(), mysem3);
        kw.insert(mysem4.keywords(), mysem4);
        date.insert(mysem.date(), mysem);
        date.insert(mysem2.date(), mysem2);
        date.insert(mysem3.date(), mysem3);
        date.insert(mysem4.date(), mysem4);
        cost.insert(mysem.cost(), mysem);
        cost.insert(mysem2.cost(), mysem2);
        cost.insert(mysem3.cost(), mysem3);
        cost.insert(mysem4.cost(), mysem4);
        assertEquals(trial.size(), 4);
        trial.print("ID");
        trial.remove(3);
        assertEquals(trial.size(), 3);
        trial.print("ID");
        trial.insert(mysem4.id(), mysem4);
        trial.print("ID");
        Seminar target = trial.remove(10);
        trial.print("ID");
        kw.print("Keyword");
        assertEquals(mysem3, kw.remove(target.keywords(), target));
        kw.print("Keyword");
        date.print("Date");
        date.remove(target.date(), target);
        date.print("Date");
        cost.print("Cost");
        cost.remove(target.cost(), target);
        cost.print("Cost");
        trial.remove(3);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        assertEquals(cost.size(), 3);
        cost.remove(9, mysem);
        assertEquals(cost.size(), 3);
        assertEquals(trial.remove(2), mysem2);
        trial.print("ID");
        assertEquals(trial.remove(1), mysem);
        trial.print("ID");
        trial.insert(mysem5.id(), mysem5);
        assertEquals(trial.remove(10), mysem3);
        trial.print("ID");
        trial.insert(mysem2.id(), mysem2);
        assertEquals(trial.remove(12), mysem5);
        assertEquals(trial.remove(3), mysem4); 
        assertNull(cost.remove(mysem3.cost(), mysem3));
        assertEquals(kw.size(), 13);
        String[] keys = {"Sleepy"};
        assertNull(kw.remove(keys, mysem));
        assertEquals(kw.size(), 13);
        assertNull(kw.remove(mysem5.keywords(), mysem4));
        String[] keys2 = {"Zebra"};
        kw.remove(keys2, mysem);
        String[] keys3 = {"Assembly"};
        kw.remove(keys3, mysem);
        assertEquals(kw.size(), 13);
        String[] keys4 = {"HCI"};
        kw.remove(keys4, mysem);
        assertEquals(kw.size(), 12);
        trial.clear();
        trial.insert(mysem6.id(), mysem6);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem5.id(), mysem5);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem4.id(), mysem4);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem7.id(), mysem7);
        trial.print("ID");
        trial.remove(5);
        assertEquals(4, trial.root().value());
        trial.print("ID");
        trial.clear();
        trial.insert(mysem6.id(), mysem6);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem4.id(), mysem4);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem7.id(), mysem7);
        trial.print("ID");
        trial.remove(5);
        assertEquals(2, trial.root().value());
        trial.print("ID");
        trial.clear();
        trial.insert(mysem6.id(), mysem6);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem5.id(), mysem5);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem4.id(), mysem4);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem7.id(), mysem7);
        trial.print("ID");
        trial.remove(5, mysem6);
        assertEquals(4, trial.root().value());
        trial.print("ID");
        trial.clear();
        trial.insert(mysem6.id(), mysem6);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem4.id(), mysem4);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem7.id(), mysem7);
        trial.print("ID");
        trial.remove(5, mysem6);
        assertEquals(2, trial.root().value());
        trial.print("ID");
        kw.clear();
        kw.insert(mysem.keywords(), mysem);
        //kw.insert(mysem2.keywords(), mysem2);
        kw.insert(mysem3.keywords(), mysem3);
        kw.insert(mysem4.keywords(), mysem4);
        kw.insert(mysem5.keywords(), mysem5);
        kw.print("Keyword");
        kw.remove(keys4, mysem);
        assertEquals("Computer_science", kw.root().value());
        kw.print("Keyword");
        kw.clear();
        kw.insert(mysem.keywords(), mysem);
        //kw.insert(mysem2.keywords(), mysem2);
        kw.insert(mysem3.keywords(), mysem3);
        kw.insert(mysem4.keywords(), mysem4);
        kw.insert(mysem5.keywords(), mysem5);
        kw.print("Keyword");
        kw.remove(keys4, mysem2);
        assertEquals("HCI", kw.root().value());
        kw.print("Keyword");
    }
    
    /**
     * Check out the search methods
     */
    public void testSearch()
    {
        trial.insert(mysem.id(), mysem);
        assertEquals(trial.search(trial.root(), mysem.id(), mysem.id()), 2);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        kw.insert(mysem.keywords(), mysem);
        kw.insert(mysem2.keywords(), mysem2);
        kw.insert(mysem3.keywords(), mysem3);
        kw.insert(mysem4.keywords(), mysem4);
        date.insert(mysem.date(), mysem);
        date.insert(mysem2.date(), mysem2);
        date.insert(mysem3.date(), mysem3);
        date.insert(mysem4.date(), mysem4);
        cost.insert(mysem.cost(), mysem);
        cost.insert(mysem2.cost(), mysem2);
        cost.insert(mysem3.cost(), mysem3);
        cost.insert(mysem4.cost(), mysem4);
        systemOut().clearHistory();
        trial.search(trial.root(), 10, 10);
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword VT:");
        kw.search(kw.root(), "VT", "VT");
        assertFuzzyEquals("Seminars matching keyword VT:\r\n"
            + "ID: 10, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      Computing "
            + "systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, "
            + "VT, computer, science\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics "
            + "in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics "
            + "and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, "
            + "Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an "
            + "overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech", 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 30 to 50:");
        System.out.println(cost.search(cost.root(), 30, 50) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 30 to 50:\r\n"
            + "ID: 2, Title: Computational Biology and "
            + "Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics "
            + "and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, "
            + "Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an "
            + "overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "7 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 0 to 1:");
        System.out.println(date.search(date.root(), "0", "1") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 0 to 1:\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an "
            + "overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 2, Title: Computational Biology and "
            + "Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   "
            + "bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, "
            + "Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 10, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      "
            + "Computing systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, "
            + "VT, computer, science\r\n"
            + "8 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 20 to 40:");
        System.out.println(cost.search(cost.root(), 20, 40) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 20 to 40:\r\n"
            + "ID: 3, Title: Overview of HPC and CSE Research at VT\r\n"
            + "Date: 1203301125, Length: 35, X: 0, Y: 0, Cost: 25\r\n"
            + "Description: Learn what kind of    research is done on HPC  "
            + "and CSE at VT\r\n"
            + "Keywords: HPC, CSE, computer_science\r\n"
            + "ID: 2, Title: Computational Biology and "
            + "Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   "
            + "bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, "
            + "Computer_Science, VT, Virginia_Tech\r\n"
            + "7 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 0610061600 to 1:");
        System.out.println(date.search(date.root(), "0610061600", "1") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 0610061600 to 1:\r\n"
            + "ID: 2, Title: Computational Biology and "
            + "Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   "
            + "bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, "
            + "Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 10, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      "
            + "Computing systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, "
            + "VT, computer, science\r\n"
            + "7 nodes visited in this search", systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword Computer_Science:");
        kw.search(kw.root(), "Computer_Science", "Computer_Science");
        assertFuzzyEquals("Seminars matching keyword Computer_Science:\r\n"
            + "ID: 2, Title: Computational Biology and "
            + "Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics "
            + "and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, "
            + "Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an "
            + "overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech", 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 30 to 30:");
        System.out.println(cost.search(cost.root(), 30, 30) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 30 to 30:\r\n"
            + mysem2.toString() + "\r\n" + "5 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 60 to 60:");
        System.out.println(cost.search(cost.root(), 60, 60) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 60 to 60:\r\n"
            + "2 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 29 to 29:");
        System.out.println(cost.search(cost.root(), 29, 29) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 29 to 29:\r\n"
            + "5 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 10 to 10:");
        System.out.println(cost.search(cost.root(), 10, 10) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 10 to 10:\r\n"
            + "4 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range -1 to 40:");
        System.out.println(cost.search(cost.root(), -1, 40) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range -1 to 40:\r\n"
            + mysem3.toString() + "\r\n"
            + mysem4.toString() + "\r\n"
            + mysem2.toString() + "\r\n"
            + "8 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range -1 to 60:");
        System.out.println(cost.search(cost.root(), -1, 60) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range -1 to 60:\r\n"
            + mysem3.toString() + "\r\n"
            + mysem4.toString() + "\r\n"
            + mysem2.toString() + "\r\n"
            + mysem.toString() + "\r\n"
            + "9 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range -10 to -1:");
        System.out.println(cost.search(cost.root(), -10, -1) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range -10 to -1:\r\n"
            + "4 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 50 to 30:");
        System.out.println(cost.search(cost.root(), 50, 30) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 50 to 30:\r\n"
            + "1 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 10 to 20:");
        System.out.println(cost.search(cost.root(), 10, 20) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 10 to 20:\r\n"
            + mysem3.toString() + "\r\n"
            + "6 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 20 to 29:");
        System.out.println(cost.search(cost.root(), 20, 29) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 20 to 29:\r\n"
            + mysem4.toString() + "\r\n"
            + "6 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 30 to 40:");
        System.out.println(cost.search(cost.root(), 30, 40) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 30 to 40:\r\n"
            + mysem2.toString() + "\r\n"
            + "6 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 40 to 50:");
        System.out.println(cost.search(cost.root(), 40, 50) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 40 to 50:\r\n"
            + mysem.toString() + "\r\n"
            + "4 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with costs in range 20 to 30:");
        System.out.println(cost.search(cost.root(), 20, 30) 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with costs in range 20 to 30:\r\n"
            + mysem4.toString() + "\r\n"
            + mysem2.toString() + "\r\n"
            + "6 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(trial.root(), 1, 1);
        assertFuzzyEquals(mysem.toString(), systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(trial.root(), 2, 2);
        assertFuzzyEquals(mysem2.toString(), systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(trial.root(), 10, 10);
        assertFuzzyEquals(mysem3.toString(), systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(trial.root(), 3, 3);
        assertFuzzyEquals(mysem4.toString(), systemOut().getHistory());
        systemOut().clearHistory();
        trial.search(trial.root(), 4, 4);
        assertFuzzyEquals("", 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword Computer_Science:");
        kw.search(kw.root(), "Computer_Science", "Computer_Science");
        assertFuzzyEquals("Seminars matching keyword Computer_Science:\r\n"
            + mysem2.toString() + "\r\n" + mysem.toString(), 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword science:");
        kw.search(kw.root(), "science", "science");
        assertFuzzyEquals("Seminars matching keyword science:\r\n"
            + mysem3.toString(), 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword computer_science:");
        kw.search(kw.root(), "computer_science", "computer_science");
        assertFuzzyEquals("Seminars matching keyword computer_science:\r\n"
            + mysem4.toString(), 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword Bioinformatics:");
        kw.search(kw.root(), "Bioinformatics", "Bioinformatics");
        assertFuzzyEquals("Seminars matching keyword Bioinformatics:\r\n"
            + mysem2.toString(), 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars matching keyword sleepy:");
        kw.search(kw.root(), "sleepy", "sleepy");
        assertFuzzyEquals("Seminars matching keyword sleepy:\r\n", 
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range "
            + "0701250830 to 0701250830:");
        System.out.println(date.search(date.root(), "0701250830", "0701250830") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range "
            + "0701250830 to 0701250830:\r\n"
            + mysem3.toString() + "\r\n" + "4 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 13 to 13:");
        System.out.println(date.search(date.root(), "13", "13") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 13 to 13:\r\n"
            + "5 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 07 to 07:");
        System.out.println(date.search(date.root(), "07", "07") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 07 to 07:\r\n"
            + "4 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 05 to 05:");
        System.out.println(date.search(date.root(), "05", "05") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 05 to 05:\r\n"
            + "2 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 061007 to 13:");
        System.out.println(date.search(date.root(), "061007", "13") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 061007 to 13:\r\n"
            + mysem2.toString() + "\r\n"
            + mysem3.toString() + "\r\n"
            + mysem4.toString() + "\r\n"
            + "8 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 0 to 2:");
        System.out.println(date.search(date.root(), "0", "2") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 0 to 2:\r\n"
            + mysem.toString() + "\r\n"
            + mysem2.toString() + "\r\n"
            + mysem3.toString() + "\r\n"
            + mysem4.toString() + "\r\n"
            + "9 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range -2 to -1:");
        System.out.println(date.search(date.root(), "-2", "-1") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range -2 to -1:\r\n"
            + "2 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 1 to 0:");
        System.out.println(date.search(date.root(), "1", "0") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 1 to 0:\r\n"
            + "1 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range z to z:");
        System.out.println(date.search(date.root(), "z", "z") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range z to z:\r\n"
            + "5 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 1 to 2:");
        System.out.println(date.search(date.root(), "1", "2") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 1 to 2:\r\n"
            + mysem4.toString() + "\r\n"
            + "6 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 061006 to 07:");
        System.out.println(date.search(date.root(), "061006", "07") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 061006 to 07:\r\n"
            + mysem2.toString() + "\r\n"
            + "5 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range 0 to 061006:");
        System.out.println(date.search(date.root(), "0", "061006") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range 0 to 061006:\r\n"
            + mysem.toString() + "\r\n"
            + "4 nodes visited in this search",
            systemOut().getHistory());
        systemOut().clearHistory();
        System.out.println("Seminars with dates in range   to -:");
        System.out.println(date.search(date.root(), " ", "-") 
            + " nodes visited in this search");
        assertFuzzyEquals("Seminars with dates in range   to -:\r\n"
            + "2 nodes visited in this search",
            systemOut().getHistory());
    }
    
    /**
     * Check out the clear function
     */
    public void testClear()
    {
        assertEquals(trial.size(), 0);
        trial.insert(mysem.id(), mysem);
        trial.insert(mysem2.id(), mysem2);
        trial.insert(mysem3.id(), mysem3);
        trial.insert(mysem4.id(), mysem4);
        assertEquals(trial.size(), 4);
        trial.print("ID");
        trial.clear();
        assertEquals(trial.size(), 0);
        trial.print("ID");
    }
}