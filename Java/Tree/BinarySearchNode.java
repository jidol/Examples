package Tree;

import java.lang.Comparable;

/**
 * Basic generic binary based node
 */
public class BinarySearchNode<T extends Comparable> 
   extends BinaryNode<T>
{
    /**
     * Basic node constructor to generate a full node
     * @param value  Value for the node
     * @param right  Right tree stored as child of this node
     * @param left   Left tree stored as child of this node
     */
    public BinarySearchNode(T value, BinaryNode<T> right, BinaryNode<T> left)
    {
	super(value, null, null);

        insertNode(right);
        insertNode(left);
    }

    /**
     * Static helper function to create a value only node
     * with null children left and right.
     * @param value Value for the node
     * @return New node with null left/right and the provided value
     */
    public static <T extends Comparable> BinarySearchNode<T> create(T value)
    {
	return new BinarySearchNode(value, null, null);
    }

    /** 
     * Check if a value is contained in this tree
     * @value Value to find in the tree
     * @return True if found otherwise false
     */
    public boolean contains(T value)
    {
	int val = _value.compareTo(value);
	BinarySearchNode<T> part = null;
	if(0 == val)
		return true;
	else if (0 > val)
		part = (BinarySearchNode<T>)_left;
	else
		part = (BinarySearchNode<T>)_right;

	return null != part ?
			part.contains(value) :
			false;
    }

    /**
     * Get the value of this node
     * @return Value of the node
     */
    public T get()
    {
	return _value;
    }

    /**
     * Set the value of this node
     * @param value Value to set into this node
     */
    public void setValue(T value)
    {
	_value = value;
    }

    /**
     * @override
     * Set the left tree
     * @param value Value left tree node
     */
    public void setLeft(BinaryNode<T> value)
    {
	insertNode(value);
    }

    /**
     * @override
     * Set the right tree
     * @param value Value right tree node
     */
    public void setRight(BinaryNode<T> value)
    {
	insertNode(value);
    }

    /**
     * Insert a node into the tree in a balanced way
     * @param node Node to add
     */
    public void insertNode(BinaryNode<T> node)
    {
       if(node instanceof BinarySearchNode)
       {
          // Matches ignored
	  int comp = compareTo(node);
          if(0 < comp)
          {
             if(null == _left) 
		_left = node; 
	     else 
		((BinarySearchNode)_left).insertNode(node);
          }
          else if(0 > comp)
          {
             if(null == _right) 
		_right = node; 
	     else 
		((BinarySearchNode)_right).insertNode(node);
          }
       }
       else
       {
		insertNode(convert(node));
       }
    }

    /**
     * Convert a Binary node to a new BinarySearchNode
     * @param node Node to convert
     * @return BinarySearchNode converted from BinaryNode
     */
    protected BinarySearchNode convert(BinaryNode<T> node)
    {
       return new BinarySearchNode(node.get(), node.left(), 
	node.right());
    }
}
