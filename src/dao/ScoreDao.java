package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector2;
import vo.ScoreVo;

public class ScoreDao {
	private static ScoreDao single = null;

	private ScoreDao() {
	}

	public static ScoreDao getInstance() {
		if (single == null) {
			single = new ScoreDao();
		}
		return single;
	}
	
	public List<ScoreVo> selectList(){
		List<ScoreVo> scoreList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from score_view";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			stmt = conn.createStatement();
	
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			ScoreVo vo = new ScoreVo();
			vo.setCode(rs.getInt("code"));
			vo.setName(rs.getString("name"));
			vo.setKorean(rs.getInt("korean"));
			vo.setEnglish(rs.getInt("english"));
			vo.setMath(rs.getInt("math"));
			vo.setTotal(rs.getInt("total"));
			vo.setAverage(rs.getInt("average"));
			scoreList.add(vo);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		return scoreList;
	}
	
	public void insert(ScoreVo svo) {
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "insert into score(name, korean, english, math) values('"+svo.getName()+"',"+svo.getKorean()+","+svo.getEnglish()+","+svo.getMath()+")";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
