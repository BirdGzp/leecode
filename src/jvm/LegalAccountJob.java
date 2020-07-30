package jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gongzhipeng
 * @version $$ LegalAccountCheckJob, 2020/4/20 11:53 gongzhipeng $$
 */

public class LegalAccountJob
{

	public static final String GENERATE_SPLIT_KEY = "GENERATE_SPLIT_KEY";
	static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(42);

	public static void main(String[] args) {
		generateAccountInfo();
	}
	public static void generateAccountInfo()
	{
		String key =
				"163002|1630020020|1630020035|163002010|163002011|163002012|163002013|163002014|163002015|163002016|163002017|163002018|163002019|163002020|163002021|163002022|163002023|163002024|163002025|163002026|163002027|163002028|163002029|163002030|1630020308|1630020316|1630020323|163002033|163002034|163002035|1630020357|1630020363|163002037|1630020375|163002038|1630020385|163002040|163002201908|163002201910|163002201912|163002202002|163002202006";
		String[] keys = key.split("\\|");
		System.out.println(keys.length);
		for (int i = 0; i < keys.length; i++)
		{
			final int value = i;
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run()
				{
				    String tempValue;
				    if(value + 1 >= keys.length)
                    {
                        tempValue = "";
                    }
				    else
                    {
                        tempValue = keys[value + 1];
                    }
					System.out.println("开始调度 [{}], [{}]" +  keys[value]  + " " +tempValue);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		threadPoolExecutor.shutdown();
	}

	public void legalAccountCheck()
	{
		/** 1.todo 多个一类户检查 (只允许存在一个一类户，两个表都检查 TB_ACCOUNT_INFORMATION TB_PAY_ACCOUNT_INFO) */

		/** 2. 通道账号存在等级的检查(通道账号不应该存在有等级的情况) SELECT * FROM tb_account_information WHERE TYPE = 'TUNNEL_ACCOUNT' AND GRADE IS NOT  NULL */

		/** 3. 挂起账号只能是通道账号 */
	}

}
