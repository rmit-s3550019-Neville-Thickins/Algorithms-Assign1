import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	protected Node msHead;
	
	protected int msLength;
	
	public LinkedListMultiset() {
		msHead = null;
		msLength =0;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		
		Node newNode = new Node(item); // creates new node
		
		if(msHead == null) { // If list is empty then sets head to null
			newNode.setNext(null);
		}else {// if not sets next node to current node 
			newNode.setNext(msHead);
		}
		msHead = newNode; // adds the new node to the front of the linklist
		msLength++;
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!
		Node search = msHead;
		for(int i = 0; i < msLength;i++) {
			if(item.equals(search.getValue())) {
				System.out.println(i);
				return i;
			}
			search = search.getNext();
		}
		// very basic search
		return -1;
	} // end of search()
	
	public void removeOne(T item) {
		Node delete = msHead;
		Node curr = msHead;
		
		if(msHead==null) {
			return;
		}
		
		if(item.equals(delete.getValue())) {
			if(msHead.getNext() == null) {
				msHead= null;
				msLength--;
				return;
			}
		}else {
			delete = delete.getNext();
			for(int i = 0; i < msLength;i++) {
				if(item.equals(delete.getValue())) {
					curr.setNext(delete.getNext());
					delete = null;
					msLength--;
					return;
				}
				curr = curr.getNext();
				delete = delete.getNext();
			}
		}
		// very basic search
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		
		Node curr = msHead;
		Node next = null;
		
		for(int i = 0; i < msLength;i++) {
			next = curr.getNext();
			curr.setNext(null);
			curr = next;
			msLength--;
		}
		msHead = null;

	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node print = msHead;
		if(print != null) {
			for(int i = 0; i < msLength;i++) {
				out.println(print.getValue());
				print = print.getNext();
			}
		}
	} // end of print()
	
	private class Node
    {
        /** Stored value of node. */
        protected T mValue;
        /** Reference to next node. */
        protected Node mNext;

        public Node(T value) {
            mValue = value;
            mNext = null;
        }

        public T getValue() {
            return mValue;
        }


        public Node getNext() {
            return mNext;
        }


        public void setValue(T value) {
            mValue = value;
        }


        public void setNext(Node next) {
            mNext = next;
        }
    }
} // end of class LinkedListMultiset
