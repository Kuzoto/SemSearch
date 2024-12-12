/**
 * Binary Search Tree class with tree access and altering methods.
 *
 * @author kuzoto
 * @version September 2024
 */
@SuppressWarnings("unchecked")
public class BinTree 
{
    private BinTreeNode root; // Root of the Bintree
    private int nodecount; // Number of nodes in the Bintree
    private LeafNode flyweight;
    private int worldSize;

    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new BinTree of size world
     * 
     * @param world
     *      The world size of the new BinTree
     */
    BinTree(int world) 
    {
        flyweight = new LeafNode();
        root = flyweight; 
        nodecount = 0;
        worldSize = world;
    }
    
    private BinTreeNode inserthelp(BinTreeNode rt, Seminar rec, int x, int y, 
        int i, int lowerX, int upperX, int lowerY, int upperY)
    {
        if (rt == flyweight) 
        {
            nodecount++;
            return new LeafNode(rec); 
        }
        int n = i + 1;
        int mid;
        if (i % 2 == 0)
        {
            mid = ((upperX + lowerX) / 2);
        }
        else
        {
            mid = ((upperY + lowerY) / 2);
        }
        if (rt.isLeaf())
        {
            LeafNode temp = (LeafNode)rt;
            if ((x == temp.value().getHead().getNext().getData().x()) && 
                (y == temp.value().getHead().getNext().getData().y()))
            {
                temp.insert(rec);
                return temp;
            }
            InternalNode inRT;
            if (i % 2 == 0)
            {
                nodecount++;
                inRT = new InternalNode(mid, flyweight, flyweight);
                if (temp.value().getHead().getNext().getData().x() <= mid)
                {
                    inRT.setLeft(temp);
                }
                else
                {
                    inRT.setRight(temp);
                }
                if (x <= mid)
                {
                    inRT.setLeft(inserthelp(inRT.left(), rec, x, y, n, 
                        lowerX, mid, lowerY, upperY));
                }
                else
                {
                    inRT.setRight(inserthelp(inRT.right(), rec, x, y, n, 
                        mid, upperX, lowerY, upperY));
                }
            }
            else
            {
                nodecount++;
                inRT = new InternalNode(mid, flyweight, flyweight);
                if (temp.value().getHead().getNext().getData().y() <= mid)
                {
                    inRT.setLeft(temp);
                }
                else
                {
                    inRT.setRight(temp);
                }
                if (y <= mid)
                {
                    inRT.setLeft(inserthelp(inRT.left(), rec, x, y, n, 
                        lowerX, upperX, lowerY, mid));
                }
                else
                {
                    inRT.setRight(inserthelp(inRT.right(), rec, x, y, n, 
                        lowerX, upperX, mid, upperY));
                }
            }
            return inRT;
        }
        InternalNode temp = (InternalNode)rt;
        if (i % 2 == 0)
        {
            if (temp.value().compareTo(x) >= 0)
            {
                temp.setLeft(inserthelp(temp.left(), rec, x, y, n, 
                    lowerX, mid, lowerY, upperY));
            }
            else
            {
                temp.setRight(inserthelp(temp.right(), rec, x, y, n, 
                    mid, upperX, lowerY, upperY));
            }
        }
        else
        {
            if (temp.value().compareTo(y) >= 0)
            {
                temp.setLeft(inserthelp(temp.left(), rec, x, y, n, 
                    lowerX, upperX, lowerY, mid));
            }
            else
            {
                temp.setRight(inserthelp(temp.right(), rec, x, y, n, 
                    lowerX, upperX, mid, upperY));
            } 
        }
        return temp;   
    }
    
    /**
     * Insert a new seminar into the BinTree at x and y
     * 
     * @param rec
     *      New seminar to insert
     * @param x
     *      x position of seminar
     * @param y
     *      y position of seminar
     */
    public void insert(Seminar rec, int x, int y)
    {
        root = inserthelp(root, rec, x, y, 0, 0, 
            worldSize - 1, 0, worldSize - 1);
    }
    
    private void printhelp(BinTreeNode rt, int height) 
    {
        if (rt == flyweight)
        {
            System.out.print("    ".repeat(height));
            System.out.println("(E)");
            return;
        }
        if (rt.isLeaf())
        {
            System.out.print("    ".repeat(height));
            rt.print();
            return;
        }
        System.out.print("    ".repeat(height));
        rt.print();
        height--;
        printhelp(rt.right(), height);
        printhelp(rt.left(), height);
    }
    
    /**
     * Calculate the height of the tree from the root
     * 
     * @param rt
     *      The root of the BinTree
     * @return
     *      The height of the BinTree
     */
    public int btheight(BinTreeNode rt)
    {
        if (rt.isLeaf()) { return 0; }
        int leftMax = btheight(rt.left());
        int rightMax = btheight(rt.right());
        if (leftMax > rightMax)
        {
            return 1 + leftMax;
        }
        else
        {
            return 1 + rightMax;
        }
    }
    
    /**
     * Get the current number of nodes in the tree
     * 
     * @return
     *      The current number of nodes
     */
    public int size()
    {
        return nodecount;
    }
    
