/**
 * 
 * @author Alex Rooney CIS 152 Final Project
 *
 */
public class Stack{
	public Account[] stackArray;
	private int stackSize = 50;
	private int top;

	/**
	 * 
	 * Stack Constructor
	 */
	public Stack() {
		this.stackArray = new Account[stackSize];
		this.top = -1;
	}

	/**
	 * 
	 * @param item
	 *            item is added to the stack and increases the value of top by
	 *            +1
	 * @throws FullStackException
	 *             throws exception when stack is full
	 */
	public void push(Account acct) throws FullStackException {
		if (!(isFull())) {
			stackArray[++top] = acct;
		} else {
			throw new FullStackException();
		}
	}

	/**
	 * 
	 * @return returns the last item added to the stack, and decreases the value
	 *         of top by -1
	 * @throws Exception
	 *             throws exception when the stack is empty
	 */
	public Account pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		} else {
			return stackArray[top--];
		}
	}

	/**
	 * 
	 * @return returns the last item added to the stack
	 */
	public Account top() {
		return stackArray[top];

	}

	/**
	 * 
	 * @return true if stack is empty
	 */
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true if stack is full
	 */
	public boolean isFull() {
		if ((this.top == (this.stackSize - 1))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return the length of the created stack
	 */
	public int size() {
		return this.stackSize;
	}

	/**
	 * Method prints all the values of the stack
	 */
	public void print() {
		for (int i = 0; i <= top; i++) {
			System.out.println(stackArray[i]);
		}
	}
	/**
	 * Method displays all the values of the stack
	 */
	public void display(){
		for(int j=0; j <=top; j++){
			System.out.print(stackArray[j] + " ");
			System.out.println("");
		}
		
	}
	/**
	 * Bubble sort method used to organize stack contents
	 */
	public void bubbleSort(){
		int out, in;
		for (out = top; out > 1; out--){
			for(in=0; in < out; in++){
				if(stackArray[in].getAccessCode() > stackArray[in + 1].getAccessCode()){
					swap(in, in+1);
				}
			}
		}
	}
	/**
	 * 
	 * @param one first stack element used for comparison
	 * @param two second stack element used for comparison
	 */
	private void swap(int one, int two){
		Account temp = stackArray[one];
		stackArray[one] = stackArray[two];
		stackArray[two] = temp;
	}
}

/**
 * 
 * @author Alex Rooney Custom exception class for when stack is full
 *
 */
class FullStackException extends Exception {
	/**
	 * Exception triggered when push() on full stack
	 */
	@Override
	public String getMessage() {
		return "Stack is full";
	}
}