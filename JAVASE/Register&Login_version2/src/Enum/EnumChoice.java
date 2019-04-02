package Enum;

/**
 * @program: Register&Login
 * @description
 * @author: X.Gao
 * @create: 2019-04-01 18:16
 **/
public enum EnumChoice {
    a("1"),
    b("2"),
    c("3"),
    d("4");

    private String choice;
    EnumChoice(String choice) {
        this.choice = choice;
    }
    public String getChoice(){
        return this.choice;
    }
}
