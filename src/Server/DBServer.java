package Server;

import Bean.Table;
import ProcessSQLStatement.SQLObject.SQLObject;
import ProcessSQLStatement.SqlParserBefore.SqlParserUtil;
import Util.FileIO;
import com.oracle.tools.packager.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBServer {
    public static void main(String[] args) throws Exception {
        //指定监听端口
        int port = 1521;
        java.net.ServerSocket server = new java.net.ServerSocket(port);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        //使用一个死循环达到即时响应请求的要求
        while (true) {
            Socket socket = server.accept();
            //开一个线程接收消息
            Runnable runnable = ()->{
                InputStream inputStream = null;
                try {
                    //接收客户端的消息
                    inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while ((len = inputStream.read(bytes)) != -1) {
                        sb.append(new String(bytes,0,len,"UTF-8"));
                    }
                    System.out.println("get massage from client: " + sb.toString());

                    String testSql= sb.toString();	//需要解析的sql语句
                    SqlParserUtil test=new SqlParserUtil();	//SQL语句解析工具类
                    SQLObject sqlObjectObj = test.getParsedSql(testSql);	//得到解析SQL语句后的类型对象

                    //发送给客户端的消息
                    OutputStream outputStream = socket.getOutputStream();
                    System.out.println(sqlObjectObj.getTableName());
                    if (Table.isExist(sqlObjectObj.getTableName())) { //判断表是否存在
                        String[] retUserInfo = new String[0];
                        String attribute = ""; //查询条件
                        String value = ""; //条件值
                        String[] conditions = DeclearCondition(sqlObjectObj.getCondition().toString());
                        if (conditions.length > 1 ) {
                            attribute = conditions[1];
                            value = conditions[2];
                        }
                        switch (sqlObjectObj.getTypeName()){//从操作入手
                            case "select" :
                                if (conditions.length > 1) { //存在查询条件
                                    switch (attribute) {
                                        case "name" : //按名字查询
                                            switch (sqlObjectObj.getField()) {
                                                case "*":
                                                    retUserInfo = FileIO.selectByName(value,0);
                                                    System.out.println("name0");
                                                    break;
                                                case "name,age" :
                                                    retUserInfo = FileIO.selectByName(value,0);
                                                    System.out.println("name0");
                                                    break;
                                                case "age,name" :
                                                    retUserInfo = FileIO.selectByName(value,0);
                                                    System.out.println("name0");
                                                    break;
                                                case "age" :
                                                    retUserInfo = FileIO.selectByName(value,2);
                                                    System.out.println("name2");
                                                    break;
                                            }
                                        case "age" : //按年龄查询
                                            switch (sqlObjectObj.getField()) {
                                                case "name" :
                                                    retUserInfo = FileIO.selectByAge(value,1);
                                                    System.out.println("age1");
                                                    break;
                                                case "*":
                                                    retUserInfo = FileIO.selectByAge(value,0);
                                                    System.out.println("age0");
                                                    break;
                                                case "name,age" :
                                                    retUserInfo = FileIO.selectByAge(value,0);
                                                    System.out.println("age0");
                                                    break;
                                                case "age,name" :
                                                    retUserInfo = FileIO.selectByAge(value,0);
                                                    System.out.println("age0");
                                                    break;
                                            }
                                    }
                                } else { //整张表查询
                                    switch (sqlObjectObj.getField()) {
                                        case "name" :
                                            retUserInfo = FileIO.select(1);
                                            break;
                                        case "*":
                                            retUserInfo = FileIO.select(0);
                                            break;
                                        case "name,age" :
                                            retUserInfo = FileIO.select(0);
                                            break;
                                        case "age,name" :
                                            retUserInfo = FileIO.select(0);
                                            break;
                                        case "age" :
                                            retUserInfo = FileIO.select(2);
                                            break;
                                    }
                                }
                            case "update" :
                                String[] fields = DeclearField(sqlObjectObj.getField());
                                if (conditions.length > 1) { //存在查询条件
                                        if (attribute.equals("name")) {//按名字更新
                                            for (int i=0 ;i<fields.length ; i++) {
                                                if (i%2 == 0) {
                                                    switch (fields[i]) {
                                                        case "name":
                                                            FileIO.updateNameByName(value,fields[i+1]);
                                                            System.out.println("updateNameByName"+attribute);
                                                            break;
                                                        case "age":
                                                            FileIO.updateAgeByName(value,fields[i+1]);
                                                            System.out.println("updateAgeByName"+attribute);
                                                            break;
                                                    }
                                                }
                                            }
                                        }
                                    if (attribute.equals("age")) {//按年龄更新
                                        for (int i=0 ;i<fields.length ; i++) {
                                            if (i%2 == 0) {
                                                switch (fields[i]) {
                                                    case "name":
                                                        FileIO.updateNameByAge(fields[i+1],value);
                                                        System.out.println("updateNameByAge"+attribute);
                                                        break;
                                                    case "age":
                                                        FileIO.updateAgeByAge(value,fields[i+1]);
                                                        System.out.println("updateAgeByAge"+attribute);
                                                        break;
                                                }
                                            }
                                        }
                                    }
                                    }
                            case "delete" :
                                if (conditions.length > 1) { //存在查询条件
                                    switch (attribute) {
                                        case "age" :
                                            FileIO.deleteByAge(value);
                                            break;
                                        case "name" :
                                            FileIO.deleteByName(value);
                                            break;
                                    }
                                }
                        }
                        for (int i = 0; i<retUserInfo.length ; i++) {
                            System.out.println(retUserInfo[i]);
                            outputStream.write((retUserInfo[i]+"\n").getBytes("UTF-8"));
                        }
                    } else {
                        outputStream.write("表不存在".getBytes("UTF-8"));
                    }
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("查询失败！");
                }
            };
            threadPool.submit(runnable);
        }
    }

    //解析条件
    public static String[] DeclearCondition(String condition) {
        String regEx="[{}'',]";//可以在中括号内加上任何想要替换的字符
        String aa = "";//这里是将特殊字符换为aa字符串,""代表直接去掉
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(condition);//这里把想要替换的字符串传进来
        String newString = m.replaceAll(aa).trim();
        String[] conditions =  newString.split("=");
        return conditions;
    }

    //解析条件
    public static String[] DeclearField(String condition) {
        String regEx="['']";//可以在中括号内加上任何想要替换的字符
        String aa = "";//这里是将特殊字符换为aa字符串,""代表直接去掉
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(condition);//这里把想要替换的字符串传进来
        String newString = m.replaceAll(aa).trim();
        String[] fields =  newString.split(",");
        for (int i = 0; i < fields.length ;i++) {
            System.out.println("***"+fields[i]);
        }
        return fields;
    }
}