    /**
     * Print the binTree
     */
    public void print()
    {
        System.out.println("Location Tree:");
        if (root == flyweight)
        {
            System.out.println("E");
            return;
        }
        printhelp(root, btheight(root));
    }
    
    /**
     * Square the distance between two vertex
     * @param dist
     *      The distance between two vertex
     * @return
     *      The distance squared
     */
    public int square(int dist)
    {
        return dist * dist;
    }
    
    /**
     * Calculate the distance between a point and the center of the circle
     * @param x
     *      The x vertex of the center of the circle
     * @param y
     *      The y vertex of the center of the circle
     * @param sem
     *      The object containing the point
     * @return
     *      The distance between the point and the center of the circle
     */
    public int getDistance(int x, int y, Seminar sem)
    {
        int xDist = square((x - sem.x()));
        int yDist = square((y - sem.y()));
        return (xDist + yDist);
    }
    
    private int searchhelp(BinTreeNode rt, int i, int x, int y, int radius)
    { 
        if (rt == flyweight)
        {
            return 1;
        }
        if (rt.isLeaf())
        {
            LeafNode temp = (LeafNode)rt;
            int xLeaf = temp.value().getHead().getNext().getData().x();
            int yLeaf = temp.value().getHead().getNext().getData().y();
            int dist = getDistance(x, y, 
                temp.value().getHead().getNext().getData());
            //System.out.println("Visited " + xLeaf + ", " + yLeaf);
            SingleLL.SLLNode curr = temp.value().getHead();
            if (dist <= radius * radius)
            {
                //Recurse and print seminars found in circle
                while (curr.getNext() != null)
                {
                    curr = curr.getNext();
                    System.out.println("Found a record with key value "
                        + curr.getData().id() + " at " + xLeaf + ", " + yLeaf);
                }
            }
            return 1;
        }
        int n = i + 1;
        int count = 1;
        int xMin = x - radius; //left bound
        int xMax = x + radius; //right bound
        int yMin = y - radius; //bottom bound
        int yMax = y + radius; //top bound
        InternalNode temp = (InternalNode)rt;
        if (i % 2 == 0)
        { 
            //check if mid is below min
            if (temp.value().compareTo(xMin) >= 0)
            {
                count += searchhelp(rt.left(), n, x, y, radius); //go left
            }
            //check if mid is below max 
            if (temp.value().compareTo(xMax) < 0)
            {
                count += searchhelp(rt.right(), n, x, y, radius); //go right
            }
            return count;
        }
        else
        {
            if (temp.value().compareTo(yMin) >= 0)
            {
                count += searchhelp(rt.left(), n, x, y, radius);
            }
            if (temp.value().compareTo(yMax) < 0)
            {
                count += searchhelp(rt.right(), n, x, y, radius);
            }
            return count;
        }
    }
    
    
    private BinTreeNode deletehelp(BinTreeNode rt, Seminar rec, int i)
    {
        if (rt == flyweight)
        {
            return flyweight;
        }
        if (rt.isLeaf())
        {
            //Type cast rt to leaf
            LeafNode temp = (LeafNode)rt;
            //Seminar first = temp.value().getHead().getNext().getData();
            //Call remove on temp
            temp.remove(rec);
            //When the leaf is empty return flyweight and decrement nodecount
            if (temp.count() == 0)
            {
                nodecount--;
                return flyweight;
            }
            return temp;
        }
        int n = i + 1;
        InternalNode temp = (InternalNode)rt;
        if (i % 2 == 0) //Check if we are on a X split
        {
            //If mid is greater or equal to sem x then recurse delete on left
            if (temp.value().compareTo(rec.x()) >= 0)
            {
                temp.setLeft(deletehelp(temp.left(), rec, n));
            }
            else
            {
                temp.setRight(deletehelp(temp.right(), rec, n));
            }
        }
        else //We are on a Y split
        {
            //If mid is greater or equal to sem y then recurse delete on left
            if (temp.value().compareTo(rec.y()) >= 0)
            {
                temp.setLeft(deletehelp(temp.left(), rec, n));
            }
            else
            {
                temp.setRight(deletehelp(temp.right(), rec, n));
            } 
        }
        //If internal node only has 1 leaf child move it up
        if (temp.left() == flyweight && 
            temp.right().isLeaf())
        {
            nodecount--;
            return temp.right();
        }
        else if (temp.right() == flyweight && temp.left().isLeaf())
        {
            nodecount--;
            return temp.left();
        }
        return temp;  
    }
    
    
    
    /**
     * Search the BinTree for records within a given area
     * 
     * @param x
     *      The x position of the area
     * @param y
     *      The y position of the area
     * @param radius
     *      The radius of the circle
     */
    public void search(int x, int y, int radius)
    {
        System.out.println("Seminars within " + radius 
            + " units of " + x + ", " + y + ":");
        System.out.println(searchhelp(root, 0, x, y, radius) 
            + " nodes visited in this search");
    }
    
    /**
     * Delete a seminar from the BinTree
     * 
     * @param rec
     *      The seminar that is being delete
     */
    public void delete(Seminar rec)
    {
        root = deletehelp(root, rec, 0);
    }
    
    /*
    public int numLeafs()
    {
        return leafcount;
    }
    */
}