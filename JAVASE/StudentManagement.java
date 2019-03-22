import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Admin admins[] = new Admin[3];//创建管理员对象数组
        Student students[] = new Student[5];//创建管理员对象数组
        initAdmin(admins);//初始化管理员对象
        welcome();//打印欢迎界面
        firstOperation(admins);//执行首次操作，1登陆，2退出
        chooseOperation(students);//进行选择操作，1查看，2添加，3删除，4修改，5退出
        System.out.println(students[0].sex);
    }

    //    欢迎登陆
    public static void welcome() {
        System.out.println("----------------------欢迎登陆学生管理系统-------------------------------");
        System.out.println("                                    1.登陆    2.退出");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void initAdmin(Admin admins[]) {
        Admin admin = new Admin("admin", "admin");
        admins[0] = admin;
    }

    public static void firstOperation(Admin admins[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入：");
        int firstOperation = sc.nextInt();

        if (firstOperation == 1) {
            //登陆
            System.out.println("欢迎登陆系统！！！");
            login(admins);
        } else if (firstOperation == 2) {
            //退出系统
            System.exit(0);
        } else {
            //提示错误，再次输入
            System.out.print("输入错误，请再次输入：");
            firstOperation(admins);
        }
    }

    public static void login(Admin admins[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();

        for (int i = 0; i <= admins.length; i++) {
            if (i == admins.length) {
                System.out.println("用户名不存在或密码输入错误！请重新输入");
                login(admins);
                break;
            }
            Admin admin = admins[i];
            if (admin == null) {
                continue;
            }
            if (username.equals(admin.username) & password.equals(admin.password)) {
                System.out.println("登陆成功！！！");
                System.out.println("欢迎您：" + username);
                break;
            }
        }


    }

    public static void chooseOperation(Student students[]) {
        System.out.println("------------------请选择要操作的信息对应的数字------------------");
        System.out.println("1.查看学生信息   2.添加学生信息   3.修改学生信息   4.删除学生信息   5.退出");
        System.out.println("------------------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入：");
        int chooseOperation = sc.nextInt();
        if (chooseOperation == 1) {
            getStudentInformation();
        } else if (chooseOperation == 2) {
            addStudentInformation(students);
        } else if (chooseOperation == 3) {
            setStudentInformation();
        } else if (chooseOperation == 4) {
            deleteStudentInformation();
        } else if (chooseOperation == 5) {
            System.exit(0);
        } else {
            System.out.println("输入错误，请重新输入：");
            chooseOperation(students);
        }
    }

    public static void addStudentInformation(Student students[]) {
        Scanner sc = new Scanner(System.in);
//        Scanner cs = new Scanner(System.in);
        System.out.print("请输入学生ID：");
        int id = sc.nextInt();
        System.out.print("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.print("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.print("请输入学生联系方式：");
        int phone = sc.nextInt();
        System.out.print("请输入学生性别：");
        String sex = sc.nextLine();
        System.out.print("请输入学生年级：");
        String grade = sc.nextLine();
        System.out.print("请输入学生地址：");
        String address = sc.nextLine();
        System.out.print("请输入学生邮箱：");
        String email = sc.nextLine();
        for (int i = 0; i <= students.length; i++) {
            if(i==students.length){System.out.println("存储已满，无法继续加入新学生！！！");break;}
            if (students[i] == null) {
                Student student = new Student(0,0,0," "," "," "," "," ");
                student.setAge(age);
                student.setId(id);
                student.setPhone(phone);
                student.setName(name);
                student.setSex(sex);
                student.setGrade(grade);
                student.setAddress(address);
                student.setEmail(email);
                students[i]=student;
                break;
            }
        }
        System.out.println("数据保存成功！系统将自动返回上一层目录！");
//        chooseOperation(students);
    }

    public static void getStudentInformation() {

    }

    public static void setStudentInformation() {

    }

    public static void deleteStudentInformation() {

    }
}

class Admin {

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Student {

    public Student(int id,int age,int phone,String name,String sex,String address,String grade,String email){
        this.id = id;
        this.age = id;
        this.phone = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.grade = grade;
        this.email = email;
    }

    public int id;
    public String name;
    public String sex;
    public int age;
    public String grade;
    public String address;
    public int phone;
    public String email;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getGrade() {
        return grade;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
