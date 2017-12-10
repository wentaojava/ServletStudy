package jdbcUtil;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class connectSQL implements Serializable {
	//创建连接变量
	private static BasicDataSource ds;
	//读取配置文件
	static {
		Properties properties=new Properties();
		try {
			properties.load(connectSQL.class.getClassLoader().getResourceAsStream("DB.properties"));
			String driverStr=properties.getProperty("driverStr");
			String connStr=properties.getProperty("connStr");
			String dbUserName=properties.getProperty("dbUserName");
			String dbPassword=properties.getProperty("dbPassword");
			String initsize=properties.getProperty("initsize");
			String maxsize=properties.getProperty("maxsize");
			ds=new BasicDataSource();
			ds.setDriverClassName(driverStr);
			ds.setUrl(connStr);
			ds.setUsername(dbUserName);
			ds.setPassword(dbPassword);
			ds.setInitialSize(new Integer(initsize));
			ds.setMaxActive(new Integer(maxsize));	
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败",e);
		}
	}
	//创建连接
	public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
	//关闭连接
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
            	conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("归还连接失败",e);
            }
        }
    }
    
    //回滚事务
    public static void rollBack(Connection conn){
        if(conn!=null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("回滚事务失败！",e);
            }
        }
    }

	

}
