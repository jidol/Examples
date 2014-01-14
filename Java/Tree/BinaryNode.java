package Tree;

import java.lang.Comparable;

/**
 * Basic generic binary based node
 */
public class BinaryNode<T extends Comparable> implements 
	Comparable<BinaryNode<T>>
{
    /**
     * Left child
     */
    protected BinaryNode<T> _left = null;

    /**
     * Right child
     */
    protected BinaryNode<T> _right = null;

    /**
     * value for this node
     **/
    protected T _value = null;

    /**
     * Basic node constructor to generate a full node
     * @param value  Value for the node
     * @param right  Right tree stored as child of this node
     * @param left   Left tree stored as child of this node
     */
    public BinaryNode(T value, BinaryNode<T> right, BinaryNode<T> left)
    {
	_value = value;
	_right = right;
	_left = left;
    }

    /**
     * Static helper function to create a value only node
     * with null children left and right.
     * @param value Value for the node
     * @return New node with null left/right and the provided value
     */
    public static <T extends Comparable> BinaryNode<T> create(T value)
    {
	return new BinaryNode(value, null, null);
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
     * Set the left tree
     * @param value Value left tree node
     */
    public void setLeft(BinaryNode value)
    {
	_left = value;
    }

    /**
     * Set the right tree
     * @param value Value right tree node
     */
    public void setRight(BinaryNode value)
    {
	_right = value;
    }

    /**
     * Get left left node
     * @return Left node
     */
    public BinaryNode left()
    {
	return _left;
    }

    /**
     * Get right left node
     * @return right node
     */
    public BinaryNode right()
    {
	return _right;
    }

    /**
     * @override
     */
    public int compareTo(BinaryNode<T> other)
    {
       return get().compareTo(other.get());
    }
}
