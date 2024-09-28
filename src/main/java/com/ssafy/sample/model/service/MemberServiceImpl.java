package com.ssafy.sample.model.service;

import com.ssafy.sample.model.dao.*;
import java.sql.SQLException;

import com.ssafy.sample.dto.Member;

public class MemberServiceImpl implements MemberService {
	MemberDao memberDao = new MemberDaoImpl();
	@Override
	public Member login(String id, String pw) throws SQLException {
		return memberDao.login(id, pw);
	}

}
