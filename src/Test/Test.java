package Test;


import ProcessSQLStatement.SQLObject.SQLObject;
import ProcessSQLStatement.SqlParserBefore.SqlParserUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	    public static void main(String[] args) {
			String a1 = "update userinfo set name = '欧文才' where age = 21";
			SqlParserUtil test=new SqlParserUtil();	//SQL语句解析工具类
	        SQLObject sqlObjectObj = test.getParsedSql(a1);	//得到解析SQL语句后的类型对象

			String regEx="[{}'']";//可以在中括号内加上任何想要替换的字符
			String aa = "";//这里是将特殊字符换为aa字符串,""代表直接去掉
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(sqlObjectObj.getField());//这里把想要替换的字符串传进来
			String newString = m.replaceAll(aa).trim();
			String[] condition =  newString.split("=");

			for (int i = 0; i < condition.length ;i++) {
				System.out.println(condition[i]);
			}
	        sqlObjectObj.PrintToString();	//打印出来
		 }

}
