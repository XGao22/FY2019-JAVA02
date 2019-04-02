import java.io.*;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-02 16:03
 **/
public class Test_FileIO {
    public static void main(String[] args) {
        fileInput();
    }

    public static void fileInput() {
        int result = 0;
        InputStream is = null;
        OutputStream os = null;
        File file = new File("D:/testFileIo2.txt");
        try {
            is = new FileInputStream("D:/testFileIo.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            os = new FileOutputStream(file,false);
            while ((result = is.read() )!= -1) {
                os.write(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void fileOutput(String str) {

    }
}
