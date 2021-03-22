package survey.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import survey.dto.SurveyDTO;

public class DatabaseServiceImpl implements DatabaseService {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jwoo";
	String pwd = "1234";

	public DatabaseServiceImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertData(SurveyDTO dto) {
		String sql = "INSERT INTO servey(place, age, gender) VALUES(?,?,?)";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getPlace());
			ps.setInt(2, dto.getAge());
			ps.setInt(3, dto.getGender());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<SurveyDTO> selectdata() {
		String sql = "select * from servey";
		ArrayList<SurveyDTO> list = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SurveyDTO dto = new SurveyDTO();
				dto.setAge(rs.getInt("age"));
				dto.setGender(rs.getInt("gender"));
				dto.setPlace(rs.getInt("place"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
}
