package jvm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author gongzhipeng
 * @version $$ ConfigCheck, 2020/5/20 14:53 gongzhipeng $$
 */
public class ConfigCheck {
    Map loadProperties2Map(String file)
    {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(properties.size() == 0)
        {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            Temp temp = new Temp();
            temp.value = (String) entry.getValue();
            hashMap.put(entry.getKey(), temp);
        }

        return hashMap;
    }

    void checkConfig(Map<String, Temp> old, Map<String, Temp> newMap)
    {
        for (Map.Entry<String, Temp> entry : old.entrySet()) {
            Temp tempNew = newMap.get(entry.getKey());
            Temp tempOld = entry.getValue();
            if(tempNew == null)
            {
                System.out.println("未配置 key:" + entry.getKey());
            }
            else if(!tempNew.value.equals(tempOld.value))
            {
//                System.out.println(entry.getKey() + ",old :" + entry.getValue().value + ", new:" + newMap.get(entry.getKey()).value);
            }
            else
            {
                tempNew.isConfig = true;
            }

        }

        for (Map.Entry<String, Temp> entry : newMap.entrySet()) {
            if(!entry.getValue().isConfig)
            {
                System.out.println(entry.getKey() + " 不一致");
            }
        }

    }

    private class Temp
    {
        private String value;
        private boolean isConfig = false;
    }

    public static void main(String[] args) {
        ConfigCheck configCheck = new ConfigCheck();
        Map newMap = configCheck.loadProperties2Map("D:\\data\\epay-uc-service\\local\\log\\new.txt");
        Map oldMap = configCheck.loadProperties2Map("D:\\data\\epay-uc-service\\local\\log\\old.txt");
        configCheck.checkConfig(oldMap, newMap);
    }
}
