package in.spring4buddies.application.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class SortListAdapter implements Sorter {
	
	@Override
	public int[] sort(int[] numbers) {
		// convert the array to a List
		List<Integer> numberList = new ArrayList<Integer>();
		// call the adapter
		NumberSorter sorter = new NumberSorter();
		numberList = sorter.sort(numberList);
		// convert the list back to an array and return
		int[] sortedNumbers = new int[numberList.size()];
		return sortedNumbers;
	}
}
