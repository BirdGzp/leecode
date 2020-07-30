package jvm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


/**
 * @author gongzhipeng
 * @version $$ GenerateSQL, 2020/6/18 14:11 gongzhipeng $$
 */
public class GenerateSQL {


    /**
     * @param args
     */
    public static void main(String[] args) {
        copyToFile("C:\\Users\\gongzhipeng\\Documents\\call_bk_ssn_20200609", "C:\\Users\\gongzhipeng\\Documents\\ursAccount");
    }

    public static void copyToFile(String fileName, String generateFileName) {
        try {
            FileWriter fw = new FileWriter(generateFileName);
            ///读取文件的东西
            InputStreamReader fr = new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            int i = 0;
            while ((str = br.readLine()) != null) {
                i++;
                String result = operator(str);
                if (result == null) {
                    continue;
                }
                if(i % 15000000 == 0)
                {
                    fw = new FileWriter(generateFileName  + i/ 15000000);
                }
                fw.write(result);
            }

            br.close();
            fr.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String operator(String str) {
        String[] result = str.split("\t");
        /*if ("取消预注销".equals(result[1]) || "预注销".equals(result[1])) {
            return null;
        }
        System.out.println(result[0] + " " + result[1]);*/

        return "INSERT INTO TMP_URS_ACCOUNT_ID ACCOUNT_ID VALUES('" + result[0] + "');\r\n";
    }

}
