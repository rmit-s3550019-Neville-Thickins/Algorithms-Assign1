import java.io.PrintStream;
import java.util.*;


public class SortedLinkedListMultiset<T> extends LinkedListMultiset<T>
{
	public SortedLinkedListMultiset() {
		super();
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		super.add(item);
		if(msLength > 1) {
			sort();
		}
	} // end of add()
	
	public void removeOne(T item) {
		super.removeOne(item);
		if(msLength > 1) {
			sort();
		}
	}
	public void sort() {
		boolean swap = false;
		int compare =0;
		int count = msLength;
		
		do {
			Node sort = msHead;
			swap = false;
			for(int i=0; i <= count; i++) {
				if(sort.getNext() !=null) {
					compare = sort.getValue().toString().compareTo(sort.getNext().getValue().toString());
					if(compare > 0) {
						swapem(sort, sort.getNext());
						swap = true;
					}
					if(sort.getNext() != null) {
						sort = sort.getNext();
					}else {
						break;
					}
				}
			}
		}while(swap);
	}
	
	public void swapem(Node first, Node second) {
		Node p = first.getPrev();
		Node n = second.getNext();
		if(p != null)
			p.setNext(second);
		if(first.equals(msHead))
			msHead = second;
		second.setNext(first);
		second.setPrev(first.getPrev());
		first.setNext(n);
		first.setPrev(second);
		
	}
} // end of class SortedLinkedListMultiset 
