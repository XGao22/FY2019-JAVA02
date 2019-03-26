import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Admin admins[] = new Admin[3];//创建管理员对象数组
        Student students[] = new Student[5];//创建管理员对象数组
        initAdmin(admins);//初始化管理员对象
        welcome();//打印欢迎界面
        firstOperation(admins);//执行首次操作，1登陆，2退出
        chooseOperation(students);//进行选择操作，1查看，2添加，3删除，4修改，5退出
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

        for (int i = 0; i < admins.length; i++) {
            Admin admin = admins[i];
            if (admin == null) {
                continue;
            }
            if (username.equals(admin.username) & password.equals(admin.password)) {
                System.out.println("登陆成功！！！");
                System.out.println("欢迎您：" + username);
                break;
            } else {
                System.out.println("用户名不存在或密码输入错误！请重新输入");
                login(admins);
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
            getStudentInformation(students);
        } else if (chooseOperation == 2) {
            addStudentInformation(students);
        } else if (chooseOperation == 3) {
            setStudentInformation(students);
        } else if (chooseOperation == 4) {
            deleteStudentInformation(students);
        } else if (chooseOperation == 5) {
            System.exit(0);
        } else {
            System.out.println("输入错误，请重新输入：");
            chooseOperation(students);
        }
    }

    public static void addStudentInformation(Student students[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生ID：");
        int id = sc.nextInt();
        if (id >= students.length) {
            System.out.println("输入的ID值超出范围，请重新输入");
            addStudentInformation(students);
            return;
        }
        if (students[id] != null) {
            System.out.println("输入的ID值重复，请重新输入");
            addStudentInformation(students);
            return;
        }
        System.out.print("请输入学生姓名：");
        String name = sc.next();
        System.out.print("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.print("请输入学生联系方式：");
        int phone = sc.nextInt();
        System.out.print("请输入学生性别：");
        String sex = sc.next();
        System.out.print("请输入学生年级：");
        String grade = sc.next();
        System.out.print("请输入学生地址：");
        String address = sc.next();
        System.out.print("请输入学生邮箱：");
        String email = sc.next();
        Student student = new Student(0, 0, 0, " ", " ", " ", " ", " ");
        student.setAge(age);
        student.setId(id);
        student.setPhone(phone);
        student.setName(name);
        student.setSex(sex);
        student.setGrade(grade);
        student.setAddress(address);
        student.setEmail(email);
        students[id] = student;
        System.out.println("数据保存成功！系统将自动返回上一层目录！");
        chooseOperation(students);
    }

    public static void getStudentInformation(Student students[]) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                break;
            }
            if (i == students.length - 1) {
                System.out.print("系统为空，请录入学生信息：");
                addStudentInformation(students);
                return;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生ID：");
        int id = sc.nextInt();
//        数组为空的判断方式？？？？？？？？？？？？？？？？？？？？？？？？
        if (id > students.length) {
            System.out.print("超出系统容量上限，请重新输入学生ID：");
            getStudentInformation(students);
            return;
        }
        if (students[id] == null) {
            System.out.print("系统暂未存入该学生信息，");
            getStudentInformation(students);
            return;
        }
        System.out.println("学生ID：" + students[id].getId() + "&&" + students[id].id);
        System.out.println("学生姓名：" + students[id].getName() + students[id].name);
        System.out.println("学生年龄：" + students[id].getAge());
        System.out.println("学生联系方式：" + students[id].getPhone());
        System.out.println("学生性别：" + students[id].getSex());
        System.out.println("学生年级：" + students[id].getGrade());
        System.out.println("学生地址：" + students[id].getAddress());
        System.out.println("学生邮箱：" + students[id].getEmail());
        chooseOperation(students);
    }

    public static void setStudentInformation(Student students[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请选择要修改的学生ID号码：");
        int id = sc.nextInt();
        if (students[id] == null) {
            System.out.print("没有该学生，无法修改，请重新输入学生ID：");
            setStudentInformation(students);
            return;
        }
        System.out.println("------------------请选择要修改的信息对应的数字------------------");
        System.out.println("1.ID   2.姓名   3.性别   4.年龄   5. 联系方式  6.年级   7.地址   8.邮箱   9.退出");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("请输入：");
        int chooseSetOperation = sc.nextInt();
        if (chooseSetOperation == 1) {
            System.out.print("请输入ID：");
            int setId = sc.nextInt();
            if (students[setId] != null) {
                System.out.println("修改后的ID值重复，请重新输入,输入6则返回顶部菜单,输入其他数字则继续");//暂时标记一下，如果数组满了，执行这个操作就死循环了
                if (sc.nextInt() == 6){
                    chooseOperation(students);
                    return;
                }else {
                    setStudentInformation(students);
                    return;
                }
            }
            students[id].setId(setId);
            students[setId] = students[id];
            students[id] = null;
        } else if (chooseSetOperation == 2) {
            System.out.print("请输入姓名：");
            students[id].setName(sc.next());
        } else if (chooseSetOperation == 3) {
            System.out.print("请输入性别：");
            students[id].setSex(sc.next());
        } else if (chooseSetOperation == 4) {
            System.out.print("请输入年龄：");
            students[id].setAge(sc.nextInt());
        } else if (chooseSetOperation == 5) {
            System.out.print("请输入联系方式：");
            students[id].setPhone(sc.nextInt());
        } else if (chooseSetOperation == 6) {
            System.out.print("请输入年级：");
            students[id].setGrade(sc.next());
        } else if (chooseSetOperation == 7) {
            System.out.print("请输入地址：");
            students[id].setAddress(sc.next());
        } else if (chooseSetOperation == 8) {
            System.out.print("请输入邮箱：");
            students[id].setEmail(sc.next());
        } else if (chooseSetOperation == 9) {
            System.exit(0);
        } else {
            System.out.println("输入错误，请重新输入：");
            chooseOperation(students);
        }
        chooseOperation(students);
    }

    public static void deleteStudentInformation(Student students[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要删除的学生ID：");
        int id = sc.nextInt();
        if (students[id] == null) {
            System.out.print("没有该学生，无法删除，请重新输入学生ID：");
            deleteStudentInformation(students);
            return;
        }
        students[id] = null;
        chooseOperation(students);
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

    public Student(int id, int age, int phone, String name, String sex, String address, String grade, String email) {
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
