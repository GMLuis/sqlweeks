package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Make;
import entity.Model;

public class ModelDao {
	
	private Connection connection;
	private final String GET_MODEL_BY_MAKE_ID_QUERY = "SELECT * FROM model where model_make = ?";
	private final String GET_MODEL_BY_ID = "SELECT * FROM model WHERE id = ?";
	private final String CREATE_NEW_MODEL = "INSERT INTO model(model_name) VALUES(?)";
	private final String DELETE_MODEL_BY_ID = "DELETE FROM model WHERE id = ?";
	
	public ModelDao() {
		connection = DbConnection.getConnection();
	}
	
	public List<Model> getModelByMake(int makeid) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_MODEL_BY_MAKE_ID_QUERY);
		ps.setInt(1, makeid);
		ResultSet rs = ps.executeQuery();
		List<Model> models = new ArrayList<Model>();
		
		while (rs.next()) {
			models.add(new Model(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
	
		return models;
	}
	public List<Model> getModelById() throws SQLException {
		ResultSet rs = connection .prepareStatement(GET_MODEL_BY_ID).executeQuery();
		List<Model> models = new ArrayList<Model>();
		
		while (rs.next()) {
			models.add(new Model(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
	
		return models;
	}
	public void createModel(String modelName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MODEL);
		ps.setString(1, modelName);
		ps.executeUpdate();
	}

	public void deleteModelById(int iD) throws SQLException {
	PreparedStatement ps = connection.prepareStatement(DELETE_MODEL_BY_ID);
	ps.setInt(1,iD);
	ps.executeUpdate();
		
	}
}
