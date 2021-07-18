package algorithm;

public class shiftZeroAtEnd {


	public static void shiftZeroToEnd(int[] arr, int n) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if (arr[i]!=0) {
				arr[count++]=arr[i];
			}
		}
		for (int j=count;j<n;j++) {
			arr[count++]=0;
		}	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {2,3,4,0,6,7,8,0,0,8,9};
		shiftZeroToEnd(arr, 11);
		for(int i=0;i<11;i++) {
			System.out.print(arr[i]);

		}


	}











	private static void shiftZeroToEnd(String str) {
		// TODO Auto-generated method stub

	}

}
