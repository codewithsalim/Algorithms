
import java.io.*;
import java.util.*;
class Solution{

	static Stack<Integer> sortStack(Stack<Integer> input){
		Stack<Integer> tmpStack = new Stack<Integer>();
	
		while (!input.empty()){
			int curr = input.pop();
			while (!tmpStack.empty() && tmpStack.peek() < curr){
				input.push(tmpStack.pop());
			}
			tmpStack.push(curr);
		}
		return tmpStack;
	}
	
	static void sortArrayUsingStacks(int []arr){
		Stack<Integer> input = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++)
			input.push(arr[i]);
			
		Stack<Integer> sortedStack = sortStack(input);
		for (int i = 0; i < arr.length; i++){
			arr[i] = sortedStack.pop();
		}
	}
	
	public static void main(String args[]){
		int []arr = {10, 5, 98, 15, 45};
		sortArrayUsingStacks(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}

