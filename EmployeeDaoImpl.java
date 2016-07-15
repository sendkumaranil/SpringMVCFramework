package com.springmvcexample.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.CallableStatementCreator;

import com.springmvcexample.dao.EmployeeDao;
import com.springmvcexample.model.Department;
import com.springmvcexample.model.Employee;
import com.springmvcexample.model.Role;
import com.springmvcexample.model.User;
import com.springmvcexample.model.UserRoleMapping;
import com.springmvcexample.util.DepartmentMapper;
import com.springmvcexample.util.EmployeeMapper;
import com.springmvcexample.util.RoleMapper;
import com.springmvcexample.util.UserMapper;
import com.springmvcexample.util.UserRoleMapper;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		String sql="select "
				+ "emp.empid,emp.empname,emp.birthdate,emp.joindate,"
				+ "emp.idtype,emp.idno,emp.email,emp.mobileno,"
				+ "emp.deptid,dept.dept_name "
				+ "from test.myemployee emp left outer join test.department dept "
				+ "on emp.deptid=dept.department_id";
		List<Employee> employeeList=getJdbcTemplate().query(sql,new EmployeeMapper());
		return employeeList;
	}

	@Override
	public Employee getEmployeeProfile(int empid) {
		String sql="select "
				+ "emp.empid,emp.empname,emp.birthdate,emp.joindate,"
				+ "emp.idtype,emp.idno,emp.email,emp.mobileno,"
				+ "emp.deptid,dept.dept_name "
				+ "from test.myemployee emp left outer join test.department dept "
				+ "on emp.deptid=dept.department_id where emp.empid=?";
		Employee emp=getJdbcTemplate().queryForObject(sql, new Object[]{empid}, new EmployeeMapper());
		return emp;
	}

	@Override
	public void addEmployee(Employee employee) {
		String sql="insert into myemployee(empname, birthdate, joindate, idtype, idno, email, mobileno,deptid)values(?,?,?,?,?,?,?,?)";
		Object[] args={
				employee.getEmpname(),
				employee.getDob(),
				employee.getDoj(),
				employee.getIdtype(),
				employee.getIdno(),
				employee.getEmailid(),
				employee.getMobileno(),
				employee.getDeptid()
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
		String sql="update test.myemployee set birthdate=?,joindate=?,idtype=?,idno=?,email=?,mobileno=?,deptid=? where empid=?";
		Object[] args={
				employee.getDob(),
				employee.getDoj(),
				employee.getIdtype(),
				employee.getIdno(),
				employee.getEmailid(),
				employee.getMobileno(),
				employee.getDeptid(),
				employee.getEmpid()
				
		};
		getJdbcTemplate().update(sql,args);
	}

	@Override
	public void addUser(User user) {
		String sql="insert into userdetails(username,password,emailid)values(?,?,?)";
		Object[] args={
				user.getUsername(),
				user.getPassword(),
				user.getEmailid()
		};
		getJdbcTemplate().update(sql,args);
	}

	@Override
	public void addRole(Role role) {
		String sql="insert into roledetails(role_name)values(?)";
		Object[] args={
				role.getRolename()
		};
		getJdbcTemplate().update(sql,args);
		
	}

	@Override
	public List<User> getUsers() {
		String sql="select * from userdetails";
		List<User> userList=getJdbcTemplate().query(sql,new UserMapper());
		return userList;
	}

	@Override
	public List<Role> getRoles() {
		String sql="select * from roledetails";
		List<Role> roleList=getJdbcTemplate().query(sql,new RoleMapper());
		return roleList;
	}

	@Override
	public void assignRoleToUser(int userid, int roleid) {
		
		SqlParameter InParam_userid=new SqlParameter(Types.BIGINT);
		SqlParameter InParam_roleid=new SqlParameter(Types.BIGINT);
		List<SqlParameter> parameters=new ArrayList<SqlParameter>();
		parameters.add(InParam_userid);
		parameters.add(InParam_roleid);
		
		getJdbcTemplate().call(new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection conn) throws SQLException {
				CallableStatement callStmnt=conn.prepareCall("{call assignRoleToUser(?,?)}");
				callStmnt.setLong(1, userid);
				callStmnt.setLong(2, roleid);
				
				return callStmnt;
			}
		}, parameters);
		
	}

	@Override
	public List<UserRoleMapping> getMappedUsers() {
		String sql="select user.username,role.role_name,user_role.mappingid,user.emailid from test.userdetails user "
				+ "inner join test.user_role user_role on user.userid=user_role.userid "
				+ "inner join test.roledetails role on role.roleid=user_role.roleid";
		List<UserRoleMapping> mappedUsersList=getJdbcTemplate().query(sql,new UserRoleMapper());
		return mappedUsersList;
	}

	@Override
	public String removeMappedUsers(UserRoleMapping userRoleMap) {
		String sql="delete from user_role where mappingid=?";
		getJdbcTemplate().update(sql, new Object[]{userRoleMap.getMappingid()});
		return "SUCCESS";
	}

	@Override
	public void resetPassword(User user) {
		String sql="update userdetails set password=? where username=?";
		getJdbcTemplate().update(sql, new Object[]{user.getPassword(),user.getUsername()});
	}

	@Override
	public boolean isValidUser(User user) {
		String sql="select count(1) from userdetails where username=?";
		int isValidUser=getJdbcTemplate().queryForInt(sql,new Object[]{user.getUsername()});
		if(isValidUser > 0){
			return true;
		}
		return false;
	}

	@Override
	public void changePassword(User user) {
		String sql="update userdetails set password=? where username=?";
		getJdbcTemplate().update(sql, new Object[]{user.getPassword(),user.getUsername()});	
	}

	@Override
	public String getRegisteredEmailid(User user) {
		String sql="select * from userdetails where username=?";
		List<User> userList=getJdbcTemplate().query(sql,new Object[]{user.getUsername()},new UserMapper());
		User regUser=userList.get(0);
		return regUser.getEmailid();
	}

	@Override
	public List<Department> getDepartments() {
		
		String sql="select * from department";
		List<Department> deptList=getJdbcTemplate().query(sql,new DepartmentMapper());
		return deptList;
	}
}
