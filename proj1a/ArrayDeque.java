/** Performs some basic linked list tests. */
public class ArrayDeque<T> {


	private int size;
	public int length;
	public int front;
	public int back;
	private static final double ratio=0.25;
	public T[] L;

	public ArrayDeque() {
		size=0;
		length = 8;
		front = 0;
		back = 0;
		L = (T[]) new Object[8];
	}
	/*
	public ArrayDeque of(T... args) {
		ArrayDeque<T> A;
		if (args.length > 0) {
			A=new ArrayDeque<>();
		} else {
			return null;
		}
		for (T arg : args) {
			A.addLast(arg);
		}
		return A;
	}
	*/

	private void resize(){

		int new_len= (int) ((size+1)*(1+ratio));
		T[] item = (T[]) new Object[new_len];
		int index1=0;
		int index2=front;
		for(int i=0; i<=size;i++){
			item[index1]=L[index2];
			index2=(index2+1)%length;
			index1+=1;
		}
		back=size;
		front=0;
		length=new_len;
		L=item;
	}
	private void desize(){
		if (length > ((size+1)*4)) {
			int new_len= (int) (size*4);
			T[] item = (T[]) new Object[new_len];
			int index1=0;
			int index2=front;
			for(int i=0; i<=size;i++){
				item[index1]=L[index2];
				index2=(index2+1)%length;
				index1+=1;
			}
			length=new_len;
			front=0;
			back=size;
			L=item;
		}
	}
	//循环数组必须永远留一个空位，可以认为是back指向的那位
	public void addFirst(T item) {
		int tem=(front-1)%length;
		if(tem < 0) {
			tem+=length;
		}
		if( back == tem ) {
			resize();
			tem=(front-1)%length;
			if(tem < 0) {
				tem+=length;
			}
		}
		front = tem;
		L[front]=item;
		size+=1;
	}

	public void addLast(T item) {
		int tem = (back+1)%length;
		if (tem == front) {
			resize();
			tem=(back+1)%length;

		}
		L[back] = item;
		back=tem;

		size+=1;
	}

	public T removeFirst(){
		if(back == front) {
			return null;
		}
		T item = L[front];
		front= (front+1)%length;
		size-=1;
		//这个desize只是一个判断，不一定会真的desize，具体要看desize里面的判断
		if(length>=16){
			desize();
		}
		return item;
	}
	public T removeLast(){
		if(back == front) {
			return null;
		}
		int tem= (back-1)%length;
		if(tem<0) {
			back+=length;
		}
		T item = L[tem];
		back= tem;
		size-=1;
		//这个desize只是一个判断，不一定会真的desize，具体要看desize里面的判断
		if(length>=16){
			desize();
		}
		return item;
	}

	public void printDeque( ) {
		int tem=front;
		for(int i=0;i<size;i+=1){
			if (tem == back-1) {
				System.out.println(L[tem]);
			} else {
				System.out.print(L[tem] + " ");
			}
			tem=(tem+1)%length;

		}
	}
	public int size() {
		
		return this.size;
	}


	public boolean isEmpty() {

		return front == back;
	}

	public T get(int index) {
		if (index < 0 || index >=size) {
			return null;
		}
		if (front < back && (index <front || index > back)) {
			return null;
		}


		if (back < front && index >back && index > front) {
			return null;
		}
		return L[index];
	}

} 