package com.dayton.doji.practice.designpattern.template.v2;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin Deng
 * @since 2020-08-27 21:28
 */
@Slf4j
public class JdbcTemplate {

	private DataSource dataSource;

	public JdbcTemplate(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[]
			values){
		try {
			// 获取链接
			Connection conn = this.getConnection();
			// 创建语句集
			PreparedStatement pstm = this.createPreparedStatement(conn, sql);
			// 执行语句集
			ResultSet rs = this.executeQuery(pstm, values);
			// 处理结果集
			List<?> result = this.parseResultSet(rs, rowMapper);
			// 关闭结果集
			this.closeResultSet(rs);
			// 关闭语句集
			this.closeStatement(pstm);
			// 关闭连接
			this.closeConnection(conn);
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	protected void closeConnection(Connection conn) throws Exception{
		// 不关闭数据库连接池
		conn.close();
	}

	protected void closeStatement(PreparedStatement pstm) throws Exception{
		pstm.close();
	}

	private void closeResultSet(ResultSet rs) throws Exception{
		rs.close();
	}

	protected List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper)
			throws Exception{
		List<Object> result = new ArrayList<>();
		int rowNum = 1;
		while (rs.next()){
			result.add(rowMapper.mapRow(rs, rowNum++));
		}
		return result;
	}

	protected ResultSet executeQuery(PreparedStatement pstm, Object[] values)
		throws Exception{
		for (int i = 0; i < values.length; i++) {
			pstm.setObject(i, values[i]);
		}
		return pstm.executeQuery();
	}

	protected PreparedStatement createPreparedStatement(Connection conn,
												String sql) throws Exception{
		return conn.prepareStatement(sql);
	}

	public Connection getConnection() throws Exception{
		return this.dataSource.getConnection();
	}

}
