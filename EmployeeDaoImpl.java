package com.springmvcexample.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.springmvcexample.dao.EmployeeDao;
import com.springmvcexample.model.Employee;
import com.springmvcexample.util.EmployeeMapper;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		String sql="select * from myemployee";
		List<Employee> employeeList=getJdbcTemplate().query(sql,new EmployeeMapper());
		return employeeList;
	}

	@Override
	public Employee getEmployeeProfile(int empid) {
		String sql="select * from myemployee where empid=?";
		Employee emp=getJdbcTemplate().queryForObject(sql, new Object[]{empid}, new EmployeeMapper());
		return emp;
	}

	@Override
	public void addEmployee(Employee employee) {
		String sql="insert into myemployee(empname, birthdate, joindate, idtype, idno, email, mobileno)values(?,?,?,?,?,?,?)";
		Object[] args={
				employee.getEmpname(),
				employee.getDob(),
				employee.getDoj(),
				employee.getIdtype(),
				employee.getIdno(),
				employee.getEmailid(),
				employee.getMobileno()
		};
		
		getJdbcTemplate().update(sql,args);
	}

	@Override
	public void deleteEmployee(int empid) {
		String sql="delete from myemployee where empid=?";
		getJdbcTemplate().update(sql, new Object[]{empid});
	}

	@Override
	public void editEmployee(Employee employee) {
		String sql="update myemployee set birthdate=?,joindate=?,idtype=?,idno=?,email=?,mobileno=? where empid=?";
		Object[] args={
				employee.getDob(),
				employee.getDoj(),
				employee.getIdtype(),
				employee.getIdno(),
				employee.getEmailid(),
				employee.getMobileno(),
				employee.getEmpid()
		};
		getJdbcTemplate().update(sql,args);
	}
}
