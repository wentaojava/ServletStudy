package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import Entity.Emp;
import jdbcUtil.connectSQL;

public class EmpDao implements Serializable {
	
	public List<Emp> findAll(){
		//存储员工信息
		List<Emp> list=new ArrayList<Emp>();
		//建立连接
		Connection conn1=null;
		try {
			conn1=connectSQL.getConnection();
			conn1.setAutoCommit(false);//设置关闭自动commit
			String findEmp="SELECT * FROM EMPS";
			PreparedStatement smt=conn1.prepareStatement(findEmp);
			ResultSet rs=smt.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setName(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setSal(rs.getFloat("sal"));
				list.add(e);
			}
			conn1.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connectSQL.rollBack(conn1);
		}finally{
			connectSQL.closeConnection(conn1);;
			
		}
			
		return list;
	}
	
	public void saveEmp(Emp emp){
		//建立连接
				Connection conn2=null;
				try {
					conn2=connectSQL.getConnection();
					conn2.setAutoCommit(false);//设置关闭自动commit
					String saveEmp="INSERT INTO EMPS(ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) "
							+ "VALUES(?,?,?,?,?,?,?)";
					PreparedStatement smt=conn2.prepareStatement(saveEmp);
					smt.setString(1, emp.getName());
					smt.setString(2, emp.getJob());
					smt.setInt(3, 0);
					smt.setDate(4,new Date(System.currentTimeMillis()));
					smt.setFloat(5, emp.getSal());
					smt.setFloat(6, 4500);
					smt.setInt(7, 3);
					smt.executeUpdate();
					conn2.commit();
				} catch (SQLException e) {
					e.printStackTrace();
					connectSQL.rollBack(conn2);
				}finally{
					connectSQL.closeConnection(conn2);;
				}
		
	}

}
