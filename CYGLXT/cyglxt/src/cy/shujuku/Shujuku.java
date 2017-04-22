package cy.shujuku;
import java.util.*;
import java.sql.*;

public class Shujuku 
{
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	String url="jdbc:odbc:sql serve";
	String user="sa";
	String passwd="ydyd4488321";
	
	public Shujuku()
	{
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {}
	}
	public ResultSet query(String sql,String []paras)
	{
		try {
			ps=ct.prepareStatement(sql);

			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			
			rs=ps.executeQuery();
		} catch (Exception e) {}
		
		return rs;
	}
	public void close()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {}
	}
}
