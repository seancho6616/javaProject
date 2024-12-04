import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Select {
	// user 정보 가지고 오기
	public static  List<String> SelectUser(String id) {
		List<String> infor = new ArrayList<String>();
		try {
			Connection conn = DBconnecter.getConnection();
			System.out.println("DB 연결");
			
			String select_id = "select * from user where userid = ?";
			PreparedStatement pt = conn.prepareStatement(select_id);
			pt.setString(1, id);
			ResultSet rs = pt.executeQuery();
			
			if(rs.next()) {
				infor.add(rs.getString("userid"));
				infor.add(rs.getString("pwd"));
				infor.add(rs.getString("adress"));
				infor.add(rs.getString("name"));
				infor.add(rs.getString("money"));
			}
			System.out.println(infor);
			conn.close();
			System.out.println("연결해제");
		}catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return infor;
	}
	// user들 id 가져오기
	public List<String> SelectUsers(){
		List<String> users = new ArrayList<String>();
		try {
			Connection conn = DBconnecter.getConnection();
			System.out.println("DB 연결");
			
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
	
	// owner 정보 가지고 오기
	public static List<String> SelectOwner(String id){
		List<String> infor = new ArrayList<String>();
		try {
			Connection conn = DBconnecter.getConnection();
			System.out.println("DB 연결");
			
			String select_id = "select * from owner where ownerid = ?";
			PreparedStatement pt = conn.prepareStatement(select_id);
			pt.setString(1, id);
			ResultSet rs = pt.executeQuery();
			
			if(rs.next()) {
				infor.add(rs.getString("ownerid"));
				infor.add(rs.getString("pwd"));
				infor.add(rs.getString("adress"));
				infor.add(rs.getString("name"));
				infor.add(rs.getString("storename"));
				infor.add(rs.getString("storeimg"));
				infor.add(rs.getString("category"));
			}
			conn.close();
			System.out.println("연결해제");
		}catch (Exception e) {
			System.out.println("DB 연결 오류");
		}
		return infor;
	}
	
	// owner들 id 가져오기
	public List<String> SelectOwners(){
		List<String> owners = new ArrayList<String>();
		try {
			Connection conn = DBconnecter.getConnection();
			System.out.println("DB 연결");
			
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

	// 가게들 이름 가지고 오기
	public List<String> SelectStores(){
		List<String> stores = new ArrayList<String>();
		try {
			Connection conn = DBconnecter.getConnection();
			System.out.println("DB 연결");
			
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
	
	// 해당 가게 메뉴와 가격 가지고 오기 리스트에 배열로 해서
	public List<String[]> SelectMenu(String ownerid){
		List<String[]> menu = new ArrayList<>();
		try {
			Connection conn = DBconnecter.getConnection();
			System.out.println("DB 연결");
			
			String select_owners = "select menuid, menuname, price from menu where ownerid = ?";
			PreparedStatement pt = conn.prepareStatement(select_owners);
			pt.setString(1, ownerid);
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				String[] menu2 = {rs.getString("menuid"), rs.getString("menuname"), 
						rs.getString("price"), rs.getString("menuimg")};
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

