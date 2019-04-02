import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-02 14:08
 **/
public class Test_BinarySearch {
    public static void main(String[] args) {

        int m = 5;
        int arr[] = {4, 8, 5, 3, 9, 5, 7};

        testBinarySearch(arr, m);
    }

    public static void testBinarySearch(int arr[], int m) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        int x= 0;
        int y= arr.length-1;
        int k = (x+y)/2;

        while (x<=y){
            if (arr[k]>m){

            }else if (arr[k]<m){

            }else {
                System.out.println("OK!");
                return;
            }
        }
        System.out.println("不OK!");
    }

}


