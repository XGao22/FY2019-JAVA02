import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-01 18:57
 **/
public class Test_List {
    public static void main(String[] args) {
        testList();
        ;
    }

    public static void testList() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.print(o);
        }
    }
}
