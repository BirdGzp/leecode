package jvm;

import java.util.List;

/**
 * @author gongzhipeng
 * @version $$ Test, 2020/5/20 10:44 gongzhipeng $$
 */
public class Test {
    public static void main(String[] args) {
       /* Properties properties = new Properties();
        String mapping = "123=123";
        String[] maps = mapping.split("\\|");
        if (maps.length > 0) {
            for (String map : maps) {
                if (map.contains("=")) {
                    String[] value = map.split("=");
                    properties.put(value[0], value[1]);
                }
            }
        }
        System.out.println(properties);*/
      String key = "1630020000158818,1630020035|1630020035060336,163002011|163002011,163002012|1630020120034557,163002014|163002014,163002016|1630020160034813,163002018|1630020180034406,163002020|1630020200034484,163002022|1630020220034389,163002024|1630020240034426,163002026|1630020260034470,163002028|1630020280034336,163002030|1630020300034373,163002032|1630020320030702,163002034|1630020340033647,1630020362|1630020362029016,1630020382|1630020382030481,163002201910|1630022019100020135542,163002201912|1630022019120030037650,163002202006";
       String[] keys = key.split("\\|");
        if (keys.length <= 1)
        {
            System.out.println("配置错误！！！ [{}]" + key);
            return;
        }
        for (int i = 0; i < keys.length; i++)
        {

                String[] point = keys[i].split(",");
                System.out.println("开始调度 [{}], [{}]" +  point[0] + " " + point[1]);

        }
    }


}
