package pt.alkart.idemanager.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import pt.alkart.idemanager.main.IdeManagerInt;
import pt.alkart.idemanager.objects.Idea;

public class IdeManager_MYSQL implements IdeManagerInt<Object> {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Override
	public boolean start() {

		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");

		// Setup the connection with the DB
		connect = DriverManager
				.getConnection("jdbc:mysql://db.tecnico.ulisboa.pt/ist170407?"
						+ "user=ist170407&password=xqay4449");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean end() {
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Object buildIdea(Idea ide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addIdea(Idea ide) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeIdea(Idea ide) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Idea> listIdeas() {
		return null;
		// TODO Auto-generated method stub

	}

}
