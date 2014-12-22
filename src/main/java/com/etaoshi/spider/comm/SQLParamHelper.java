package com.etaoshi.spider.comm;

import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class SQLParamHelper {

	/**
	 * 替换'为''，防止拼sql参数出错
	 * 
	 * @param value
	 * @return
	 */
	public static String Replace(String value) {
		return value.replaceAll("'", "''");
	}

	/**
	 * 获得sql
	 * 
	 * @param db
	 *            通过它获取SqlMapClient
	 * @param param
	 *            sql里面的参数
	 * @param sqlName
	 *            Statement的ID
	 * @return
	 */
	public static String getCurrSql(SqlMapClient mapper, Object param, String sqlName) {
		String sql = null;
		SqlMapClientImpl sqlmap = (SqlMapClientImpl)mapper;
		MappedStatement stmt = sqlmap.getMappedStatement(sqlName);
		Sql stmtSql = stmt.getSql();

		SessionScope sessionScope = new SessionScope();
		sessionScope.incrementRequestStackDepth();
		StatementScope requestScope = new StatementScope(sessionScope);
		requestScope.setStatement(stmt);
		sql = stmtSql.getSql(requestScope, param);
		
		System.out.println(sql);
		return sql;
	}

	/**
	 * 获得sql
	 * 
	 * @param db
	 *            通过它获取SqlMapClient
	 * @param param
	 *            sql里面的参数
	 * @param sqlName
	 *            Statement的ID
	 * @return
	 */
	public static String getCurrSqlTwo(SqlMapClient mapper, Object param, String sqlName) {
		SqlMapExecutorDelegate delegate = ((ExtendedSqlMapClient) mapper).getDelegate();
		MappedStatement ms = delegate.getMappedStatement(sqlName);
		Sql sql = ms.getSql();
		
		SessionScope sessionScope = new SessionScope();
		sessionScope.incrementRequestStackDepth();
		StatementScope requestScope = new StatementScope(sessionScope);
		requestScope.setStatement(ms);
		String sqlStr = sql.getSql(requestScope, param);
		
		System.out.println(sqlStr);
		return sqlStr;
	}

}
