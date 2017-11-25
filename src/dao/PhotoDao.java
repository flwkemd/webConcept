package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector2;
import vo.PhotoVo;

public class PhotoDao {
	private static PhotoDao single = null;

	private PhotoDao() {
	}

	public static PhotoDao getInstance() {
		if (single == null) {
			single = new PhotoDao();
		}
		return single;
	}

	public List<PhotoVo> selectList() {
		List<PhotoVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from photo order by idx desc";
		
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhotoVo vo = new PhotoVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setFilename(rs.getString("filename"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
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
		}
		
		return list;
	}

	public void insert(PhotoVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into photo(title,pwd,filename,ip) values(?,?,?,?)";
		try {
			conn = DBConnector2.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getFilename());
			pstmt.setString(4, vo.getIp());
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
		}
	}
	
}
