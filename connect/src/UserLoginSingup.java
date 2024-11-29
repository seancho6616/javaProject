import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginSingup {
	public UserLoginSingup(String id, String pw, String adress, String name) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String sql_login = "insert into user values(?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(sql_login);
			pt.setString(1, id);
			pt.setString(2, pw);
			pt.setString(3, adress);
			pt.setString(4, name);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}	
	static public void main(String[] args) {
		String id = "kimjm";
		String pw = "111111";
		String adress = "오산";
		String name = "김재민";
		
		new UserLoginSingup(id, pw, adress, name);
		
	}
}