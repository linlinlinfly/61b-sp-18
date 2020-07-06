/** Performs some basic linked list tests. */
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {



	/* Prints a nice message based on whether a test passed.
	 * The \n means newline. */
/*
	@Test
	public void PrintTest() {

		ArrayDeque<String> A=new ArrayDeque<>();
		A=A.of("aa","bb","cc");

		A.removeLast();
		A.addLast("c");
		String item1=A.removeFirst();
		A.addFirst("a");
		A.printDeque();
		System.out.println("len:"+A.length+" size:"+A.size());
		String[] a={"H","e","l","l","o","w","o","r","l","d"};
		for(String i:a){
			A.addFirst(i);
		}
		A.printDeque();
		System.out.print(A.get(0));

		System.out.print(A.get(2));

		System.out.println(A.get(3));
		for(String i:a){
			A.addFirst(i);
		}
		A.printDeque();

		for(int i=0;i<14;i++){
			A.removeLast();
			if(i%2==0){
				A.removeFirst();
			}
		}
		A.printDeque();
		System.out.println("len:"+A.length+" size:"+A.size());
	}
*/
	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	@Test
	public void IsEmptyTest() {
		ArrayDeque<Integer> A=new ArrayDeque<>();

		System.out.println(A.isEmpty());
		A.addFirst(0);
		A.addLast(1);
		System.out.println(A.get(0));
		A.printDeque();
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	@Test
	public void RemoveLastTest() {

	}

} 