import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Select {
	// 가게 이름 가지고 오기
	public List<String> SelectStores(){
		List<String> stores = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
			String select_stores = "select storename from owner";
			PreparedStatement pt = conn.prepareStatement(select_stores);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				stores.add(rs.getString("storename"));
			}
			conn.close();
			System.out.println("연결해제");
		}catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return stores;
	}
	// user들 id 가져오기
	public List<String> SelectUsers(){
		List<String> users = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
			String select_users = "select userid from user";
			PreparedStatement pt = conn.prepareStatement(select_users);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				users.add(rs.getString("userid"));
			}
			conn.close();
			System.out.println("연결해제");
		}catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return users;
	}
	// owner들 id 가져오기
	public List<String> SelectOwners(){
		List<String> owners = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
			String select_owners = "select ownerid from owner";
			PreparedStatement pt = conn.prepareStatement(select_owners);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				owners.add(rs.getString("ownerid"));
			}
			conn.close();
			System.out.println("연결해제");
		}catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return owners;
	}
	// 해당 가게 메뉴와 가격 가지고 오기 리스트에 배열로 해서
	public List<String[]> SelectMenu(String ownerid){
		List<String[]> menu = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","1111"); // JDBC 연결
			System.out.println("DB 연결 완료");
			String select_owners = "select menuname, price from menu where ownerid = ?";
			PreparedStatement pt = conn.prepareStatement(select_owners);
			pt.setString(1, ownerid);
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				String[] menu2 = {rs.getString("menuname"), rs.getString("price")};
				menu.add(menu2);
			}
			conn.close();
			System.out.println("연결해제");
		}catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return menu;
	}
}

