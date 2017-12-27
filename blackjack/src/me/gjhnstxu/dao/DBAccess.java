package me.gjhnstxu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.gjhnstxu.bean.Player;

/**
 *数据库操作
 */
public class DBAccess {

	
	/**
	 * 清空表中的内容,table是表面
	 * @param table
	 */
	public void empty(String table){
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder empty = new StringBuilder("delete from " + table);
			
			//执行返回句柄
			PreparedStatement stmt = conn.prepareStatement(empty.toString());
			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 一个玩家的所有的牌都可以存到这个玩家中，用id来判断是哪个玩家
	 * @param userid
	 * @param player
	 * @return
	 */
	public Player queryCard(String userid,Player player){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder cards = new StringBuilder("select card from getcard where userid=" + userid);
			
			//执行返回句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(cards.toString());
			
			//用来存储所有的牌
			ArrayList<String> card = new ArrayList<String> (); 
			
			while(rs.next()){
				card.add(rs.getString(1));//将查询到的所有牌都添加到list中
			}
			
			player.setCard(card);//将所有的牌都存入Player对象中
			player.setId(userid);//将id存入这个Player对象中
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return player;
	}
	
	/**
	 * 第一次获取牌
	 * @return
	 */
	public ArrayList<Player> insertFrist(ArrayList<String> list,ArrayList<Player> players){
		
//		ArrayList<String> listcard = new ArrayList<String>();
		ArrayList<String> listcard1 = new ArrayList<String>();
		ArrayList<String> listcard2 = new ArrayList<String>();
		ArrayList<String> listcard3 = new ArrayList<String>();
		ArrayList<String> listcard4 = new ArrayList<String>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder insert = new StringBuilder("insert into getcard(card,userid) values(?,?)");
			
			//返回执行句柄
			PreparedStatement stmt1 = conn.prepareStatement(insert.toString());
			//根据id来给牌
				stmt1.setString(1, list.get(0));
				stmt1.setInt(2, Integer.valueOf(1));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard1.add(list.get(0));
				stmt1.setString(1, list.get(1));
				stmt1.setInt(2, Integer.valueOf(1));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard1.add(list.get(1));
				System.out.println("这是：" + listcard1);
				players.get(0).setCard(listcard1);//为玩家发第一次的牌
				
				stmt1.setString(1, list.get(2));
				stmt1.setInt(2, Integer.valueOf(2));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard2.add(list.get(2));
				stmt1.setString(1, list.get(3));
				stmt1.setInt(2, Integer.valueOf(2));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard2.add(list.get(3));
				players.get(1).setCard(listcard2);//为玩家发第一次的牌

				stmt1.setString(1, list.get(4));
				stmt1.setInt(2, Integer.valueOf(3));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard3.add(list.get(4));
				stmt1.setString(1, list.get(5));
				stmt1.setInt(2, Integer.valueOf(3));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard3.add(list.get(5));
				players.get(2).setCard(listcard3);//为玩家发第一次的牌

				stmt1.setString(1, list.get(6));
				stmt1.setInt(2, Integer.valueOf(4));//用来加入id
				stmt1.executeUpdate();//数据库插入
				listcard4.add(list.get(6));
				stmt1.setString(1, list.get(7));
				stmt1.setInt(2, Integer.valueOf(4));//用来加入id
				stmt1.executeUpdate();//数据库插入
				
				listcard4.add(list.get(7));
				players.get(3).setCard(listcard4);//为玩家发第一次的牌

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}
	
	/**
	 * 根据第一位玩家的id将第一位玩家置为房主
	 * @param id
	 */
	public void sIsHoster(String id){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			String update = "update user set ishoster=1 where id=" + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取玩家的信息，如姓名、现在的牌总数和房间号
	 * @param players
	 */   
	public void queryInformation(ArrayList<Player> players){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder queryname = new StringBuilder("select id,username,pointsum,room,status from user");
			
			//执行返回句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryname.toString());
			int i = 0;
			while(rs.next()){
				players.get(i).setId("" + rs.getInt(1));
				players.get(i).setUsername(rs.getString(2));
				players.get(i).setPointsum(rs.getInt(3));
				players.get(i).setRoom(rs.getInt(4));
				players.get(i).setStatus(rs.getString(5));
				i++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 获取玩家的总点数
	 * @param id
	 * @return
	 */
	public int queryPointSum(String id){
		int sum = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder queryPointSum = new StringBuilder("select pointsum from user where id=" + id);
			
			//执行返回句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryPointSum.toString());
			while(rs.next()){
				sum = rs.getInt("pointsum");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
	
	/**
	 * 获取玩家的status
	 * @param id
	 * @return
	 */
	public String queryStatus(String id){
		String status = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder queryPointSum = new StringBuilder("select status from user where id=" + id);
			
			//执行返回句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryPointSum.toString());
			while(rs.next()){
				status = rs.getString("status");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * 玩家要牌时给玩家牌
	 * @param id
	 * @param param
	 */
	public void giveCard(String id,String param,ArrayList<Player> players,ArrayList<String> list,int i){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder insert = new StringBuilder("insert into getcard(card,userid) values(?,?)");
			
			//返回执行句柄
			PreparedStatement stmt1 = conn.prepareStatement(insert.toString());
			
			//根据玩家的id和是否是要牌的参数来判断是否给玩家牌
			if(id != null && !"".equals(id.trim()) && param.equals("1")){
				
				//首先，获取该玩家当前的牌
				ArrayList<String> cards = players.get(Integer.valueOf(id) - 1).getCard();
				cards.add(list.get(i));
				System.out.println("要牌的玩家现在的牌为：" + cards);
				players.get(Integer.valueOf(id) - 1).setCard(cards);//将牌存入该玩家中
				
				//根据id来将数据存入数据库中
				stmt1.setString(1, list.get(i));
				stmt1.setInt(2, Integer.valueOf(id));//用来加入id
				stmt1.executeUpdate();//数据库插入
			}
			else if(param.equals("0")){
				players.get(Integer.valueOf(id) - 1).setStatus("0");
			}else{
				System.out.println("没有要不要牌的参数");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * 得到玩家所有牌现在的点数之和，并将现在获取到的点数之和存入数据库中的user表中
	 * 首先要将数据库中所有的牌都取出来，并计算他们的点数
	 * @param players
	 */
	public void inPointNum(ArrayList<Player> players){
		//获取每个玩家，再每个玩家的基础上计算每个玩家的总点数
		Player p1 = queryCard("1",players.get(0));
		Player p2 = queryCard("2",players.get(1));
		Player p3 = queryCard("3",players.get(2));
		Player p4 = queryCard("4",players.get(3));
		int sum1 = pointOfSum(p1);
		int sum2 = pointOfSum(p2);
		int sum3 = pointOfSum(p3);
		int sum4 = pointOfSum(p4);
		ArrayList<Integer> sum = new ArrayList<Integer>();
		sum.add(sum1);sum.add(sum2);sum.add(sum3);sum.add(sum4);
//		System.out.println("计算总点数方法中存储点数开始");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			for(int i = 0;i < 4;i++){
				//数据库操作语句
				StringBuilder update = new StringBuilder("update user set pointsum=" + sum.get(i) + " where id=" + (i + 1) );
				//获取执行句柄
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(update.toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//		System.out.println("存贮总点数方法中存储点数结束");
	}
	
	/**
	 * 来对玩家进行加点操作，将玩家的牌全部获取出来，并取他的数值部分的值
	 * 直接传入一个玩家
	 * @param s
	 */
	public static int pointOfSum(Player player){
		
		ArrayList<String> cards = player.getCard();//获取玩家的所有牌
		int sum = 0;
		int n2 = 0;
		for(String s:cards){
			if(isNumber(s.substring(2,s.length()))){
				n2 = Integer.parseInt(s.substring(2,s.length()));
			}else{
				if(s.substring(2,s.length()).equals("A")){
					if(sum + 11 > 21){
						n2 = 1;
					}else{
						n2 = 10;
					}
				}else{
					n2 = 10;
				}
				
			}
			 sum = sum + n2;
		}

//		System.out.println("n1和n2之和为：" + (sum));
		return sum;
	}
	
	//判断是不是数字字符串
	public static  boolean isNumber(String s){
		if(s.equals("1") ||s.equals("2") ||s.equals("3") ||s.equals("4") ||s.equals("5") ||s.equals("6") ||s.equals("7") ||s.equals("8") ||s.equals("9") || s.equals("10")){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取玩家的状态
	 * @param player
	 * @param id
	 */
	public void obtainStatus(Player player,String id){
		int status;
		int sum = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的总点数
			StringBuilder select = new StringBuilder("select pointsum from user where id=" + Integer.valueOf(id));

			//获取执行句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				sum = rs.getInt(1);
			}
			if(sum > 21){
				status = 0;//表示玩家点数已经超过21点，则该玩家的status变为0
			}else{
				status = 1;//表示玩家点数还没有超过21点
			}
			
			//数据库操作语句，将玩家的状态存储到数据库
			StringBuilder update = new StringBuilder("update user set status=" + status + " where id=" + Integer.valueOf(id));
			//获取执行句柄
			Statement stmt1 = conn.createStatement();
			stmt1.executeUpdate(update.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
	
	/**
	 * 判断是否有该玩家
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean hasPlayer(String username,String password){
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的总点数
			StringBuilder select = new StringBuilder("select username,password from user");

			//获取执行句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				
				//遍历获取数据库中的用户名和密码
				String u = rs.getString("username");
				String p = rs.getString("password");
				
				//数据库中的用户名和密码和用户输入的用户名和密码进行比较
				//相同返回true
				if( u.equals(username) && p.equals(password) ){
					flag = true;
					break;
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据库中flag数据的参数为：" + flag);
		return flag;
	}
	
	/**
	 * 获取数据库中所有玩家的名字
	 * @return
	 */
	public ArrayList<String> AllNames(){
		ArrayList<String> namesList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的总点数
			StringBuilder select = new StringBuilder("select username from user");

			//获取执行句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				String name = rs.getString("username");
				namesList.add(name);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namesList;
	}
	
	/**
	 * 根据用户名来获取玩家的id
	 * @param username
	 * @return
	 */
	public String oid(String username){
		String id = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder select = new StringBuilder("select id from user where username='" + username + "'");

			//获取执行句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				id = rs.getString("id");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return id;
	}
	
	/**
	 * 根据用户名来获取玩家的登录密码
	 * @param username
	 * @return
	 */
	public String oPassword(String username){
		String password = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder select = new StringBuilder("select password from user where username='" + username + "'");

			//获取执行句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				password = rs.getString("password");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return password;
	}
	
	/**
	 * 根据玩家的用户名来判断数据库是否含有该玩家，即玩家名是唯一的
	 * true表示数据库中没有该玩家，可以进行注册
	 * @param username
	 * @return
	 */
	public boolean ouserName(String username){
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder select = new StringBuilder("select username from user");

			//获取执行句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				String name = rs.getString("username");
				
				if(name.equals(username)){
					flag = false;
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return flag;
	}
	
	/**
	 * 用户进行注册
	 * @param username
	 * @param password
	 */
	public void registerPlayer(String username,String password){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder insert = new StringBuilder("insert into user(id,username,password) values(?,?,?)");
			StringBuilder select = new StringBuilder("select id from user");
			
			//获取执行句柄
			PreparedStatement stmt1 = conn.prepareStatement(insert.toString());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			int num = 1;
			while(rs.next()){
				num ++;
			}
			stmt1.setInt(1, num);
			stmt1.setString(2, username);
			stmt1.setString(3, password);
			stmt1.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * 将牌转化成牌的id进行返回
	 * @param s
	 * @return
	 */
	public ArrayList<Integer> change(ArrayList<String> s){
		ArrayList<Integer> n = new ArrayList<Integer>();//存储牌的id
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			for(int i = 0; i < s.size(); i++){
				//数据库操作语句，查询数据库中玩家的id
				StringBuilder select = new StringBuilder("select cardid from card where cardname='" + s.get(i) + "'");
				//获取执行句柄
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(select.toString());
				//遍历查询到的数据
				while(rs.next()){
					int d = rs.getInt(1);
					n.add(d);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return n;
	}
	
	/**
	 *  将玩家点击结束的值存储
	 * @param a
	 */
	public void storage(int a){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder insert = new StringBuilder("update test set sum =" + a) ;
			
			//获取执行句柄
			PreparedStatement stmt1 = conn.prepareStatement(insert.toString());
			stmt1.executeUpdate();
			stmt1.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * 获取出局的玩家个数
	 * @return
	 */
	public int oStorage(){
		int d = 0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder select = new StringBuilder("select sum from test");
			
			//获取执行句柄
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt2.executeQuery(select.toString());
			//遍历查询到的数据
			while(rs.next()){
				d = rs.getInt(1);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 获取所有玩家的点数
	 * @return
	 */
	public ArrayList<Integer> oAllPointOfPlayer(){
		
		ArrayList<Integer> points = new ArrayList<Integer>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句，查询数据库中玩家的id
			StringBuilder select = new StringBuilder("select pointsum from user");
			
			//获取执行句柄
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt2.executeQuery(select.toString());
			//遍历查询到的数据
			
			while(rs.next()){
				points.add(rs.getInt(1));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return points;
	}

	
	/**
	 * 根据传入的id数据来获取玩家的名字
	 * @return
	 */
	public ArrayList<String> oNamesByIds(ArrayList<Integer> ids){
		//存储玩家的名字
		ArrayList<String> names = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//循环遍历ids
			for(int id: ids){
				//数据库操作语句，查询数据库中玩家的id
				StringBuilder select = new StringBuilder("select username from user where id=" + id);
				
				//获取执行句柄
				Statement stmt2 = conn.createStatement();
				ResultSet rs = stmt2.executeQuery(select.toString());
				//遍历查询到的数据
				
				while(rs.next()){
					names.add(rs.getString("username"));
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return names;
	}
	
	/**
	 * 获取所有玩家的所有信息
	 * @param players
	 */
	public ArrayList<Player> queryAllInformationOfPlayer(){
		ArrayList<Player> players = new ArrayList<Player>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//数据库操作语句
			StringBuilder queryname = new StringBuilder("select id,username,pointsum,room,status from user");
			
			//执行返回句柄
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryname.toString());
			int i = 0;
			while(rs.next()){
				players.get(i).setId("" + rs.getInt(1));
				players.get(i).setUsername(rs.getString(2));
				players.get(i).setPointsum(rs.getInt(3));
				players.get(i).setRoom(rs.getInt(4));
				players.get(i).setStatus(rs.getString(5));
				i++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return players;
	}
	
	/**
	 * 将玩家的结果记录
	 * @param players
	 * @param pointMax
	 */
	public void sRecords(ArrayList<Player> players,int pointMax){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			
			
			for(Player player:players){
				//存储玩家的所有牌
				String allCards = "";
				//玩家游戏结果
				int r = 0;
				//数据库操作语句
				//查找玩家的所有牌
				StringBuilder select = new StringBuilder("select card from getCard where userid=" + player.getId());
				
				//执行返回句柄
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(select.toString());
				while(rs.next()){
					allCards += rs.getString("card");
				}
				
				if(player.getPointsum()==pointMax){
					r = 1;//玩家获胜
				}else{
					r = 2;//玩家失败
				}
				//插入语句
				StringBuilder insert = new StringBuilder("insert into records(userid,cards,result,pointsum) values(" + player.getId() + "," + "'" + allCards + "'" + "," + r + ","+ player.getPointsum() +")");
				//存储入数据库
				Statement stmt1 = conn.createStatement();
				stmt1.executeUpdate(insert.toString());
				rs.close();
				stmt.close();
				stmt1.close();
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
