package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Make;

public class MakeDao {
	
	private Connection connection;
	private ModelDao modelDao = new ModelDao();
	private final String GET_MAKE_QUERY = "SELECT * FROM make";
	private final String GET_MAKE_BY_ID = "SELECT * FROM make WHERE id = ?";
	private final String CREATE_NEW_MAKE_QUERY = "INSERT INTO make(make_name) VALUES(?)";
	private final String DELETE_MAKE_BY_ID = "DELETE FROM make WHERE id = ?";
	
	public MakeDao() {
		connection = DbConnection.getConnection();
	}
	
	public List<Make> getmake() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_MAKE_QUERY).executeQuery();
		List<Make> makes = new ArrayList<Make>();
		
		while (rs.next()) {
			makes.add(populateMake(rs.getInt(1), rs.getString(2)));
		}
		
		return makes;
	}
	
	public Make getMakeById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_MAKE_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateMake(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewMaker(String makeName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MAKE_QUERY);
		ps.setString(1, makeName);
		ps.executeUpdate();
	}
	
	public void deleteMakerById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_MAKE_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Make populateMake(int id, String name) throws SQLException{
		return new Make (id, name, modelDao.getModelByMake(id));
	}

}
