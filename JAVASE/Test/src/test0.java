import java.io.*;
import java.util.Scanner;

public class test0 {
    public static void main(String[] args) {

        //计算平均值
//        int[] av = new int[100];
//        for(int i = 1;i<=100;i++){
//            av[i-1] = i;
//        }
//        System.out.println(average(av));

        //判断数组中是否存在数字n
//        int arr[] = {1,2,3,4,5,6,7,8,9};
////      int n = System.in.read();
//        System.out.println("输入n：");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int result = isExist(n,arr);
//        System.out.println(result);

        //给定数组的冒泡排序
//        int arr[] = {1, 3, 2, 7, 5, 4, 6, 8, 2, 5, 6, 9, 3, 0};
//        arr = bubble(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        //数字黑洞6174
//        System.out.println("输入n：");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i = blackHole(n);

        //二维数组
//        int arr[][] = new int[2][];
//        arr[0] = new int[]{0, 1, 2, 3};
//        arr[1] = new int[]{4, 5, 6, 7};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.println(arr[i][j]);
//            }
//        }

//        Test_Student ts = new Test_Student(3,"abc");
    }

    static float average(int[] a) {
        float sum = 0;
        float av = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        av = sum / a.length;
        return av;
    }

    static int isExist(int n, int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (n == a[i]) {
                return i;
            }
        }
        return -1;
    }

    static int[] bubble(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t;
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return a;
    }

    static int[] conBubble(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int t;
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return a;
    }

    static int min(int n) {
        int a = n / 1000;
        int b = n / 100 % 10;
        int c = n / 10 % 10;
        int d = n % 10;
//        System.out.println(a + " " + b + " " + c + " " + d);
        int arr[] = {a, b, c, d};

//        int arr1[] = conBubble(arr);
//        for (int i = 0; i < arr.length; i++) { System.out.println("arr:"+arr[i]); }
//        for (int i = 0; i < arr.length; i++) { System.out.println("arr1:"+arr1[i]); }
//        int arr2[] = bubble(arr);
//        for (int i = 0; i < arr.length; i++) { System.out.println("arr:"+arr[i]); }
//        for (int i = 0; i < arr.length; i++) { System.out.println("arr1:"+arr1[i]); }
//        for (int i = 0; i < arr.length; i++) { System.out.println("arr2:"+arr2[i]); }
//        int n1 = arr1[0] *1000 + arr1[1] *100+ arr1[2] *10+ arr1[3];
//        System.out.println("n1:" + n1);
//        int n2 = arr2[0] * 1000 + arr2[1] * 100 + arr2[2] * 10 + arr2[3];
//        System.out.println("n2:" + n2);

        arr = bubble(arr);
        int n1 = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
        int n2 = arr[3] * 1000 + arr[2] * 100 + arr[1] * 10 + arr[0];

        n = n2 - n1;
        return n;
    }

    static int blackHole(int n) {
        int bh = n;
        for (int i = 1; i <= 7; i++) {
            bh = min(bh);
            System.out.println("第" + i + "次计算结果是" + bh);
            if (bh == 6174) {
                return i;
            }
        }
        return n;
    }
}