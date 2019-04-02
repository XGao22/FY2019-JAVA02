import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-01 09:21
 **/
public class Test_Data {
    public static void main(String[] args){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse("2016-03-20 20:09:32");
            long ts = date.getTime();
            System.out.println(ts);
        } catch (ParseException e) {
            return;
        }

        long ls = 1458475772000L;
        String dateTime = simpleDateFormat.format(new Date( ls));
        System.out.println(dateTime);

    }
}
