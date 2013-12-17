import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Connection connection;
	static final String JDBC_DRIVER = "org.sqlite.JDBC";  
	static final String DB_URL = "jdbc:sqlite:data.db";
	private String SQL;
	
	//-------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Database() throws Exception{
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL);
	}
	
	//----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	public void executeSQL(String SQL) throws SQLException{
		this.setSQL(SQL);
		Statement statement = connection.createStatement();
		statement.execute(SQL);
	}

	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public String getSQL() {
		return SQL;
	}

	public void setSQL(String sql) {
		this.SQL = sql;
	}
}
