package cy.moxing;
import java.sql.*;
//import sun.java2d.pipe.SpanClipRenderer;
import cy.shujuku.*;

public class Moxing {
	
	public String checkUser(String cleId,String passwd)
	{
		String zhiwei="";
		Shujuku sh=null;
		try {
			String sql="select cleZw from clerkInfo c,login l where c.cleId=l.cleId " +
			"and l.cleId=? and l.passwd=?";
			String paras[]={cleId,passwd};
			sh=new Shujuku();
			ResultSet rs=sh.query(sql, paras);
			if(rs.next())
			{
				zhiwei=rs.getString(1);
			}
		} catch (Exception e) {}
		finally 
		{
			sh.close();
		}
		return zhiwei;
	}
}
