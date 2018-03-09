/**
 * 
 */
package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDao;
import entity.Employee;

/**
 * 
 * @author wentao
 */
public class TestCase {
	@Test
	public void test1() {
		String config="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		EmployeeDao dao=ac.getBean("empDao",EmployeeDao.class);
		List<Employee> employees=dao.findAll();
		System.out.println(employees);
	}

}
