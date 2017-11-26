package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DepartmentVo;

public class DepartmentDao {
	private static DepartmentDao single = null;
	SqlSessionFactory factory;
	
	
	private DepartmentDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static DepartmentDao getInstance() {
		if (single == null) {
			single = new DepartmentDao();
		}
		return single;
	}

	public List<DepartmentVo> selectList(){
		List<DepartmentVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("department.selectList");
		
		return list;
	}
}
