package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import util.DBConnector2;
import vo.VisitVo;

public class VisitDao {

	private static VisitDao single = null;
	public SqlSessionFactory factory;
	
	private VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static VisitDao getInstance() {
		if (single == null) {
			single = new VisitDao();
		}
		return single;
	}

	public List<VisitVo> selectList(Map<String, String> map) {
		List<VisitVo> list = new ArrayList<>();
		SqlSession ss = factory.openSession();
		list = ss.selectList("visit.selectList", map);
		
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from visit order by idx desc";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}*/
		
		
		ss.close();
		return list;
	}

	public void insert(VisitVo vo) {
		int res = 0;
		SqlSession ss = factory.openSession();
		res = ss.insert("visit.insert", vo);
		if(res == 1) {
			ss.commit();
		}
		ss.close();
		
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into visit(name, content, ip, pwd, regdate)"+
						"values(?,?,?,?,curdate())";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getIp());
			pstmt.setString(4, vo.getPwd());
			
			int count = pstmt.executeUpdate();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}*/
		
	}

	public void delete(int idx) {
		int res = 0;
		SqlSession ss = factory.openSession(true);
		res = ss.delete("visit.delete", idx);
		ss.close();
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from visit where idx=?";

		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			int count = pstmt.executeUpdate();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}*/
		
	}

	public VisitVo selectOne(int idx) {
		VisitVo vo = new VisitVo();
		SqlSession ss = factory.openSession();
		vo = ss.selectOne("visit.selectOne",idx);
		ss.close();
		
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from visit where idx=?";

		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setContent(rs.getString("content"));
			vo.setIp(rs.getString("ip"));
			vo.setPwd(rs.getString("pwd"));
			vo.setRegdate(rs.getString("regdate"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
		return vo;
	}

	public void update(VisitVo vo) {
		int res=0;
		SqlSession ss = factory.openSession();
		res = ss.update("visit.update", vo);
		if(res==1) {
			ss.commit();
		}
		
		ss.close();
		
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update visit set name=?, content=?, pwd=? where idx=?";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setInt(4, vo.getIdx());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}*/
		
		
	}
		
}
