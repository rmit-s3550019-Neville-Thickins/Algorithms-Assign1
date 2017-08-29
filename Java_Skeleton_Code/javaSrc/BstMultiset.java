import java.io.PrintStream;
import java.util.*;


public class BstMultiset<T> extends Multiset<T>
{
	Node startpoint;
	int length;
	
	public BstMultiset() {
		startpoint = null;
		length = 0;
	} // end of BstMultiset()

	public void add(T item) {
		Node newNode = new Node(item);
		
		Node current = startpoint;
		Node parent = null;
		
		if(startpoint == null) {
			startpoint = newNode;
		}else {
			while(true){ // only returns break the loop, it always has to add something
				parent = current;
				 if(item.toString().compareTo(current.getValue().toString()) == 0) { 
					 // if the node is equal to the item, it adds one to the count
					current.plusCount();
					return;
				}else if(item.toString().compareTo(current.getValue().toString()) < 0){	// if item less then current value, go left		
					current = current.getLeft();
					if(current==null){ // checks if left is null, if it is, insert node here. if not, redo this loop
						parent.setLeft(newNode);
						return;
					}
				}else{ 	// if item more then current value, go right	
					current = current.getRight();
					if(current==null){ // checks if right is null, if it is, insert node here. if not, redo this loop
						parent.setRight(newNode);
						return;
					}
				}
			}
		}
	} // end of add()


	public int search(T item) {
		Node find = startpoint; 
		if(find.getValue() == null) // checks null
			return 0;
		while(find != null) {
			
			if(find.getValue().toString().compareTo(item.toString()) == 0) { // if it found the node, print the count
				return find.getCount();
			}else if(item.toString().compareTo(find.getValue().toString()) < 0) { // if the item is less the current node, go to the left node
				find = find.getLeft();
			}else {
				find = find.getRight(); // if the item is greater then go to the right node
			}
		}
		return 0; // found nothing
	} // end of search()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		printFunc(startpoint, out); // calls it first
	} // end of print()
	
	public void printFunc(Node print, PrintStream out){ // calls its self to print everything
		if(print!=null){
			printFunc(print.getLeft(), out); //prints left side first
			out.print(print.getValue().toString()+" | "+print.getCount()+"\n"); // prints the current node
			printFunc(print.getRight(), out); // prints the right side after
		}
	}
	
	protected class Node
    {
        /** Stored value of node. */
        protected T mValue;
        /** Reference to next node. */
        protected Node left, right;
        
        protected int count;

        public Node(T value ) {
            mValue = value;
            left = null;
            right = null;
            count = 1;
        }

        public T getValue() {
            return mValue;
        }

        public Node getLeft() {
            return left;
        }
        
        public Node getRight() {
        	return right;
        }

        public int getCount() {
        	return count;
        }
        
        public void setValue(T value) {
            mValue = value;
        }

        public void plusCount() {
        	count += 1;
        }
        
        public void minusCount() {
        	count -= 1;
        }
        
        public void setRight(Node nRight) {
            right = nRight;
        }
        
        public void setLeft(Node nLeft) {
            left = nLeft;
        }
    }
} // end of class BstMultiset
