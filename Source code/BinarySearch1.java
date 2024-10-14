public class BinarySearch1{
	public static void main (String[] args){
		int[] list = {-1,1,2,3,5,6,6,7,9};
		int i = binarySearch(list, 3);
		if (i <= (-1))
			System.out.println("Not Found");
		else
			System.out.println("Found");
	}
	
	public static int binarySearch(int[] list, int key){
		int low = 0;
		int high = list.length -1 ;
		
		while (high >= low){
			int mid = (low + high)/2;
			if (key < list[mid])
				high = mid -1;
			else if (key == list[mid])
				return mid;
			else
				low = mid + 1;
		}
		System.out.println(-1-low);
		return -low -1;
	}
}