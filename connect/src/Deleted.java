import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deleted {
	// user 정보 삭제
	public void DeletedUser(String userid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String deleted_user = "delete from user where userid = ?";
			PreparedStatement pt = conn.prepareStatement(deleted_user);
			pt.setString(1, userid);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삭제 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	//owner 정보 삭제
	public void DeletedOwner(String ownerid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String deleted_owner = "delete from owner where ownerid = ?";
			PreparedStatement pt = conn.prepareStatement(deleted_owner);
			pt.setString(1, ownerid);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삭제 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 메뉴 정보 삭제
	public void DeletedMenu(String ownerid, int menuid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String deleted_menu = "delete from menu where ownerid = ? and menuid = ?";
			PreparedStatement pt = conn.prepareStatement(deleted_menu);
			pt.setString(1, ownerid);
			pt.setInt(2, menuid);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삭제 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 카트 정보 삭제
	public void DeletedCart(String userid, int menuid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String deleted_cart = "delete from cart where userid = ? and menuid = ?";
			PreparedStatement pt = conn.prepareStatement(deleted_cart);
			pt.setString(1, userid);
			pt.setInt(2, menuid);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삭제 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
}
