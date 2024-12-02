import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Insert {
	// user 회원가입
	public void UserLoginSingup(String userid, String pwd, String adress, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_user = "insert into user values(?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_user);
			pt.setString(1, userid);
			pt.setString(2, pwd);
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
	
	// owner 회원가입
	public  void OwnerLoginSingup(String ownerid, String pwd, String adress, String name, String storename) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_owner = "insert into owner values (?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_owner);
			pt.setString(1, ownerid);
			pt.setString(2, pwd);
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
	
	// 메뉴 추가 
	public void MenuInsert(String ownerid, String menuname, int price, String foodimg) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_menu = "insert into menu (ownerid, menuname, price, foodimg) values (?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_menu);
			
			pt.setString(1, ownerid);
			pt.setString(2, menuname);
			pt.setInt(3, price);
			pt.setString(4, foodimg);
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 장바구니 담기
	public void cart(int menuid, String userid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_cart = "insert into cart (menuid, userid, date) values (?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_cart);
			
			pt.setInt(1, menuid);
			pt.setString(2, userid);
			pt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	public void storder(int menuid, int cartid, int count) {
		List<String> menu = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
			String selectMenu = "select * from menu where menuid = ?";
			PreparedStatement pt = conn.prepareStatement(selectMenu);
			pt.setInt(1, menuid);
			
			ResultSet rs = pt.executeQuery();
			
			if(rs.next()) {
				menu.add(rs.getString("menuid"));
				menu.add(rs.getString("ownerid"));
				menu.add(rs.getString("menuname"));
				menu.add(rs.getString("price"));		
			}
			System.out.println("메뉴 정보 가지고 옴");
			
			String insert_storder = "insert storder into (cartid, menu, price, count, checked, date) values (?,?,?,?,?,?)";
			PreparedStatement pt2 = conn.prepareStatement(insert_storder);
			pt2.setInt(1, cartid);
			pt2.setInt(2, Integer.parseInt(menu.get(0)));
			pt2.setInt(3, Integer.parseInt(menu.get(3)));
			pt2.setInt(4, count);
			pt2.setString(5, "oo");
			pt2.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
			
			pt2.executeUpdate(); // SQL 실행
			System.out.println("데이터 삽입 완료");
			
			conn.close();
        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
}