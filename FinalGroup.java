/*
    Name: Spenser Currier
    Assignment: Program #0
    Course/Semester: CS 371/ Fall 2019
    Class Section:
    Lab Section:
    Sources consulted: Sola Gbenro
 */


import java.util.ArrayList;

public class FinalGroup implements Comparable<FinalGroup> {
    /** Variable to keep track of the size of the group */
    private int Count;
    /** Variable for the Lowest UserID in the group */
    private int LowestUserID;
    /** ArrayList to keep track of UserIDs in each group */
    private ArrayList<Integer> AccessLevel = new ArrayList<>();

    /**
     * Constructor for setting the Count and the LowestUserID
     * @param LowUserID The assignment to the LowestUserID variable
     */
    public FinalGroup(int LowUserID){
        this.LowestUserID = LowUserID;
        AccessLevel.add(LowUserID);
        this.Count = AccessLevel.size();
    }

    /**
     * Adds the given input to the list of Users at the access level
     * @param i UserID being added to the list
     */
    public void add(int i){
        this.AccessLevel.add(i);
        this.Count++;
    }

    /**
     * Getter for the Count variable
     * @return The count variable
     */
    public int getCount(){
        return Count;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(FinalGroup other) {
        if(Count < other.Count){
            if(LowestUserID < other.LowestUserID){
                return -1;
            }
            else if(LowestUserID == other.LowestUserID){
                return 0;
            }
            else{
                return 1;
            }
        }
        else if(Count == other.Count){
            if(LowestUserID < other.LowestUserID){
                return -1;
            }
            else if (LowestUserID == other.LowestUserID){

                return 0;
            }
            else
                return 1;
        }
        else{
            if(LowestUserID < other.LowestUserID){
                return -1;
            }
            else if(LowestUserID == other.LowestUserID){
                return 0;
            }
            else{
                return 1;
            }
        }
    }

    /**
     * A toString to print the total count variable followed by the smallest User
     * ID in the group
     * @return The string containing Count and LowestUserID
     */
    public String toString(){
        return " " + Count + " " + LowestUserID;
    }
}
