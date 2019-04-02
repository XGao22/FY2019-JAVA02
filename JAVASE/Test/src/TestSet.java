import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-03-29 11:16
 **/
public class TestSet {
    public static void main(String[] args) {
        TestSet ts = new TestSet();
        ts.testSet();
    }

    static void testSet() {
        Set set = new HashSet();
        set.add(1);
        set.add(1);
        set.add("abc");
        System.out.println(set);
    }
}
