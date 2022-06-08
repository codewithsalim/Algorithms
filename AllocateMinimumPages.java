/*
Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
*/

public class Solution{
	// Utility method to check if current minimum value is feasible or not.
	static boolean isPossible(int pages[], int numberOfBooks, int numberOfStudents, int curr_min){
		int studentsRequired = 1;
		int curr_sum = 0;

		for (int i = 0; i < numberOfBooks; i++){
			// check if current number of pages are greater than curr_min that means we will get the result after mid no. of pages
			if (pages[i] > curr_min)
				return false;
			// count how many students are required to distribute curr_min pages
			if (curr_sum + pages[i] > curr_min){
				// increment student count
				studentsRequired++;
				curr_sum = pages[i];
				if (studentsRequired > numberOfStudents)
					return false;
			}else{
			    curr_sum += pages[i];
			}
		}
		return true;
	}

	static int allocatePages(int pages[], int numberOfStudents){
		int totalPages = 0;
		int numberOfBooks = pages.length; 
	
		if (numberOfBooks < numberOfStudents) return -1;
	
		for (int i = 0; i < numberOfBooks; i++)
			totalPages += pages[i];

		int start = 0;
		int end = totalPages;
		int result = Integer.MAX_VALUE;
	
		while (start <= end){
			int mid = (start + end) / 2;
			if (isPossible(pages, numberOfBooks, numberOfStudents, mid)){
				// update result to current distribution as it's the best we have found till now
				result = mid;
				// as we are finding minimum and books are sorted so reduce end = mid -1
				end = mid - 1;
			}else{
				start = mid + 1;
      }
		}
		return result;
	}
	
	public static void main(String[] args){
		//Number of pages in books
		int pages[] = {12, 34, 67, 90};
		int numberOfStudents = 3; //No. of students
		System.out.println("Minimum number of pages = " +
						allocatePages(pages, numberOfStudents));
	}
}
