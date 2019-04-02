public class Test_Student {

    //属性
    int id;
    String name;
    int sex;
    String address;

    //方法
    public void study(int _id) {
        System.out.println(_id);
    }

    public Test_Student(int _id, String _name) {
        id = _id;
        name = _name;
    }

    public static void main(String[] args) {
        Test_Student ts = new Test_Student(001,"GX");
//        Test_Student ts = new Test_Student();
        System.out.println(ts.id);
        System.out.println(ts.name);
        System.out.println(ts.sex);
        System.out.println(ts.address);
    }
}
