package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	@Override
	public Member login(String id, String pw) throws SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "select member_id as id, member_pass as pw, member_name as name from members where member_id = ? and member_pass = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		ResultSet rs = pstmt.executeQuery();
		Member mem = null;
		
		if(rs.next()) {
			String mid = rs.getString("id");
			String mpw = rs.getString("pw");
			String name = rs.getString("name");
			
			mem = new Member(mid,mpw,name);
		}
		return mem;
	}

}
