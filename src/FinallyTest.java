import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hzzhouhongfei
 * @version $$ FinallyTest, 2020/4/7 9:49 hzzhouhongfei $$
 */
public class FinallyTest
{
	public static void main(String[] args)
	{
//		List l = new ArrayList();
//		l.add("12313");
//				l.add("!2313");
//		System.out.println(l.get(0));
//		System.out.println(RealNameIdentifyResult.SUCCESS.name());
		System.out.println("2019052317PT60109382|P".contains("2019052317PT60109382|P"));
	}

	public static void test()
	{
		try
		{
			System.out.println("try");
			int i = 1 / 0;

		}
		catch (Exception e)
		{
			System.out.println("catch");
			int x =  1 / 0;
		}
		finally
		{
			System.out.println(123213);
		}
	}
}
