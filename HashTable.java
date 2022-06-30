/**
 * @author Raunak Sandhu
 * id - 30117897
 * 
 * This class is for the Java implementation of the HashTable in A3
 * 
 */

import java.util.LinkedList;

public class HashTable
{
	private LinkedList<Student> arr[];
	public static final int LEN = 8;
	/**
	 * Constructor method initializes array of type LinkedList with length LEN
	 * Each element of the array is initialized to a LinkedList of type Student
	 */
	public HashTable(){
		arr = new LinkedList[LEN];
		for (int i = 0; i < LEN; i++){
			arr[i] = new LinkedList<Student>();
		}
	}
	
	/**
	 * Method returns the hashvalue (i.e. corresponding bucket) for the HashTable
	 * Iterates through string and sums each character ACSCII value
	 * @param s
	 * @return
	 */
	public int hashValue(String s){
		// Your implementation of the hash function goes here.
		// For help with getting ASCII values of characters, see asciiIntDemo.java
		int temp = 0;				// temp variable
		for (int i = 0; i<= s.length()-1; i++) {	// iterate through name
			temp += s.charAt(i);	// sum the ASCII character values
		}
		return temp % 8;			// return sum mod 8

	}
	
	/**
	 * Method returns true if a Student with given name exists in the HashTable
	 * Calculates string hashValue to find the bucket and then searches the LinkedList for the student
	 * @param name
	 * @return
	 */
	public boolean search(String name){
		// Your implementation of search() goes here.
		int bucket = hashValue(name);				// calculate hashTable bucket		
		if (arr[bucket].size() == 0) return false;	// if LL is empty return false
		for (int i = 0; i <= arr[bucket].size() - 1; i++) {	// iterate through LL
			if (arr[bucket].get(i).getName().equals(name)) return true;	// if a match return true
		}		
		return false;	// no matches return false

	}
	
	/**
	 * Method inserts a student with name and age into the HashTable. If student already exists, their age is updated.
	 * Calculates hashValue for student and then checks if student exists in LinkedList already. If not student is appended.
	 * @param name
	 * @param age
	 */
	public void insert(String name, int age){
		// Your implementation of insert() goes here.
		// Remember that if a student of this name already exists in the table,
		// you should modify that student's age. Otherwise, add a Student with
		// appropriate name and age to the end of the appropriate linked list.
		int bucket = hashValue(name);		// bucket value in hashTable
		Student new_Stu = new Student(name, age);	// create new Student to be added
		boolean contains_Stu = false;		// var if student already exists
		if (arr[bucket] == null) {			// if LL is null
			arr[bucket].add(new_Stu);		// add the new student
			System.out.println("Inserting student " + name + ", age " + age);
		}
		for (int i = 0; i <= arr[bucket].size() - 1; i++) {	// iterate through LL
			if (arr[bucket].get(i).getName().equals(name)) {	// if match
				int old_age = arr[bucket].get(i).getAge();		// get old age
				System.out.println("Changing age of " + name + " from " + old_age + " to " + age);
				arr[bucket].get(i).setAge(age);		// update age
				contains_Stu = true;	// change bool var
				break;	// exit for loop
			}
		}
		if (contains_Stu == false) {	// if no match
			arr[bucket].add(new_Stu);	// add to new student to end of LL
			System.out.println("Inserting student " + name + ", age " + age);
		}
	}
	
	/**
	 * Delete Student with a given name by iterating through the appropriate LinkedList
	 * If no student exists print error statement
	 * @param name
	 */
	public void delete(String name){
		// Your implementation of delete() goes here.
		// Remember that if the hash table has no students of this name,
		// then you should print a message indicating this.
		int bucket = hashValue(name);	// bucket value in hashTable
		boolean contains_Stu = false;	// contains student to false

		for (int i = 0; i <= arr[bucket].size() - 1; i++) {	// iterate through LL
			if (arr[bucket].get(i).getName().equals(name)) {	// if match
				System.out.println("Removing student " + name + ", age " + arr[bucket].get(i).getAge());
				arr[bucket].remove(i);	// remove student
				contains_Stu = true;	// set contained to true
				break;	// exit
			}
		}
		if (contains_Stu == false) {
			System.out.println("There does not exist a student with name " + name);	// print if no match
		}

		
	}
	
	/**
	 * Get age of a student with a given name
	 * If no student exists print error message
	 * @param name
	 * @return
	 */
	public int getAge(String name){
		// Your implementation of getAge() goes here.
		// Remember that if the hash table has no students of this name,
		// then you should print a message indicating this and return -1.
		int bucket = hashValue(name);	// bucket value in HashTable

		for (int i = 0; i <= arr[bucket].size() - 1; i++) {	// iterate through LL
			if (arr[bucket].get(i).getName().equals(name)) {	// if match student
				return arr[bucket].get(i).getAge();		// return age
			}
		}
		System.out.println("There does not exist a student with name " + name);	// if no match print message and return -1
		return -1;
	}
	
	/**
	 * Increment age for a student with a given name
	 * If no student with name exists in the HashTable print error message
	 * @param name
	 */
	public void increment(String name){
		// Your implementation of increment() goes here
		// Remember that if the hash table has no students of this name,
		// then a message should be printed indicating this.
		
		int bucket = hashValue(name);		// bucket value hashTable
		boolean contains_Stu = false;		// contains student to false

		for (int i = 0; i <= arr[bucket].size() - 1; i++) {		// iterate through LL
			if (arr[bucket].get(i).getName().equals(name)) {	// if match
				int new_age = arr[bucket].get(i).getAge() + 1;	// increment age
				System.out.println("Changing age of " + name + " from " + arr[bucket].get(i).getAge() + " to " + new_age);
				arr[bucket].get(i).setAge(new_age);	// update age
				contains_Stu = true;	// change to true
				break;	// exit
			}
		}
		if (contains_Stu == false) {	// if no match print message
			System.out.println("There does not exist a student with name " + name);
		}
	}
	
	/**
	 * Return string visualization of HashTable
	 * by iterating through
	 */
	public String toString(){
		// Your implementation of the toString() method goes here
		// Hint: It’s intended that you use the built-in toString()
		// for LinkedList, which will implicitly call the toString()
		// for Student, which has already been implemented.
		String ret = "";	// return string
		for (int i = 0; i <= arr.length - 1; i++) {	// iterate through HashTable
			ret += i+": ";	// for each index
			if (arr[i].size() == 0) ret += "[]\n";	// if LL is empty add []
			else {
				ret += arr[i] + "\n";	// add LL to string
			}
		}
		return ret;	// return ret
	}
}