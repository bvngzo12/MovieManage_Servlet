package com.ssafy.sample.model.dao;

import java.sql.SQLException;

import com.ssafy.sample.dto.Member;

public interface MemberDao {
	Member login(String id, String pw) throws SQLException;
}
