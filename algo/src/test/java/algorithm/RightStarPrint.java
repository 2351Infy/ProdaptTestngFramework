package algorithm;

public class RightStarPrint {

	public static void main(String args[]) 
	{ 
	//x for rows, y for columns, and row denotes the number of rows to print 
	int x, y, row=5; 
	//outer loop for rows 
	for(x=0; x<row; x++) 
	{ 
	//inner loop for columns 
	for(y=2*(row-x); y>=0; y--) 
	{
	//To prints stars 
	System.out.print(" "); 
	} 
	
	 for (y = 0; y <= x; y++) {
         // printing stars
         System.out.print("* ");
     }
	//Cursor goes to the new line after printing each line. 
	System.out.println(); 
	} 
	} 
	}