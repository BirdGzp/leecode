package jvm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 * @author gongzhipeng
 * @version $$ FileTest, 2020/5/11 16:50 gongzhipeng $$
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        String header = generateSpecialMerchantFileHeader(10, "!23");
//        String myPath = "D:\\test\\abc";
//        String content = "!2312、\n666\n 12312";
//        File file = new File(myPath);
//        if (!file.exists())
//        {
//            file.getParentFile().mkdirs();
//        }
//        FileOutputStream out = new FileOutputStream(file, true);
//        FileChannel outChannel = out.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1000 * 10);
//        //清空缓存
//        buffer.clear();
//        buffer.put(header.getBytes("GB18030"));
//        if(file.length() > 0)
//        {
//            buffer.put("\n".getBytes());
//        }
//        buffer.put(content.getBytes());
//        //切换为读模式
//        buffer.flip();
//        //通过管道写到文件
//        outChannel.write(buffer);
//        out.close();
//        outChannel.close();
//        changeHeader(111110000);
//        writeFile();

/*        InputStreamReader fr = new InputStreamReader(new FileInputStream("C:\\Users\\gongzhipeng\\Desktop\\legal (1)\\M5账号修改数据\\Z2008533000013_M5_N_20200512_00000001.TXT"),"GB18030");
        BufferedReader br = new BufferedReader(fr);
        String str = null;
        while (( str = br.readLine()) != null) {
            System.out.println(str);
        }*/

        copyToFile("D:\\data\\mb_ssn_20200507", "D:\\data\\urs.sql");
    }

    public static void writeFile() {
        try {
            FileOutputStream fw = new FileOutputStream("C:\\Users\\gongzhipeng\\Desktop\\legal (1)\\M5账号修改数据\\Z2008533000013_M5_M_20200512_00000001.TXT");
//            FileWriter fw = new FileWriter("C:\\Users\\gongzhipeng\\Desktop\\legal (1)\\M5账号修改数据\\t.TXT");

            OutputStreamWriter bw = new OutputStreamWriter(new DataOutputStream(fw), "GB18030");

            ///读取文件的东西
            InputStreamReader fr = new InputStreamReader(new FileInputStream("C:\\Users\\gongzhipeng\\Desktop\\legal (1)\\M5账号修改数据\\全量数据.TXT"),"GB18030");
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            int size = 7848542;
            while ((str = br.readLine()) != null) {
                if(str.length() < 20)
                {
                    continue;
                }
                size--;
                str = str.replace(";|", "|");
                //9548523
//                System.out.println(str);
                if (size == 7848541) {
                    str = str.replace("25004552", "7848541");
                    bw.write(str+ "\r\n");

                } else {
                    bw.write(str + "\r\n");
                }
                if (size == 0) {
                    break;
                }
            }
            bw.flush();
            fw.close();//关闭此流，但要先刷新它。在关闭该流之
            bw.close();
            fr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeHeader(int count) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("D:\\test\\abc", "rw");
        raf.seek(0);

        String header = new String(raf.readLine().getBytes("ISO-8859-1"), "utf-8");
        if (header.contains("|")) {
            String[] headSplit = header.split("\\|");
            int newCount = Integer.valueOf(headSplit[2]) + count;
            header = generateSpecialMerchantFileHeader(newCount, "123!");
            raf.seek(0);
            raf.write(header.getBytes("GB18030"));
        }


    }


    /**
     * 文件内容——合规版本号
     */
    private static final String LEGAL_VERSION = "01";
    /**
     * 文件后缀
     */
    private static final String SUFFIX = ".TXT";
    private static final String ORG_CODE = "Z2008533000013";

    private static final String JOINER = "_";

    private static final String JOINER1 = "|";
    /**
     * 特约商户交易流水表
     */
    private static final String SPECIAL_MERCHANT_FLOW = "D3";

    private static final String SPECIAL_MERCHANT_TOTAL_FLOW = "S3";
    /**
     * 新增模式
     */
    private static final String DATA_MODEL_APPEND = "N";

    public static String generateSpecialMerchantFileHeader(Integer count, String version) {
        StringBuilder header = new StringBuilder(
                LEGAL_VERSION).append(JOINER1).append(ORG_CODE).append(JOINER1).append(count).append(JOINER1).append(version);
        return header.toString();
    }




    public static void copyToFile(String fileName, String generateFileName) {
        try {
            FileWriter fw = new FileWriter(generateFileName, true);
            ///读取文件的东西
            InputStreamReader fr = new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine()) != null) {
                String result = operator(str);
                if(result == null)
                {
                    continue;
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

    public static String operator(String str)
    {
        String[] result = str.split("\t");
        if("取消预注销".equals(result[1]) || "预注销".equals(result[1]))
        {
            return null;
        }

//        return "insert into TMP_CANCEL_ACCOUNT VALUES( \'" + result[0] + "\', \'" + result[2] + "\');\n" ;
        // urs 手机注销数据
        String sql =  "insert into TMP_CANCEL_ACCOUNT VALUES( \'" + result[0] + "\', \'" + result[1] + "\');\n" ;
        System.out.println(sql);
        return sql;
    }
}
