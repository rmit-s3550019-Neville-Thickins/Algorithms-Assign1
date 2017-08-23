import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	protected Node msHead;
	protected int msLength;
	
	public LinkedListMultiset() {
		msHead = null;
		msLength = 0;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		
		Node newNode = new Node(item); // creates new node
		
		if(msHead == null) { // If list is empty then sets head to null
			newNode.setNext(null);
			newNode.setPrev(null);
		}else {// if not sets next node to current node 
			msHead.setPrev(newNode);
			newNode.setNext(msHead);
		}
		msHead = newNode; // adds the new node to the front of the linklist
		msLength++;
	} // end of add()
	
	
	public int search(T item) {
		Node search = msHead;
		int found = 0;
		for(int i = 0; i < msLength;i++) {
			if(item.equals(search.getValue())) {
				found++;
			}
			search = search.getNext();
		}
		// very basic search
		return found;
	} // end of search()
	
	public void removeOne(T item) {
		Node delete = msHead;
		//Node curr = msHead;
		
		if(msHead==null) {
			return;
		}
		
		// checks if the head is the one you want to delete and if the next value is null
		// then clears everything
		if(item.equals(delete.getValue())) {
			if(msLength == 1) {
				msHead= null;
				msLength =0;
				return;
			}else {
				msHead = delete.getNext();
				msHead.setPrev(null);
				msLength--;
				return;
			}
		}else {
			delete = delete.getNext();
			while(delete !=null) {
				if(item.equals(delete.getValue())) {
					Node p = delete.getPrev();
					Node n = delete.getNext();
					
					p.setNext(n);
					if(n != null)
						n.setPrev(p);
					msLength--;
					return;
				}
				delete = delete.getNext();
			}
		}
		// very basic search
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		
		while(search(item) != 0){
			System.out.println("hi");
			removeOne(item);
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node print = msHead;
		
		LinkedListMultiset<T> PL = new LinkedListMultiset<T>();
		
		while (print != null) {
			if(PL.search((T)print.getValue())==0) {
				PL.add(print.getValue());
				out.print(print.getValue().toString()+" | "+Integer.toString(search(print.getValue()))+"\n");
			}
			print = print.getNext();
		}
	}
	
	private class Node
    {
        /** Stored value of node. */
        protected T mValue;
        /** Reference to next node. */
        protected Node mNext, mPrev;

        public Node(T value ) {
            mValue = value;
            mPrev = null;
            mNext = null;
        }

        public T getValue() {
            return mValue;
        }


        public Node getNext() {
            return mNext;
        }

        public Node getPrev() {
        	return mPrev;
        }

        public void setValue(T value) {
            mValue = value;
        }


        public void setNext(Node next) {
            mNext = next;
        }
        public void setPrev(Node prev) {
            mPrev = prev;
        }
    }
} // end of class LinkedListMultiset
