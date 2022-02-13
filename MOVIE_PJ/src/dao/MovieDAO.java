package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dto.MovieVO;

public class MovieDAO {
	private ArrayList<MovieVO> dtos2;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MovieDAO() {
		dtos2 = new ArrayList<MovieVO>();
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@cyzhsss.iptime.org:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	public ArrayList<MovieVO> getAllMovie() {
		dtos2 = new ArrayList<MovieVO>();
		String SQL = "select * from movie";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String title = rs.getString("title");
				int age_limit=rs.getInt("age_limit");
				String movie_time=rs.getString("movie_time");
				int seat=rs.getInt("seat");
				int reserved=rs.getInt("reserved");
				String id=rs.getString("id");
				MovieVO VO = new MovieVO(title,age_limit,movie_time,seat,reserved,id);
				dtos2.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}

	public ArrayList<MovieVO> UpdateMovieReserved(String title, String timeSelect, int seatchoice,String loginID) {
		String SQL = "update movie set reserved=1,id=? where title=? and movie_time=TO_DATE(?,'HH24:MI:SS') and seat=?";
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, loginID);
			pstmt.setString(2, title);
			pstmt.setString(3, timeSelect);
			pstmt.setInt(4, seatchoice);
			pstmt.executeUpdate();
			System.out.println("예매가 완료되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}
}
