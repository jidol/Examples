package Tree;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.Random;

public class BinaryNodeUtil<T extends Comparable>
{
   /**
    * Determine if the subNode provided exists in source
    * @param source Data to search within for subNode
    * @param subNode Data to find within source
    * @return true if found otherwise false
    */
   public boolean isSubNode(BinaryNode<T> source, BinaryNode<T> subNode)
   {
      boolean status = false;

      if(null == source && null == subNode)
	status = true;
      else if(null == subNode && null != source)
	status = true;
      else if(null == source && null != subNode)
	status = false;
      else
      {
         if(0 == source.compareTo(subNode))
		status = fullMatch(source, subNode);
	 else
		status = isSubNode(source.left(), subNode) ||
		   isSubNode(source.right(), subNode);
      }

      return status;
   }

   /**
    * True if the two trees are equal in value/subtrees
    * @param first First Tree to compare
    * @param second Second Tree to compare
    * @return true if both trees are equal otherwise false
    */
   public boolean fullMatch(BinaryNode<T> first, BinaryNode<T> second)
   {
	boolean status = false;
        if(null == first && null == second)
		status = true;
	else if(null == first || null == second)
		status = false;
        else if(0 == first.compareTo(second))
		status = fullMatch(first.left(), second.left()) &&
			 fullMatch(first.right(), second.right());
	
        return status;
   }

   /**
    * Test logic using BigInteger
    */
   public void unitTest()
   {
	final int count = 100;
	BinaryNode source = BinaryNode.create(BigInteger.ONE);
	BinaryNode badNode = BinaryNode.create(new BigInteger("" + (count + 1)));
        boolean right = false;
	Random r = new Random();
        for(int i=0; i < count; ++i)
	{
		int rand = r.nextInt() % count;
		unitTestPopulate(source, rand, right, null);
		right = r.nextBoolean();
        }

        //Check true case
        boolean status = true;
        if(true == status)
 		status = isSubNode(null, null);
	System.out.println("First Status = " + status);
        if(true == status)
 		status = isSubNode(source, null);
	System.out.println("Second Status = " + status);
        if(true == status)
 		status = isSubNode(source, source.left());
	System.out.println("Third Status = " + status);
        if(true == status)
 		status = isSubNode(source, source.right());
	System.out.println("Fourth Status = " + status);
        if(true == status)
 		status = isSubNode(source, source);
	System.out.println("Fifth Status = " + status);
	if(true == status)
		status = !isSubNode(source, badNode);
	System.out.println("Sixth Status = " + status);

   }

   /**
    * Fill a node completely then move left and right based on boolean
    * populating node with value
    * @param test Node to populate
    * @param value Value to add into the node
    * @param right True if populate right node, otherwise populate left
    * @param data Data to add
    */
   private void unitTestPopulate(BinaryNode<T> test, int value, boolean right, BinaryNode data)
   {
	if(null == data)
		data = BinaryNode.create(new BigInteger(""+value));
	if(null == test.left())
	   test.setLeft(data);
	else if(null == test.right())
	   test.setRight(data);
	else
	{
	   if(true == right)
	   	unitTestPopulate(test.right(), value, !right, data);
	   else
		unitTestPopulate(test.left(), value, !right, data);
	}
   }

   /**
    * Driver to run test algorithm
    */
   public static void main(String[] args)
   {
	BinaryNodeUtil<BigInteger> search = 
		new BinaryNodeUtil<BigInteger>();
	search.unitTest();
	search = null;
   }
   
}
