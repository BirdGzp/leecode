package jvm;

import java.util.regex.Pattern;

/**
 *
 * @author hzzhouhongfei
 * @version $$ PatternTest, 2020/3/5 9:33 hzzhouhongfei $$
 */
public class PatternTest
{
	public static void main(String[] args)
	{
		System.out.println("epayautotest@yixin.163.com".matches("^.+@(?!(wyb|vip|popo|quyu|platform|yxpay)\\b)(.+)\\.163\\.com$"));
		String a = "!23";
	}

	static void test(String a)
	{
		a = "234";
	}
}
