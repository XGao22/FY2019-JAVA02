import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-02 08:28
 **/
public class Test_Collections {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List<Person> list = new ArrayList<Person>();

        list.add(new Person(4));
        list.add(new Person(8));
        list.add(new Person(5));
        list.add(new Person(3));
        list.add(new Person(9));
        list.add(new Person(2));
        list.add(new Person(7));
        Collections.sort(list);

        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }
}


class Person implements Comparable<Person> {

    private int id;
    private String name;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id:"+id;
    }

    @Override
    public int compareTo(Person o) {
        if (o == null) {
            return 1;
        }
        return this.id - o.getId();
    }
}
