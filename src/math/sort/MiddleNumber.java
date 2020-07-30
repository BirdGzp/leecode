package math.sort;

/**
 *
 * @author gongzhipeng
 * @version $$ MiddleNumer, 2020/6/28 16:21 gongzhipeng $$
 */
public class MiddleNumber
{
	public static int[] quickSort(int start, int end, int[] arrays, int mid)
	{
		if(start == end)
		{
			System.out.println(start);
		}
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

		arrays[high] = main;
		System.out.println("hign " + high + ", main " + main);
		if(high == mid)
		{
			System.out.println(arrays[high]);
		}
		else if(high > mid)
		{
			quickSort(start, high - 1, arrays, mid);
		}
		else
		{
			quickSort(high + 1, end, arrays, mid);
		}
		return arrays;
	}
	public static void main(String[] args)
	{
		int[] arr = {5, 1, 7, 3, 1, 6, 9, 4,10, 11,53, 42, 23,78,65 ,2 ,100, 8, 30 ,20, 18, 17, 23, 22};
		System.out.println( (arr.length) / 2);
		quickSort( 0, arr.length - 1, arr, (arr.length) / 2);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
}
