import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateInformation {
	// user 정보 수정
	public void UpdateUser(String id, String pw, String adress, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_user = "update user set pwd = ?, adress = ?, name = ? where userid = ?";
			PreparedStatement pt = conn.prepareStatement(update_user);
			pt.setString(1, pw);
			pt.setString(2, adress);
			pt.setString(3, name);
			pt.setString(4, id);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// owner 정보 수정
	public void UpdateOwner(String id, String pw, String adress, String name, String storename) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_owner = "update user set pwd = ?, adress = ?, name = ?, storename = ? where userid = ?";
			PreparedStatement pt = conn.prepareStatement(update_owner);
			pt.setString(1, pw);
			pt.setString(2, adress);
			pt.setString(3, name);
			pt.setString(4, storename);
			pt.setString(5, id);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 메뉴 정보 수정
	public void UpdateMenu(int menuid, String menuname, int price, String foodimg) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_owner = "update menu set menuname =?, price=?, foodimg =? where menuid = ?";
			PreparedStatement pt = conn.prepareStatement(update_owner);
			pt.setString(1, menuname);
			pt.setInt(2, price);
			pt.setString(3, foodimg);
			pt.setInt(4, menuid);
			
			
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
