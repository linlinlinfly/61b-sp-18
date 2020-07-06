/** Performs some basic linked list tests. */
public class LinkedListDeque<T>{
	
	public class IntNode{
		public IntNode pre;
		public IntNode next;
		public T item;
		public IntNode(T x) {
			item=x;
			pre=null;
			next=null;
		}
		//初始化哨兵结点
		public IntNode() {
			
			pre=null;
			next=null;
	    }
	}

	private int size;
	
	public IntNode head;

	public IntNode tail;
	public LinkedListDeque() {
		
		head=new IntNode();
		tail=new IntNode();
		head.pre=null;
		head.next=tail;
		tail.pre=head;
		tail.next=null;
		size=0;
			
	}

	private void insert(IntNode cur,IntNode pre,IntNode next) {
		cur.pre=pre;
		cur.next=next;
		pre.next=cur;
		next.pre=cur;
	}
	private T delete(IntNode cur,IntNode pre,IntNode next) {
		pre.next=next;
		next.pre=pre;
		cur.next=null;
		cur.pre=null;
		return cur.item;
	}
	public void addFirst(T item) {
		
		IntNode tem=new IntNode(item);
		size += 1;
		insert(tem,head,head.next);
		return;
	}

	public void addLast(T item) {
		
		IntNode tem=new IntNode(item);
		size += 1;
		insert(tem,tail.pre,tail);
		return;
	}
	public void printDeque( ) {
		IntNode tem = head.next;
		while (tem != tail) {
			if(tem.next == tail){
				System.out.println(tem.item);
			} else {
				System.out.print(tem.item+" ");

			}
			tem=tem.next;
			
		}
	}
	public T removeFirst(){
		if (head.next == tail) {
			return null;
		}
		T item=delete(head.next,head,head.next.next);
		size -= 1;
		return item;
	}
	public T removeLast(){
		
		if (tail.pre == head) {
			return null;
		}
		T item=delete(tail.pre,tail.pre.pre,tail);
		size -= 1;
		return item;
	}
	public int size() {
		
		return this.size;
	}

	public boolean isEmpty() {
		
		if (head.next == tail) {
			return true;
		}
		return false;
	}

	public T get(int index) {
		

		IntNode p= head.next;

		for(int i=0; i<size; i++) {
			if( p == tail) {
				return null;
			}
			if (i == index) {
				return p.item;  
			}
			p=p.next;
		}
		return null;
	}

	private T getRecursiveHelper(int start,int index,IntNode p) {
		if (p == tail) {
			return null;
		}
		if(start == index) {
			return p.item;
		}

		return getRecursiveHelper(start+1,index,p.next);
	}
	
	public T getRecursive(int index) {
		if (index<0 || index>size) {
			return null;
		}
		return getRecursiveHelper(0,index,head.next);
	}

} 