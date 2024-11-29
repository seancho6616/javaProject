import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
	public int login(String id, String pw) {
		int result = 2;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.33.71:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
			String sql_login = "select * from user where userid = ?";
			PreparedStatement pt = conn.prepareStatement(sql_login);
			pt.setString(1, id);
			
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				String pwdb = rs.getString("pwd");
				if(pwdb.equals(pw)) {
					result = 0;
					
				}else {
					result = 1;
				}
			}else {
				result = 2;
			}
			conn.close();
			System.out.println("연결해제");
			
		} catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return result;
	}	
}