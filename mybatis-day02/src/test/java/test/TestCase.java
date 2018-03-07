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
		
		//调用SqlSession对象提供的方法访问数据库
		//第一个参数：Mapper中的sql的id
		Employee e=new Employee();
		e.setEname("wwww");
		e.setJob("tttt");
		session.insert("test.save",e);
		//添加，修改，删除都需要提交事务
		session.commit();
		//关闭SqlSession
		session.close();
	}

	@Test
	public void test2() {
		List<Employee> el=session.selectList("test.findAll");
		System.out.println(el);
		session.close();
	}
	
	@Test
	public void test3() {
		emp e=session.selectOne("test.findById3",2);
		System.out.println(e);
		session.close();
	}
}
