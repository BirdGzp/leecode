package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gongzhipeng
 * @version $$ TestSchedule, 2020/4/15 17:25 gongzhipeng $$
 */
public class TestSchedule  extends RoundRobinSchedule{
    String a = "123456789abcdefghijklmnopqrstuvwxyz";
    @Override
    public List listData(String start, int size) {
        List<String> strings = new ArrayList<>();
        char[] chars = a.substring(a.indexOf(start) + 1, a.indexOf(start) + size).toCharArray();
        System.out.println(chars.length + ".." + chars[0]);;
        for (char aChar : chars) {
            strings.add("" + aChar);
        }
        return strings;
    }

    @Override
    public String operate(Object str) {
        System.out.println(str.toString());
        return str.toString();
    }

    public static void main(String[] args) {
        TestSchedule testSchedule = new TestSchedule();
        testSchedule.model("1", 3);
    }
}
