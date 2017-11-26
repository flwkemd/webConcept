package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.EmployeeVo;

public class EmployeeDao {
	private static EmployeeDao single = null;
	SqlSessionFactory factory;
	
	private EmployeeDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public static EmployeeDao getInstance() {
		if (single == null) {
			single = new EmployeeDao();
		}
		return single;
	}
	
	// ������
	public List<EmployeeVo> selectList(){
		List<EmployeeVo> list = null;
		
		//1.ó����ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2. �۾�����
		list = sqlSession.selectList("employee.selectList");
		
		sqlSession.close();
		
		return list;
	}
	
}
