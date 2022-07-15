package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.ConnectionManager.ConnectionManager;
import com.cognixia.jump.Exceptions.RecordNotFoundException;
import com.cognixia.jump.model.Tracker;

public class TrackerDAO implements DAO<Tracker> {

	private Connection conn = ConnectionManager.getConnection();

	public Tracker findByCompositeId(int userID, int bookID) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		Tracker tracker = null;

		try {

			query = "SELECT * FROM tracker WHERE userID = ? AND bookID = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userID);
			pstmt.setInt(2, bookID);

			rs = pstmt.executeQuery();

			if (rs != null) {
				rs.next();

				tracker = new Tracker();
				tracker.setUserID(rs.getInt(1));
				tracker.setBookID(rs.getInt(2));
				tracker.setProgressStatus(rs.getString(3));

			} else
				throw new RecordNotFoundException("No tracker found");

		} catch (RecordNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tracker;
	}

	public List<Tracker> findByUserId(int userID) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		List<Tracker> trackerList = new ArrayList<>();

		try {

			query = "SELECT * FROM tracker WHERE userID = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userID);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				if (rs.getRow() == 0)
					throw new RecordNotFoundException("No tracker found");

				Tracker tracker = new Tracker();
				tracker.setUserID(rs.getInt(1));
				tracker.setBookID(rs.getInt(2));
				tracker.setProgressStatus(rs.getString(3));

				trackerList.add(tracker);

			}

		} catch (RecordNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trackerList;
	}

	@Override
	public boolean create(Tracker entity) {
		PreparedStatement pstmt = null;
		String query = "";
		int numInserts = 0;
		
		try {
			query = "INSERT INTO tracker (userID, bookID, progressStatus)\r\n" + "VALUES (?, ?, \"Not started\")";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, entity.getUserID());
			pstmt.setInt(2, entity.getBookID());

			numInserts = pstmt.executeUpdate();

			if (numInserts > 0) {
				System.out.println("Tracker " + entity + " added to db.");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean remove(Tracker entity) {

		PreparedStatement pstmt = null;
		String query = "";

		try {
			query = "DELETE FROM tracker WHERE userID = ? AND bookID = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, entity.getUserID());
			pstmt.setInt(2, entity.getBookID());

			pstmt.execute();

			System.out.println("Tracker " + entity + " removed.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;

	}

	public boolean remove(int userID, int bookID) {

		PreparedStatement pstmt = null;
		String query = "";

		try {
			query = "DELETE FROM tracker WHERE userID = ? AND bookID = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, userID);
			pstmt.setInt(2, bookID);

			pstmt.execute();

			System.out.println("Tracker removed.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;

	}

	@Override
	public boolean update(Tracker entity) {

		PreparedStatement pstmt = null;
		String query = "";
		int numUpdates = 0;

		try {
			query = "UPDATE tracker SET progressStatus = ? WHERE userID = ? AND bookID = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, entity.getProgressStatus());
			pstmt.setInt(2, entity.getUserID());
			pstmt.setInt(3, entity.getBookID());

			numUpdates = pstmt.executeUpdate();

			if (numUpdates > 0) {
				System.out.println("Tracker " + entity + " updated.");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Tracker> findAll() {

		List<Tracker> trackerList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		Tracker tracker = null;
		
		try {
			query = "SELECT * FROM progressTracker";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				if (rs.getRow() == 0)
					throw new RecordNotFoundException("No tracker found");

				tracker = new Tracker();
				tracker.setUserID(rs.getInt(1));
				tracker.setBookID(rs.getInt(2));

				trackerList.add(tracker);

			}

		} catch (RecordNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trackerList;

	}

}
