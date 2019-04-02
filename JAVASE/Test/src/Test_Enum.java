import java.lang.reflect.Type;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-01 18:07
 **/
/*public enum Test_Enum {
    _A("a"),
    _B("b"),
    _C("c");

    String status;

    Test_Enum(String status) {
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }

    public static void main(String[] args){
        System.out.println(Test_Enum._A.getStatus());
    }
}*/

public class Test_Enum {
    private enum TYPE {RED, YELLOW, BLUE}

    public static void main(String[] args) {

        TYPE type = TYPE.RED;

        if (type == TYPE.RED) {
            System.out.println("red");
        } else if (type == TYPE.YELLOW){
            System.out.println("yellow");
        }else if (type == TYPE.BLUE){
            System.out.println("blue");
        }

    }
}
