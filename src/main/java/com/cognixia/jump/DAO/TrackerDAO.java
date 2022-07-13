package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.ConnectionManager.ConnectionManager;
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
			pstmt.setInt(1, bookID);

			rs = pstmt.executeQuery();

			if (rs != null) {
				rs.next();

				tracker = new Tracker();
				tracker.setUserID(rs.getInt(1));
				tracker.setBookID(rs.getInt(2));
				tracker.setProgressStatus(rs.getString(3));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tracker;
	}

	@Override
	public boolean create(Tracker entity) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";

		// Will insert new tracker when a user adds a new book to its list.
		try {
			query = "INSERT INTO tracker (userID, bookID, progressStatus)\r\n" + "VALUES (?, ?, \"Not started\")";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, entity.getUserID());
			pstmt.setInt(2, entity.getBookID());

			int numInserts = pstmt.executeUpdate();

			if (numInserts > 0) {
				System.out.println("Tracker " + entity + " added to db.");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(Tracker entity) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		Tracker tracker = null;

		// Will insert new tracker when a user adds a new book to its list.
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
		return true;

	}

	@Override
	public boolean update(Tracker entity) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";

		try {
			query = "UPDATE tracker SET progressStatus = ? WHERE userID = ? AND bookID = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, entity.getProgressStatus());
			pstmt.setInt(2, entity.getUserID());
			pstmt.setInt(2, entity.getBookID());

			int numUpdates = pstmt.executeUpdate();

			if (numUpdates > 0) {
				System.out.println("Tracker " + entity + " updated.");
				return true;
			}

		} catch (Exception e) {
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

		try {
			query = "SELECT * FROM progressTracker";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Tracker tracker = new Tracker();
				tracker.setUserID(rs.getInt(1));
				tracker.setBookID(rs.getInt(2));

				trackerList.add(tracker);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return trackerList;
	}

}
