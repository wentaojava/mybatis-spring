/**
 * 
 */
package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import annotation.MyBatisRepository;
import entity.Employee;

/**
 * Mapper映射器
 * @author wentao
 */
@Repository("empDao")
@MyBatisRepository
public interface EmployeeDao {
	
	public void save(Employee e);
	
	List<Employee> findAll();

}
