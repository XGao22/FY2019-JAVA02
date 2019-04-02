/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-03-27 19:05
 **/
public class Test_String {
    public static void main(String[] args) {
        String diy0 = "ABCDefg123";
        String diy1 = "abcdefgabcdefgab";
        String str = "ab";
//        findUpAndLowChar(diy0);
//        findString(diy1, str);
//        equalString("abcdefg", " abdefg");
//        upperAndFind("jdk");
//        strReverse("To be or not to be");
        strFindName("name=zhangshan age=18 class=131014");
    }

    public static void findUpAndLowChar(String diy) {

        /**
         * @Description: 找出字符串中的大写字母、小写字母和非字母字符，分别输出
         * @Param: [diy]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/27 0027
         */
        byte[] stringByte = diy.getBytes();
        StringBuffer sbUpper = new StringBuffer();
        StringBuffer sbLower = new StringBuffer();
        StringBuffer sbElse = new StringBuffer();
        for (int i = 0; i < stringByte.length; i++) {
            if (stringByte[i] >= 65 && stringByte[i] <= 90) {
                sbUpper.append((char) stringByte[i]);
            } else if (stringByte[i] >= 97 && stringByte[i] <= 122) {
                sbLower.append((char) stringByte[i]);
            } else {
                sbElse.append((char) stringByte[i]);
            }
        }
        System.out.println("大写字母有：" + sbUpper + "  小写字母有：" + sbLower + "  非字母字符有：" + sbElse);

    }

    public static void findString(String diy, String str) {

        /**
         * @Description:
         * @Param: [diy, str]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/28 0028
         */
        int fromIndex = 0;
        int index = 0;
        int sum = 0;
        do {
            index = diy.indexOf(str, fromIndex);
            if (index != -1) {
                sum++;
                fromIndex = index + 1;
            }
        } while (index != -1);
        System.out.println(sum);
    }

    public static void equalString(String str1, String str2) {

        /**
         * @Description:
         * @Param: [str1, str2]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/28 0028
         */
        byte strByte1[] = str1.getBytes();
        byte strByte2[] = str2.getBytes();
        if (strByte1.length == strByte2.length) {
            for (int i = 0; i < strByte1.length; i++) {
                if (strByte1[i] == strByte2[i]) {
                    if (i == strByte1.length - 1) {
                        System.out.println("相同");
                    }
                    continue;
                } else {
                    System.out.println("第" + i + "个字符不相同！！！");
                    break;
                }
            }
        } else {
            System.out.println("长度不相同！！！");
        }
    }

    public static void upperAndFind(String strToUpper) {
        String strUpper = strToUpper.toUpperCase();
        System.out.println(strUpper);
        String strFind = strUpper.substring(1);
        System.out.println(strFind);
    }

    public static void strReverse(String str) {
        String[] sr = str.split(" ");
        for (int i = 0; i < sr.length; i++) {
            StringBuffer sb = new StringBuffer(sr[i]);
            System.out.print(" " + sb.reverse());
        }
        System.out.print(".");
    }

    public static void strFindName(String str) {
        String sr[] = str.split(" ");
        for (int i = 0; i < sr.length; i++){
            String sr1[] = sr[i].split("=");
            StringBuffer sb = new StringBuffer(sr1[1]);
            System.out.print(sb+" ");
        }
    }
}



