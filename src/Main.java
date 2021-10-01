import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		Connection con = null;
		
		String dbFile="myfirst.db";
		try {
			//check SQlite JDBC
			Class.forName("org.sqlite.JDBC");
			//connect with SQLite database file
			con=DriverManager.getConnection("jdbc:sqlite:"+dbFile);
			//query the data
			System.out.println("\n***데이터 조회***");
			Statement stat1=con.createStatement();
			String spl1="select * from g_artists";
			ResultSet rs1=stat1.executeQuery(spl1);
			while(rs1.next()) {
				String id=rs1.getString("id");
				String name=rs1.getString("name");
				String regdate=rs1.getString("regdate");
				System.out.println(id+" "+name+" "+regdate);
			}
			stat1.close();
			/*
			//add a data
			System.out.println("\n***새 데이터 추가***");
			for(int i=0;i<5;i++) {
				System.out.print("\n가수명:");
				String name=s.nextLine();
				System.out.print("\n성별:");
				String a_type=s.next();
				s.nextLine();
				System.out.print("\n활동시기:");
				String a_year=s.nextLine();
				System.out.print("\n데뷔년도:");
				String debut=s.next();
				s.nextLine();
				Statement stat2=con.createStatement();
				String sql2="insert into g_artists (name, a_type, a_year, debut, regdate)"
						+" values ('"+name+"','"+a_type+"','"+a_year+"','"+debut+"',datetime('now','localtime'));";
				int cnt=stat2.executeUpdate(sql2);
				if(cnt>0) {
					System.out.println("new data added");
				}else {
					System.out.println("Error:데이터 추가 오류~");
				}
				stat2.close();
			}
			
			//edit the data
			System.out.println("\n***데이터 수정***");
			Statement stat3=con.createStatement();
			String spl3="update g_artists set a_year='2000년대, 2010년대, 2020년대'"
					+"where id=1;";
			int cnt3=stat3.executeUpdate(spl3);
			if(cnt3>0) {
				System.out.println("데이터가 수정되었습니다!");
			}else {
				System.out.println("Error:데이터 수정 오류~");
			}
			stat3.close();
					
			//delete data
			System.out.println("\n***데이터 삭제***");
			Statement stat4=con.createStatement();
			String sql4="delete from g_artists where id=4";
			int cnt4=stat4.executeUpdate(sql4);
			if(cnt4>0) {
				System.out.println("success");
			}else {
				System.out.println("Error:데이터 삭제 오류~");
			}
			stat4.close();
			
			//query the data
			System.out.println("\n***데이터 조회***");
			stat1=con.createStatement();
			spl1="select * from g_artists";
			rs1=stat1.executeQuery(spl1);
			while(rs1.next()) {
				String id=rs1.getString("id");
				String name=rs1.getString("name");
				String a_year=rs1.getString("a_year");
				System.out.println(id+" "+name+" "+a_year);
			}
			stat1.close();
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
				
	}
}
