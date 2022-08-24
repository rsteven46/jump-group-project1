package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.ConnectionManager.ConnectionManager;
import com.cognixia.jump.Exceptions.RecordNotFoundException;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.User;
import com.cognixia.jump.model.UserPreferences;

public class RecommendationsDAO implements  DAO<UserPreferences> {
	
	BookDAO bookDAO = new BookDAO();

	Connection conn = ConnectionManager.getConnection();
	
	@Override
	public boolean create(UserPreferences entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(UserPreferences entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserPreferences entity) {
		// TODO Auto-generated method stub
		return false;
	}


	public List<String> findPrefs(User entity) throws SQLException {
		
		List<String> recs = new ArrayList<String>();
		PreparedStatement prep = null;
		ResultSet rs = null;
		UserPreferences pref = null;
		
		String sql = "SELECT * FROM user_preferences WHERE user_id = ?";
		
		try {
			prep = conn.prepareStatement(sql);
			prep.setLong(1, entity.getUserID());
			
			rs = prep.executeQuery();
			
			while(rs.next()) {
				if (rs.getRow() == 0) {
					throw new RecordNotFoundException("No preferences found");
				}
				
				pref = new UserPreferences();
				pref.setUserID(rs.getInt(1));
				pref.setGenre(rs.getString(2));
				
				recs.add(pref.getGenre());
				
			}
			
			
			
		}
		catch(RecordNotFoundException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			rs.close();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return recs;
	}
	
	public List<Book> createRecList(User entity) throws SQLException {
		
		List<String> prefs = findPrefs(entity);
		List<Book> recs = new ArrayList<Book>();
		
		for (String pref : prefs) {
			recs.addAll(bookDAO.findByGenre(pref));
		}
		
		
		return recs;
	}

	@Override
	public List<UserPreferences> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
