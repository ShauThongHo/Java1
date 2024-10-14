public class LinearSearch{
	public static void main (String[] args){
		int[] list = {1,4,5,6,8,9,-1,6,2};
		int i = linearSearch(list, -1);
		if (i != (-1))
			System.out.println("Found");
		else
			System.out.println("Not Found");
	}
	
	public static int linearSearch(int[] list, int key){
		for (int i=0; i<list.length;i++){
			if (key == list[i])
				return 1;
		}
		return -1;
	}
}