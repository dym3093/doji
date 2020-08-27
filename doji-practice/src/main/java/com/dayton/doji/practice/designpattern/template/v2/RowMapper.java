package com.dayton.doji.practice.designpattern.template.v2;

import java.sql.ResultSet;

/**
 * @author Martin Deng
 * @since 2020-08-27 21:28
 */
public interface RowMapper<T> {

	T mapRow(ResultSet rs, int rowNum) throws Exception;

}
