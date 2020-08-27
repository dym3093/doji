package com.dayton.doji.practice.designpattern.template.v2;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 数据库操作类
 * @author Martin Deng
 * @since 2020-08-27 21:38
 */
public class MemberDao extends JdbcTemplate{

	public MemberDao(DataSource dataSource) {
		super(dataSource);
	}

	public List<?> selectAll(){
		String sql = "select * from t_member";
		return super.executeQuery(sql, (rs, rowNum) ->
				Member.builder()
				.username(rs.getString(Member.USERNAME))
				.password(rs.getString(Member.PASSWORD))
				.nickName(rs.getString(Member.NICK_NAME))
				.age(rs.getInt(Member.AGE))
				.address(rs.getString(Member.ADDRESS))
				.build(),null);
	}

}
