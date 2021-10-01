import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello..why..did..he..");
		
		Connection con = null;
		
		String dbFile="myfirst.db";
		try {
			//check SQlite JDBC
			Class.forName("org.splite.JDBC");
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
			
			//add a data
			System.out.println("\n***새 데이터 추가***");
			Statement stat2=con.createStatement();
			String sql2="insert into g_artists (name, a_type, a_year, debut, regdate)"
					+" values ('방탄소년단','남성','2010년대','2013년',datatime('now','localtime'));";
			int cnt=stat2.executeUpdate(sql2);
			if(cnt>0) {
				System.out.println("new datas added");
			}else {
				System.out.println("Error:데이터 추가 오류~");
			}
			stat2.close();
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
			stat2.close();
			//delete data
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
