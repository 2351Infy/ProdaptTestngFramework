package algorithm;

import java.util.Scanner;


public class wordsInString {
	static int count=0;
	public wordsInString(String s) {
		
		for(int i=0;i<=s.length();i++) {
			count++;
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string :");
		String wrd=sc.nextLine();
		wordsInString wrdStr=new wordsInString(wrd);
		System.out.println(wrdStr);

	}

}
