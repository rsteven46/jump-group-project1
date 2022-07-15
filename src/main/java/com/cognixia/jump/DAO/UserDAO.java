package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognixia.jump.ConnectionManager.ConnectionManager;
import com.cognixia.jump.Exceptions.RecordNotFoundException;
import com.cognixia.jump.model.User;

public class UserDAO implements DAO<User> {

	Connection conn = ConnectionManager.getConnection();

	@Override
	public List<User> findAll() {

		return null;
	}

	@Override
	public boolean create(User entity) {

		return false;
	}

	@Override
	public boolean remove(User entity) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public int verifyUser(User entity) throws RecordNotFoundException {
		PreparedStatement prep = null;
		ResultSet rs = null;
		String SQL = "SELECT * from user where username=? and passwd=?";

		try {
			prep = conn.prepareStatement(SQL);
			prep.setString(1, entity.getUsername());
			prep.setString(2, entity.getPassword());

			rs = prep.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			rs.close();
			prep.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
