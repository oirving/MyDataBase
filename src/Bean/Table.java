package Bean;

import com.oracle.tools.packager.Log;

import java.io.*;

public class Table {
    public static void main(String[] args) {
        if (isExist("UserInfo")) {
            System.out.println("表存在");
        }
    }

    public static Boolean isExist (String tableName) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        String line;
        String userInfo[] = new String[0];
        Boolean flag = false;
        try {
            fileInputStream = new FileInputStream("src/Tables.txt"); //定义输入文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[0].equals(tableName)) {
                    flag = true;
                    break;
                }
            }
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            Log.debug("表"+tableName+"不存在");
        }
        return flag;
    }
}
