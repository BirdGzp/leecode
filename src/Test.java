import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gongzhipeng
 * @version $$ Test, 2020/6/30 15:42 gongzhipeng $$
 */
public class Test
{
	static class a
	{
		public void test()
		{
			int arithmeticNumber = 916132834;
			for(long flag = 0; flag < 100000000000L; flag++) {
				while (arithmeticNumber != 0) {
					arithmeticNumber = arithmeticNumber /64;
					int index = arithmeticNumber % 64;
				}
			}
			int bitOperationNumber = 916132834;
			for (long flag = 0; flag < 100000000000L; flag++) {
				while (bitOperationNumber != 0) {
					bitOperationNumber = bitOperationNumber >> 6;
					int index = bitOperationNumber & (64 - 1);
				}
			}
		}
	}

	static class b extends a
	{

	}
	public static boolean timeBetween(String startDate, String endDate)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");

			Date start = format.parse(startDate);
			Date end = format.parse(endDate);

			long nowTime = System.currentTimeMillis();
			long startTime = start.getTime();
			long endTime = end.getTime();
			System.out.println(nowTime);
			System.out.println(startTime);
			System.out.println(endTime);
			return nowTime >= startTime && nowTime <= endTime;
		}catch (Exception e)
		{
			System.out.println("时间参数配置错误");
			return false;
		}


	}

	public static void main(String[] args)
	{

		String a = "platformId-[0,12,14]|[1,12,14]";
		System.out.println(a.split("-").length);
//		long start = System.currentTimeMillis();
//		int arithmeticNumber = 916132834;
//		for (long flag = 0; flag < 100000000000L; flag++) {
//			while (arithmeticNumber != 0) {
//				arithmeticNumber = arithmeticNumber /64;
//				int index = arithmeticNumber % 64;
//			}
//		}
//		System.out.println("时间" + (System.currentTimeMillis() - start));
//		start = System.currentTimeMillis();
//		int bitOperationNumber = 916132834;
//		for (long flag = 0; flag < 100000000000L; flag++) {
//			while (bitOperationNumber != 0) {
//				bitOperationNumber = bitOperationNumber >> 6;
//				int index = bitOperationNumber & (64 - 1);
//			}
//		}
//		System.out.println(System.currentTimeMillis() - start);
		String key = "UnionpayNoCardQuickPay.PsbcCreditQuickPay";
		String[] info = key.split("\\.");
		System.out.println(info.length);
		System.out.println(info[0]);
	}
}
