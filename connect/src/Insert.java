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
	public void UserLoginSingup(List<String> user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_user = "insert into user values(?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_user);
			pt.setString(1, user.get(0));
			pt.setString(2, user.get(1));
			pt.setString(3, user.get(2));
			pt.setString(4, user.get(2));
			
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
	public void OwnerLoginSingup(List<String> owner) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_owner = "insert into owner values (?,?,?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_owner);
			pt.setString(1, owner.get(0));
			pt.setString(2, owner.get(1));
			pt.setString(3, owner.get(2));
			pt.setString(4, owner.get(3));
			pt.setString(5, owner.get(4));
			pt.setString(6, owner.get(5));
			
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
	public void MenuInsert(List<String> menu) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_menu = "insert into menu (ownerid, menuname, price, foodimg) values (?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_menu);
			
			pt.setString(1, menu.get(0));
			pt.setString(2, menu.get(1));
			pt.setInt(3, Integer.parseInt(menu.get(2)));
			pt.setString(4, menu.get(3));
			
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
	public void cart(int menuid, String userid, int count, int price) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.32.138:3306/pj2db", "pj2","111111"); // JDBC 연결
			System.out.println("DB 연결 완료");
		
			String insert_cart = "insert into cart (menuid, userid, count, total, date) "
					+ "values (?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(insert_cart);
			
			pt.setInt(1, menuid);
			pt.setString(2, userid);
			pt.setInt(3, count);
			pt.setInt(4, count*price);
			pt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			
			pt.executeUpdate(); // SQL 실행
            System.out.println("데이터 삽입 완료");

            conn.close();
            System.out.println("연결 해제");

        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}

	// 주문하기
	public void storder(int menuid, String ownerid, List<String> cart) {
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
				menu.add(rs.getString("menuname"));
				menu.add(rs.getString("price"));
			}
			System.out.println("메뉴 정보 가지고 옴");
			
			String insert_storder = "insert storder into "
					+ "(ownerid, menuname, price, count, total, checked, date) "
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement pt2 = conn.prepareStatement(insert_storder);
			pt2.setString(1, ownerid);
			pt2.setString(2, menu.get(0));
			pt2.setInt(3, Integer.parseInt(menu.get(1)));
			pt2.setInt(4, Integer.parseInt(cart.get(2)));
			pt2.setInt(5, Integer.parseInt(cart.get(3)));
			pt2.setString(6, "yet");
			pt2.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			
			pt2.executeUpdate(); // SQL 실행
			System.out.println("데이터 삽입 완료");
			
			conn.close();
        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
	
	// 주문하기
	public void receipt(int menuid, String userid,String storename, List<String> cart) {
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
				menu.add(rs.getString("menuname"));
				menu.add(rs.getString("price"));
				menu.add(rs.getString("menuimg"));
			}
			System.out.println("메뉴 정보 가지고 옴");
			
			String insert_storder = "insert receipt into "
					+ "(userid, storename, menuname, menuimg, count, price, total, date) "
					+ "values (?,?,?,?,?,?,?,?)";
			PreparedStatement pt2 = conn.prepareStatement(insert_storder);
			pt2.setString(1, userid);
			pt2.setString(2, storename);
			pt2.setString(3, menu.get(0));
			pt2.setString(4, menu.get(2));
			pt2.setInt(5, Integer.parseInt(cart.get(2)));
			pt2.setInt(6, Integer.parseInt(menu.get(1)));
			pt2.setInt(7, Integer.parseInt(cart.get(3)));
			pt2.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			
			pt2.executeUpdate(); // SQL 실행
			System.out.println("데이터 삽입 완료");
			
			conn.close();
        } catch (Exception e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
	}
}
