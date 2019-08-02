package ProcessSQLStatement.SqlParserFactory;

import ProcessSQLStatement.SqlParser.*;
import ProcessSQLStatement.SqlParser.SqlParserAbstract.BaseSingleSqlParser;
import ProcessSQLStatement.SqlParserBefore.SqlParserUtil;


public class SingleSqlParserFactory {
	public static BaseSingleSqlParser generateParser(String originalSql, String processedSql)
	{//区分sql语句类型
	    if(SqlParserUtil.contains(processedSql,"select")) {
	        return new SelectSqlParser(originalSql,processedSql);
	    }
	    else if(SqlParserUtil.contains(processedSql,"delete")) {
	        return new DeleteSqlParser(originalSql,processedSql);
	    }
	    else if(SqlParserUtil.contains(processedSql,"update")) {
	        return new UpdateSqlParser(originalSql,processedSql);
	    }
	    //sql=sql.replaceAll("ENDSQL", "");
	    else
			return null;
	        //return new InsertSqlParser(originalSql,processedSql);
	       //throw new NoSqlParserException(sql.replaceAll("ENDOFSQL", ""));//对异常的抛出
	}

}
