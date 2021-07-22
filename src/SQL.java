import java.sql.*;
public class SQL
{
	Connection con;

	public Connection getConnect()
	{
            try
            {
		
                /////////////////////////////////******for sql server******/////////////////////////////////
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  		con=DriverManager.getConnection("jdbc:odbc:Medplus","sa","admin");
            }
            catch(ClassNotFoundException | SQLException e)
            {
            	System.out.println(e);
            }
            return con;
	}

	public int  exeUpdate(String sql)
	{
            int flag=0;
            try
            {
            	Statement st=getConnect().createStatement();
            	st.executeUpdate(sql);
  		flag=1;
            }
            catch(SQLException e)
            {
            	System.out.println(e);
            }
            return flag;
	}

	public ResultSet exeQuery(String sql)
	{
            ResultSet rs=null;
            try
            {
            	Statement st=getConnect().createStatement();
            	rs=st.executeQuery(sql);
            }
            catch(SQLException e)
            {
            	System.out.println(e);
            }
            return(rs);
	}
}
