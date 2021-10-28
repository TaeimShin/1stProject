package project1.ver09;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PhoneBookManager extends IConnectImpl
{
	
	public PhoneBookManager()
	{
		super("kosmo","1234");
	}

	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택:");
	}
	
	public void dataInput() {
		
		System.out.println("데이터 입력을 시작합니다..");
		Scanner scan = new Scanner(System.in);
		//////쿼리문
		String sql = "INSERT INTO phonebook_tb VALUES "
				+ "(?,?,?)";
		
		try {
		psmt = con.prepareStatement(sql);
		psmt.setString(1, scanValue("이름"));
		psmt.setString(2, scanValue("전화번호"));
		psmt.setString(3, scanValue("생일"));
		
	
		int row = psmt.executeUpdate();
		
		System.out.println("데이터 입력이 완료되었습니다.");
		}
		catch(SQLException e) {
			System.out.println("데이터입력시 오류발생");
			e.printStackTrace();
		}
	}
	
	
	public void dataSearch() {
		
		System.out.println("데이터 검색을 시작합니다..");
		
		try {
			Statement stmt = con.createStatement();
			
			String searchName = scanValue("검색할이름");
			//////쿼리문
			String sql = "SELECT name, phone, birth "
					+ "FROM phonebook_tb WHERE name  "
					+ "LIKE '%" +searchName + "%'";
			
			//System.out.println("쿼리문:"+ sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("이름  전화번호  생일");
			while(rs.next()) {
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String birth = rs.getString(3);
				
			System.out.printf("%s %s %s\n", name, phone, birth);
			}
			
		}
		catch(Exception e) {
			System.out.println("select오류");
			e.printStackTrace();
		}

	}
	
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		
		
		try { ////쿼리문
			String sql = "DELETE FROM phonebook_tb WHERE name=?";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, scanValue("이름"));
			int affected = psmt.executeUpdate();
			System.out.println("데이터 삭제 완료");
		}
		catch(Exception e) {
			System.out.println("delete오류");
			e.printStackTrace();
		}
		
	}
	public void dataAllShow() {
		try {
			Statement stmt = con.createStatement();
			
			///쿼리문
			String sql = "SELECT name, phone, birth "
					+ "FROM phonebook_tb ";
					
			
			//System.out.println("쿼리문:"+ sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("이름  전화번호  생일");
			while(rs.next()) {
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String birth = rs.getString(3).substring(0,10);
				
			System.out.printf("%s %s %s\n", name, phone, birth);
			}
			System.out.println("");
			
		}
		catch(Exception e) {
			System.out.println("select오류");
			e.printStackTrace();
		}
	}
	
	public void terminate() {
		close();
	}
}
