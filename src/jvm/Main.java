package jvm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.management.snmp.jvminstr.JvmClassLoadingImpl;

import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       /* JVMGcAggregator jvmGcAggregator = new JVMGcAggregator();
         CompilationMXBean comMbean = ManagementFactory.getCompilationMXBean();
        for (int i = 0; i < 10; i++) {
            byte[] x = new byte[1024 * 1024 * 100] ;
        }
        for (int i = 0; i < 20; i++) {
            byte[] x = new byte[1024 * 1024 * 100] ;
        }
        System.out.println("end");
        System.out.println(jvmGcAggregator.constructItemRow().toString());
        System.out.println(comMbean.getTotalCompilationTime());*/

        ArrayList arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add("!@3123");
        System.out.println(arrayList.get(1));
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis() - 100000);
//        Timestamp timestamp3 = new Timestamp(System.currentTimeMillis() + 10000000);
//        System.out.println(getLongerAgoTime(timestamp, timestamp2));
//        System.out.println(getLongerAgoTime(timestamp, timestamp2));
//        System.out.println(getCloserAgoTime(timestamp, timestamp3));
//        System.out.println(getCloserAgoTime(timestamp, timestamp3));
//
//        System.out.println("123".substring(0, "123".indexOf("#")));

    }


    /**
     * 获得过去 相对更远的时间，不适用于未来
     * 1999 和 2000 得到 19999
     * @param timestamp
     * @param timestamp2
     * @return
     */
    public static Timestamp getLongerAgoTime(Timestamp timestamp, Timestamp timestamp2)
    {
        if(timestamp.compareTo(timestamp2) > 0)
        {
            return timestamp2;
        }
        return timestamp;
    }

    /**
     * 获得过去 相对更近的时间，不适用于未来
     * 1999 和 2000 得到2000
     * @param timestamp
     * @param timestamp2
     * @return
     */
    public static Timestamp getCloserAgoTime(Timestamp timestamp, Timestamp timestamp2)
    {
        if(timestamp.compareTo(timestamp2) > 0)
        {
            return timestamp;
        }
        return timestamp2;
    }
}
