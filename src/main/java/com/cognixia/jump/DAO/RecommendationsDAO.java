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

public class RecommendationsDAO implements DAO<UserPreferences> {

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

	public List<String> findPrefs(int id) throws SQLException {

		List<String> recs = new ArrayList<String>();
		PreparedStatement prep = null;
		ResultSet rs = null;
		UserPreferences pref = null;

		String sql = "SELECT * FROM user_preferences WHERE user_id = ?";

		try {
			prep = conn.prepareStatement(sql);
			prep.setLong(1, id);

			rs = prep.executeQuery();

			while (rs.next()) {
				if (rs.getRow() == 0) {
					throw new RecordNotFoundException("No preferences found");
				}

				pref = new UserPreferences();
				pref.setUserID(rs.getInt(1));
				pref.setGenre(rs.getString(2));

				recs.add(pref.getGenre());

			}

		} catch (RecordNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
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

	public List<Book> createRecList(int id) throws SQLException {

		List<String> prefs = findPrefs(id);
		List<Book> recs = new ArrayList<Book>();

		if (prefs.isEmpty()) {
			System.out.println("No recommendations.");
			return recs;
		}
		List<Book> builderList = bookDAO.findByGenre(prefs.get(0));

		// Making assumption that user preferences listed first are their top
		// preferences
		switch (prefs.size()) {
		case 1:

			recs.addAll(builderList);

			break;
		case 2:

			for (int i = 0; i < 5; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(1));

			for (int i = 0; i < 5; i++) {
				recs.add(builderList.get(i));
			}

			break;
		case 3:

			for (int i = 0; i < 4; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(1));

			for (int i = 0; i < 3; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(2));

			for (int i = 0; i < 3; i++) {
				recs.add(builderList.get(i));
			}

			break;
		case 4:

			for (int i = 0; i < 3; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(1));

			for (int i = 0; i < 3; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(2));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(3));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			break;
		case 5:

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(1));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(2));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(3));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}
			builderList = bookDAO.findByGenre(prefs.get(4));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			break;
		case 6:

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(1));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(2));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(3));

			for (int i = 0; i < 2; i++) {
				recs.add(builderList.get(i));
			}

			builderList = bookDAO.findByGenre(prefs.get(4));

			recs.add(builderList.get(0));

			builderList = bookDAO.findByGenre(prefs.get(5));

			recs.add(builderList.get(0));

			break;

		default:
			System.out.println("No preferences listed.");
			break;
		}

		return recs;
	}

	@Override
	public List<UserPreferences> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
