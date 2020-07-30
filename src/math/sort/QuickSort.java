package math.sort;

/**
 *
 * @author gongzhipeng
 * @version $$ QuickSort, 2020/6/28 12:56 gongzhipeng $$
 */
public class QuickSort
{
	public static int[] quickSort(int start, int end, int[] arrays)
	{
		if (start >= end)
		{
			return arrays;
		}

		int low = start, high = end;
		// 主元
		int main = arrays[start];
		while(low < high)
		{
			while( high > low && main <= arrays[high])
			{
				high--;
			}
			arrays[low] = arrays[high];
			while( high > low && main >= arrays[low])
			{
				low++;
			}
			arrays[high] = arrays[low];
		}
		System.out.println(high + "  " + low);
		arrays[high] = main;
		quickSort(start, low - 1, arrays);
		quickSort(high + 1, end, arrays);
		return arrays;
	}

	public static void main(String[] args)
	{
		int[] arr = {5, 1, 7, 3, 1, 6, 9, 4,10, 11,53, 42, 23,78,65 ,2 ,100, 8};

		quickSort( 0, arr.length - 1, arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
}
