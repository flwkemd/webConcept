package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public ScoreVo selectOne(int code) {
		ScoreVo svo = new ScoreVo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from score where code=?";
		
		try {
			conn=DBConnector2.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
		
			rs.next();
			svo.setCode(rs.getInt("code"));
			svo.setName(rs.getString("name"));
			svo.setKorean(rs.getInt("korean"));
			svo.setEnglish(rs.getInt("english"));
			svo.setMath(rs.getInt("math"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return svo;
	}
	
	
	public void insert(ScoreVo svo) {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		//String sql = "insert into score(name, korean, english, math) values('"+svo.getName()+"',"+svo.getKorean()+","+svo.getEnglish()+","+svo.getMath()+")";
		String sql = "insert into score(name, korean, english, math) values(?,?,?,?)";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setInt(2, svo.getKorean());
			pstmt.setInt(3, svo.getEnglish());
			pstmt.setInt(4, svo.getMath());
			pstmt.executeUpdate();
			//stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from score where code = ?";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void update(ScoreVo svo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update score set name=?, korean=?, english=?, math=? where code = ?";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setInt(2, svo.getKorean());
			pstmt.setInt(3, svo.getEnglish());
			pstmt.setInt(4, svo.getMath());
			pstmt.setInt(5, svo.getCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
