import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class UpdateInformation {
	// user 정보 수정
	public void UpdateUser(List<String> user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_user = "update user set pwd = ?, adress = ?, name = ? where userid = ?";
			PreparedStatement pt = conn.prepareStatement(update_user);
			pt.setString(1, user.get(1));
			pt.setString(2, user.get(2));
			pt.setString(3, user.get(3));
			pt.setString(4, user.get(0));
			
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
	public void UpdateOwner(List<String> owner) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_owner = "update user set"
					+ " pwd = ?, adress = ?, name = ?, storename = ?, storeimg = ?, category = ?"
					+ " where userid = ?";
			PreparedStatement pt = conn.prepareStatement(update_owner);
			pt.setString(1, owner.get(1));
			pt.setString(2, owner.get(2));
			pt.setString(3, owner.get(3));
			pt.setString(4, owner.get(4));
			pt.setString(5, owner.get(5));
			pt.setString(6, owner.get(6));
			pt.setString(7, owner.get(0));
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// user 돈 충전
	public void AddUserMoney(String userid, int money) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_user_money = "update user set money = ? where userid = ?";
			PreparedStatement pt = conn.prepareStatement(insert_user_money);
			pt.setInt(1, money);
			pt.setString(2, userid);
			
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
	public void UpdateMenu(List<String> menu) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_menu = "update menu set "
					+ "menuname =?, price=?, menuimg =? "
					+ "where menuid = ?";
			PreparedStatement pt = conn.prepareStatement(update_menu);
			pt.setString(1, menu.get(1));
			pt.setInt(2, Integer.parseInt(menu.get(2)));
			pt.setString(3, menu.get(3));
			pt.setInt(4, Integer.parseInt(menu.get(0)));
			
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 장바구니 개수 수정
	public void UpdateCartCount(int cartid, int count) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_count = "update cart set count = ? where cartid = ?";
			PreparedStatement pt = conn.prepareStatement(update_count);
			pt.setInt(1, count);
			pt.setInt(2, cartid);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 주문완료
	public void ChangeCheck(String orderid, String checked) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String update_check = "update storeder set checked = ? where orderid = ?";
			PreparedStatement pt = conn.prepareStatement(update_check);
			pt.setString(1, checked);
			pt.setString(2, orderid);
			
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
