package Util;

import com.oracle.tools.packager.Log;

import java.io.*;

/**
 *
 * @author oirving
 */
public class FileIO {
    /**
     *      * @param args
     *      * @throws IOException
     *     
     */
    //更新名字
    public static void updateNameByName(String exName, String newName) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[0].equals(exName)) {
                    splits[0] = newName;
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //更新年龄
    public static void updateAgeByName(String name, String age) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[0].equals(name)) {
                    splits[1] = age;
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //更新年龄
    public static void updateAgeByAge (String exAge, String age) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[1].equals(exAge)) {
                    splits[1] = age;
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //按年龄更新名字
    public static void updateNameByAge (String name, String age) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[1].equals(age)) {
                    splits[0] = name;
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //删除匹配行
    public static void delete(String name, String age) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[0].equals(name)) {
                    continue; //不写入缓冲区，就不会存入了
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //根据名字删除匹配行
    public static void deleteByName(String name) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[0].equals(name)) {
                    continue; //不写入缓冲区，就不会存入了
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //根据年龄删除匹配行
    public static void deleteByAge(String age) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[1].equals(age)) {
                    continue; //不写入缓冲区，就不会存入了
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("未更新成功");
        }
    }

    //表查询查询
    public static String[] select (int selectType) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        String userInfo[] = new String[0];
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                switch (selectType) {
                    case 0:
                        userInfo = insert(userInfo,splits[0]+","+splits[1]);
                        break;
                    case 1:
                        userInfo = insert(userInfo,splits[0]);
                        break;
                    case 2:
                        userInfo = insert(userInfo,splits[1]);
                        break;
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("查询成功");
        }
        return userInfo;
    }

    //根据名字查询
    public static String[] selectByName (String name,int selectType) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        String userInfo[] = new String[0];
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[0].equals(name)) {
                    switch (selectType) {
                        case 0://查询全部
                            userInfo = insert(userInfo,splits[0]+","+splits[1]);
                            break;
                        case 1://查询名字
                            userInfo = insert(userInfo,splits[0]);
                            break;
                        case 2://查询年龄
                            userInfo = insert(userInfo,splits[1]);
                            break;
                    }
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("查询成功");
        }
        return userInfo;
    }

    //根据年龄查询
    public static String[] selectByAge (String age, int selectType) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        String line;
        String userInfo[] = new String[0];
        try {
            fileInputStream = new FileInputStream("src/UserInfo.txt"); //定义输入文件
            fileOutputStream = new FileOutputStream("src/UserInfo2.txt"); //定义输出文件
            inputStreamReader = new InputStreamReader(fileInputStream); //读取输入文件
            outputStreamWriter = new OutputStreamWriter(fileOutputStream); //写入文件
            bufferedReader = new BufferedReader(inputStreamReader); //读入缓冲
            bufferedWriter = new BufferedWriter(outputStreamWriter); //输出缓冲
            while ((line = bufferedReader.readLine()) != null) {
                String[] splits = line.split("&");
                if (splits[1].equals(age)) {
                    switch (selectType) {
                        case 0:
                            userInfo = insert(userInfo,splits[0]+","+splits[1]);
                            break;
                        case 1:
                            userInfo = insert(userInfo,splits[0]);
                            break;
                        case 2:
                            userInfo = insert(userInfo,splits[1]);
                            break;
                    }
                }
                String returnInfo = splits[0] + "&" + splits[1] + "\n";
                bufferedWriter.write(returnInfo);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            copyFile("src/UserInfo2.txt", "src/UserInfo.txt");
        } catch (Exception e) {
            Log.debug("查询成功");
        }
        return userInfo;
    }

    //从临时文件复制到源文件
    private static void copyFile(String source, String dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    //往字符串数组追加新数据
    private static String[] insert(String[] arr, String str) {
        int size = arr.length;  //获取数组长度
        String[] tmp = new String[size + 1];  //新建临时字符串数组，在原来基础上长度加一
        for (int i = 0; i < size; i++){  //先遍历将原来的字符串数组数据添加到临时字符串数组
            tmp[i] = arr[i];
        }
        tmp[size] = str;  //在最后添加上需要追加的数据
        return tmp;  //返回拼接完成的字符串数组
    }
}
