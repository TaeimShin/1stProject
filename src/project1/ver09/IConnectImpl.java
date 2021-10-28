package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IConnectImpl implements IConnect{
	
	public Connection con;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public IConnectImpl() {
		System.out.println("기본 생성자 호출");
	}
	
	
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user,pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	

	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL,user,pass);
			
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void execute() {
	
	}
	
	
	@Override
	public void close() {
		try {
			if(psmt!= null) psmt.close();
			if(con!=null) con.close();
			if(rs!=null) rs.close();
			System.out.println("자원반납완료");
		}
		catch(Exception e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}

	
	@Override
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.print(title+"을 입력:");
		String inputStr = scan.nextLine();
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0);// 프로그램 자체를 즉시 종료시킴.
		}
		return inputStr;
	}
	
}
