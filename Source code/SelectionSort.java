public class SelectionSort{
	public static void main (String[] args){
		double[] list = {1,4,5,6,8,9,-1,6,2};
		System.out.println("Before sorting; ");
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		
		selectionSort(list);
		
		System.out.println("\nAfter sorting: ");
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
	public static void selectionSort(double[] list) {
    for (int i = 0; i < list.length; i++) {
      // Find the minimum in the list[i..list.length-1]
      double currentMin = list[i];
      int currentMinIndex = i;
      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      // Swap list[i] with list[currentMinIndex] if necessary;
      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }
    }
  }

}