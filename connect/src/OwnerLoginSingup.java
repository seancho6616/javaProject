import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OwnerLoginSingup {
	public OwnerLoginSingup(String id, String pw, String adress, String name, String storename) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_owner = "insert into owner values (?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_owner);
			pt.setString(1, id);
			pt.setString(2, pw);
			pt.setString(3, adress);
			pt.setString(4, name);
			pt.setString(5, storename);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
}
