public class test_yanghuiTriangle {

    public static void main(String[] args) {
        int n = 6;
        int a[][] = new int[n][n];
//        a[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 | j == i) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }
                System.out.print(a[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }
}
