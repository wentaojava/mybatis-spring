/**
 * 
 */
package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDao;
import entity.Employee;
import entity.emp;

/**
 * 
 * @author wentao
 */
public class TestCase {
	
	private SqlSession session;
	@Before
	public void init() {
		String config="SqlMapConfig.xml";
		//创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//创建sqlSessionFactory对象
		SqlSessionFactory ssf=ssfb.build(TestCase.class.getClassLoader().getResourceAsStream(config));
		//获得SqlSession对象
		 session=ssf.openSession();
	}
	
	@Test
	public void test1() {
		EmployeeDao dao=session.getMapper(EmployeeDao.class);
		Employee e=new Employee();
		e.setEname("aaaaa");
		e.setJob("bbbb");
		dao.save(e);
		session.commit();
		session.close();
	}
	@Test
	public void test2() {
		EmployeeDao dao=session.getMapper(EmployeeDao.class);
		List<Employee> ls=dao.findAll();
		System.out.println(ls);
		session.commit();
		session.close();
		
	}
}
