package math.other;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author gongzhipeng
 * @version $$ PingFangGen, 2020/7/2 16:21 gongzhipeng $$
 */
public class PingFangGen
{

	private final static int[] wi =
			{ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	// verify digit
	private final static int[] vi =
			{ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };

	public static String uptoeighteen(String fifteencardid)
	{
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}
	//get verify
	private static String getVerify(String eightcardid)
	{
		int[] ai = new int[18];
		int remaining = 0;
		if (eightcardid.length() == 18)
		{
			eightcardid = eightcardid.substring(0, 17);
		}
		if (eightcardid.length() == 17)
		{
			int sum = 0;
			for (int i = 0; i < 17; i++)
			{
				String k = eightcardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}
			for (int i = 0; i < 17; i++)
			{
				sum = sum + wi[i] * ai[i];
			}
			remaining = sum % 11;
		}
		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}


	public static Timestamp calculateIdentityByRandomTime(String identityNo)
	{
		/** 第二步：以处理日期为准，随机减少365天，生成新日期 */
		/** 第三步：根据用户证件推算当前年龄所属区间，用上方生成的新日期加上年龄区间的有效期 */
		Timestamp endTime = null;
		try
		{
			if (identityNo.length() == 15)
			{
				identityNo = uptoeighteen(identityNo);
			}
			Timestamp now = DateUtil.getBeginOfToday();
			/** 随机生成历史时间处理，当前时间 -365 */
			Timestamp history = DateUtil.getIntervalDayTimestamp(now, -(int) (Math.random() * 365));

			Timestamp birthTime = DateUtil.formatToTimestamp(identityNo.substring(6, 14), DateUtil.FMT_DATE_SPECIAL);

			if (now.after(DateUtil.getIntervalYear(birthTime, 46)))
			{
				return null;
			}
			else if (now.after(DateUtil.getIntervalYear(birthTime, 26)))
			{
				endTime = DateUtil.getIntervalYear(history, 20);
			}
			else if (now.after(DateUtil.getIntervalYear(birthTime, 16)))
			{
				endTime = DateUtil.getIntervalYear(history, 10);
			}
			else
			{
				endTime = DateUtil.getIntervalYear(history, 5);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return endTime;
	}
	static int getNumber()
	{
		return  1 + (int)(Math.random()*365);
	}
	public static  int i = getNumber();
	public static void main(String[] args)
	{
		System.out.println(PingFangGen.class.getName());
		System.out.println(calculateIdentityByRandomTime("360121201901010101"));
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Timestamp(System.currentTimeMillis()));
//		calendar.add(5, -(int) (Math.random() * 365));
//		System.out.println(new Timestamp(calendar.getTime().getTime()));
//		System.out.println(i);
//		System.out.println(getNumber());
//
//		System.out.println(getNumber());
//		for (int i1 = 0; i1 < 10; i1++)
//		{
//			System.out.println(i);
//		}

	/*	System.out.println(new PingFangGen().getClass().getName());
		for (;;)
		System.out.println( 1 + (int)(Math.random()*365));*/
/*		long start = System.currentTimeMillis();
		for (int i1 = 0; i1 < 10000; i1++)
		{
			System.out.print(Math.sqrt(101));
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for (int i1 = 0; i1 < 10000; i1++)
		{
			System.out.print(sqr(1, 101, 11, 101));
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - start));*/
//		System.out.println(sqrt(5, 1, 5));
	}

	public static int sqrt(int x,double a,double b)
	{
		double mid=(a+b)/2;
		if(mid*mid>x&&mid*mid<x+1)
			return (int)mid;
		if(mid*mid>x)
			return sqrt(x,a,mid);
		if(mid*mid<x)
			return sqrt(x,mid,b);
		return (int)mid;
	}

	public static double sqr(double start, double end,int size, int number)
	{
		if(number == 1)
		{
			return 1;
		}
		if(number == 4)
		{
			return 2;
		}
		double mid = (start +  end) /2;
		double mid2 = mid * mid;
		if(mid2 == number)
		{
			return mid;
		}
		else if(mid2 > (number -0.0000000000000000001) && mid2 < number)
		{
			return mid;
		}
		else if(mid2 > number )
		{
			return sqr(start, mid, size, number);
		}
		else if(mid2 < number )
		{
			return sqr(mid, end, size, number);
		}
		else
		{
			return 0;
		}

	}
}
