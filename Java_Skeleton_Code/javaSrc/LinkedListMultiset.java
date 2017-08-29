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
		
		if(search(item) == 0) {
			if(msHead == null) { // If list is empty then sets head to null
				newNode.setNext(null);
				newNode.setPrev(null);
			}else {// if not sets next node to current node 
				msHead.setPrev(newNode);
				newNode.setNext(msHead);
			}
			
			newNode.plusCount();
			msHead = newNode; // adds the new node to the front of the linklist
			msLength++;
		}else {
			Node find = msHead;
			
			for(int i = 0; i < msLength;i++) {
				if(item.equals(find.getValue())) {
					find.plusCount();
					return;
				}
				find = find.getNext();
			}
		}
	} // end of add()
	
	
	public int search(T item) {
		Node search = msHead;

		for(int i = 0; i < msLength;i++) {
			if(item.equals(search.getValue())) {
				return search.getCount();
			}
			search = search.getNext();
		}
		// very basic search
		return 0;
	} // end of search()
	
	public void removeOne(T item) {
		Node delete = msHead;
		
		if(msHead==null) {
			return;
		}
		
		// checks if the head is the one you want to delete and if the next value is null
		// then clears everything
		if(item.equals(delete.getValue())) {
			if(msLength == 1) {
				if(delete.getCount() ==1) {
					msHead= null;
					msLength =0;
					return;
				}else {
					delete.minusCount();
					return;
				}
			}else {
				if(delete.getCount() ==1) {
					msHead = delete.getNext();
					msHead.setPrev(null);
					msLength--;
					return;
				}else {
					delete.minusCount();
					return;
				}
			}
		}else {
			delete = delete.getNext();
			while(delete !=null) {
				if(item.equals(delete.getValue())) {
						if(delete.getCount() ==1) {
						Node p = delete.getPrev();
						Node n = delete.getNext();
						
						p.setNext(n);
						if(n != null)
							n.setPrev(p);
						msLength--;
						return;
					}else {
						delete.minusCount();
						return;
					}
				}
				delete = delete.getNext();
			}
		}
		// very basic search
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		
		while(search(item) != 0){
			removeOne(item);
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node print = msHead;
		
		for(int i =0; i < msLength; i++) {
			out.print(print.getValue().toString()+" | "+print.getCount()+"\n");
			print = print.getNext();
		}
	}
	
	public class Node
    {
        /** Stored value of node. */
        protected T mValue;
        /** Reference to next node. */
        protected Node mNext, mPrev;
        
        protected int count;

        public Node(T value ) {
            mValue = value;
            mPrev = null;
            mNext = null;
            count = 0;
        }

        public T getValue() {
            return mValue;
        }


        public Node getNext() {
            return mNext;
        }
        
        public int getCount() {
        	return count;
        }
        
        public Node getPrev() {
        	return mPrev;
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
        
        
        public void setNext(Node next) {
            mNext = next;
        }
        
        public void setPrev(Node prev) {
            mPrev = prev;
        }
    }
} // end of class LinkedListMultiset
