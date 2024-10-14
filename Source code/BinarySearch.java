public class BinarySearch{
	public static void main (String[] args){
		int[] list = {1,4,5,6,8,9,-1,6,2};
		int i = binarySearch(list, -1);
		if (i != (-1))
			System.out.println("Found");
		else
			System.out.println("Not Found");
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
		return -low -1;
	}
}