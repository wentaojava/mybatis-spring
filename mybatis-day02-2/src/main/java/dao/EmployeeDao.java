/**
 * 
 */
package dao;

import java.util.List;

import entity.Employee;

/**
 * Mapper映射器
 * @author wentao
 */
public interface EmployeeDao {
	
	public void save(Employee e);
	
	List<Employee> findAll();

}
