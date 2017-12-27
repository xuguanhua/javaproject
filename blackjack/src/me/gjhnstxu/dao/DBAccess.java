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
 *���ݿ����
 */
public class DBAccess {

	
	/**
	 * ��ձ��е�����,table�Ǳ���
	 * @param table
	 */
	public void empty(String table){
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder empty = new StringBuilder("delete from " + table);
			
			//ִ�з��ؾ��
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
	 * һ����ҵ����е��ƶ����Դ浽�������У���id���ж����ĸ����
	 * @param userid
	 * @param player
	 * @return
	 */
	public Player queryCard(String userid,Player player){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder cards = new StringBuilder("select card from getcard where userid=" + userid);
			
			//ִ�з��ؾ��
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(cards.toString());
			
			//�����洢���е���
			ArrayList<String> card = new ArrayList<String> (); 
			
			while(rs.next()){
				card.add(rs.getString(1));//����ѯ���������ƶ���ӵ�list��
			}
			
			player.setCard(card);//�����е��ƶ�����Player������
			player.setId(userid);//��id�������Player������
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
	 * ��һ�λ�ȡ��
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
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder insert = new StringBuilder("insert into getcard(card,userid) values(?,?)");
			
			//����ִ�о��
			PreparedStatement stmt1 = conn.prepareStatement(insert.toString());
			//����id������
				stmt1.setString(1, list.get(0));
				stmt1.setInt(2, Integer.valueOf(1));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard1.add(list.get(0));
				stmt1.setString(1, list.get(1));
				stmt1.setInt(2, Integer.valueOf(1));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard1.add(list.get(1));
				System.out.println("���ǣ�" + listcard1);
				players.get(0).setCard(listcard1);//Ϊ��ҷ���һ�ε���
				
				stmt1.setString(1, list.get(2));
				stmt1.setInt(2, Integer.valueOf(2));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard2.add(list.get(2));
				stmt1.setString(1, list.get(3));
				stmt1.setInt(2, Integer.valueOf(2));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard2.add(list.get(3));
				players.get(1).setCard(listcard2);//Ϊ��ҷ���һ�ε���

				stmt1.setString(1, list.get(4));
				stmt1.setInt(2, Integer.valueOf(3));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard3.add(list.get(4));
				stmt1.setString(1, list.get(5));
				stmt1.setInt(2, Integer.valueOf(3));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard3.add(list.get(5));
				players.get(2).setCard(listcard3);//Ϊ��ҷ���һ�ε���

				stmt1.setString(1, list.get(6));
				stmt1.setInt(2, Integer.valueOf(4));//��������id
				stmt1.executeUpdate();//���ݿ����
				listcard4.add(list.get(6));
				stmt1.setString(1, list.get(7));
				stmt1.setInt(2, Integer.valueOf(4));//��������id
				stmt1.executeUpdate();//���ݿ����
				
				listcard4.add(list.get(7));
				players.get(3).setCard(listcard4);//Ϊ��ҷ���һ�ε���

		
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
	 * ���ݵ�һλ��ҵ�id����һλ�����Ϊ����
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
	 * ��ȡ��ҵ���Ϣ�������������ڵ��������ͷ����
	 * @param players
	 */   
	public void queryInformation(ArrayList<Player> players){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder queryname = new StringBuilder("select id,username,pointsum,room,status from user");
			
			//ִ�з��ؾ��
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
	 * ��ȡ��ҵ��ܵ���
	 * @param id
	 * @return
	 */
	public int queryPointSum(String id){
		int sum = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder queryPointSum = new StringBuilder("select pointsum from user where id=" + id);
			
			//ִ�з��ؾ��
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
	 * ��ȡ��ҵ�status
	 * @param id
	 * @return
	 */
	public String queryStatus(String id){
		String status = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder queryPointSum = new StringBuilder("select status from user where id=" + id);
			
			//ִ�з��ؾ��
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
	 * ���Ҫ��ʱ�������
	 * @param id
	 * @param param
	 */
	public void giveCard(String id,String param,ArrayList<Player> players,ArrayList<String> list,int i){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder insert = new StringBuilder("insert into getcard(card,userid) values(?,?)");
			
			//����ִ�о��
			PreparedStatement stmt1 = conn.prepareStatement(insert.toString());
			
			//������ҵ�id���Ƿ���Ҫ�ƵĲ������ж��Ƿ�������
			if(id != null && !"".equals(id.trim()) && param.equals("1")){
				
				//���ȣ���ȡ����ҵ�ǰ����
				ArrayList<String> cards = players.get(Integer.valueOf(id) - 1).getCard();
				cards.add(list.get(i));
				System.out.println("Ҫ�Ƶ�������ڵ���Ϊ��" + cards);
				players.get(Integer.valueOf(id) - 1).setCard(cards);//���ƴ���������
				
				//����id�������ݴ������ݿ���
				stmt1.setString(1, list.get(i));
				stmt1.setInt(2, Integer.valueOf(id));//��������id
				stmt1.executeUpdate();//���ݿ����
			}
			else if(param.equals("0")){
				players.get(Integer.valueOf(id) - 1).setStatus("0");
			}else{
				System.out.println("û��Ҫ��Ҫ�ƵĲ���");
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
	 * �õ�������������ڵĵ���֮�ͣ��������ڻ�ȡ���ĵ���֮�ʹ������ݿ��е�user����
	 * ����Ҫ�����ݿ������е��ƶ�ȡ���������������ǵĵ���
	 * @param players
	 */
	public void inPointNum(ArrayList<Player> players){
		//��ȡÿ����ң���ÿ����ҵĻ����ϼ���ÿ����ҵ��ܵ���
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
//		System.out.println("�����ܵ��������д洢������ʼ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			for(int i = 0;i < 4;i++){
				//���ݿ�������
				StringBuilder update = new StringBuilder("update user set pointsum=" + sum.get(i) + " where id=" + (i + 1) );
				//��ȡִ�о��
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
//		System.out.println("�����ܵ��������д洢��������");
	}
	
	/**
	 * ������ҽ��мӵ����������ҵ���ȫ����ȡ��������ȡ������ֵ���ֵ�ֵ
	 * ֱ�Ӵ���һ�����
	 * @param s
	 */
	public static int pointOfSum(Player player){
		
		ArrayList<String> cards = player.getCard();//��ȡ��ҵ�������
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

//		System.out.println("n1��n2֮��Ϊ��" + (sum));
		return sum;
	}
	
	//�ж��ǲ��������ַ���
	public static  boolean isNumber(String s){
		if(s.equals("1") ||s.equals("2") ||s.equals("3") ||s.equals("4") ||s.equals("5") ||s.equals("6") ||s.equals("7") ||s.equals("8") ||s.equals("9") || s.equals("10")){
			return true;
		}
		return false;
	}
	
	/**
	 * ��ȡ��ҵ�״̬
	 * @param player
	 * @param id
	 */
	public void obtainStatus(Player player,String id){
		int status;
		int sum = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ��ܵ���
			StringBuilder select = new StringBuilder("select pointsum from user where id=" + Integer.valueOf(id));

			//��ȡִ�о��
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				sum = rs.getInt(1);
			}
			if(sum > 21){
				status = 0;//��ʾ��ҵ����Ѿ�����21�㣬�����ҵ�status��Ϊ0
			}else{
				status = 1;//��ʾ��ҵ�����û�г���21��
			}
			
			//���ݿ������䣬����ҵ�״̬�洢�����ݿ�
			StringBuilder update = new StringBuilder("update user set status=" + status + " where id=" + Integer.valueOf(id));
			//��ȡִ�о��
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
	 * �ж��Ƿ��и����
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean hasPlayer(String username,String password){
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ��ܵ���
			StringBuilder select = new StringBuilder("select username,password from user");

			//��ȡִ�о��
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select.toString());
			while(rs.next()){
				
				//������ȡ���ݿ��е��û���������
				String u = rs.getString("username");
				String p = rs.getString("password");
				
				//���ݿ��е��û�����������û�������û�����������бȽ�
				//��ͬ����true
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
		System.out.println("���ݿ���flag���ݵĲ���Ϊ��" + flag);
		return flag;
	}
	
	/**
	 * ��ȡ���ݿ���������ҵ�����
	 * @return
	 */
	public ArrayList<String> AllNames(){
		ArrayList<String> namesList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ��ܵ���
			StringBuilder select = new StringBuilder("select username from user");

			//��ȡִ�о��
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
	 * �����û�������ȡ��ҵ�id
	 * @param username
	 * @return
	 */
	public String oid(String username){
		String id = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder select = new StringBuilder("select id from user where username='" + username + "'");

			//��ȡִ�о��
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
	 * �����û�������ȡ��ҵĵ�¼����
	 * @param username
	 * @return
	 */
	public String oPassword(String username){
		String password = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder select = new StringBuilder("select password from user where username='" + username + "'");

			//��ȡִ�о��
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
	 * ������ҵ��û������ж����ݿ��Ƿ��и���ң����������Ψһ��
	 * true��ʾ���ݿ���û�и���ң����Խ���ע��
	 * @param username
	 * @return
	 */
	public boolean ouserName(String username){
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder select = new StringBuilder("select username from user");

			//��ȡִ�о��
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
	 * �û�����ע��
	 * @param username
	 * @param password
	 */
	public void registerPlayer(String username,String password){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder insert = new StringBuilder("insert into user(id,username,password) values(?,?,?)");
			StringBuilder select = new StringBuilder("select id from user");
			
			//��ȡִ�о��
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
	 * ����ת�����Ƶ�id���з���
	 * @param s
	 * @return
	 */
	public ArrayList<Integer> change(ArrayList<String> s){
		ArrayList<Integer> n = new ArrayList<Integer>();//�洢�Ƶ�id
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			for(int i = 0; i < s.size(); i++){
				//���ݿ������䣬��ѯ���ݿ�����ҵ�id
				StringBuilder select = new StringBuilder("select cardid from card where cardname='" + s.get(i) + "'");
				//��ȡִ�о��
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(select.toString());
				//������ѯ��������
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
	 *  ����ҵ��������ֵ�洢
	 * @param a
	 */
	public void storage(int a){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder insert = new StringBuilder("update test set sum =" + a) ;
			
			//��ȡִ�о��
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
	 * ��ȡ���ֵ���Ҹ���
	 * @return
	 */
	public int oStorage(){
		int d = 0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder select = new StringBuilder("select sum from test");
			
			//��ȡִ�о��
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt2.executeQuery(select.toString());
			//������ѯ��������
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
	 * ��ȡ������ҵĵ���
	 * @return
	 */
	public ArrayList<Integer> oAllPointOfPlayer(){
		
		ArrayList<Integer> points = new ArrayList<Integer>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ������䣬��ѯ���ݿ�����ҵ�id
			StringBuilder select = new StringBuilder("select pointsum from user");
			
			//��ȡִ�о��
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt2.executeQuery(select.toString());
			//������ѯ��������
			
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
	 * ���ݴ����id��������ȡ��ҵ�����
	 * @return
	 */
	public ArrayList<String> oNamesByIds(ArrayList<Integer> ids){
		//�洢��ҵ�����
		ArrayList<String> names = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//ѭ������ids
			for(int id: ids){
				//���ݿ������䣬��ѯ���ݿ�����ҵ�id
				StringBuilder select = new StringBuilder("select username from user where id=" + id);
				
				//��ȡִ�о��
				Statement stmt2 = conn.createStatement();
				ResultSet rs = stmt2.executeQuery(select.toString());
				//������ѯ��������
				
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
	 * ��ȡ������ҵ�������Ϣ
	 * @param players
	 */
	public ArrayList<Player> queryAllInformationOfPlayer(){
		ArrayList<Player> players = new ArrayList<Player>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			//���ݿ�������
			StringBuilder queryname = new StringBuilder("select id,username,pointsum,room,status from user");
			
			//ִ�з��ؾ��
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
	 * ����ҵĽ����¼
	 * @param players
	 * @param pointMax
	 */
	public void sRecords(ArrayList<Player> players,int pointMax){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack?useSSL=false","root","password");
			
			
			
			for(Player player:players){
				//�洢��ҵ�������
				String allCards = "";
				//�����Ϸ���
				int r = 0;
				//���ݿ�������
				//������ҵ�������
				StringBuilder select = new StringBuilder("select card from getCard where userid=" + player.getId());
				
				//ִ�з��ؾ��
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(select.toString());
				while(rs.next()){
					allCards += rs.getString("card");
				}
				
				if(player.getPointsum()==pointMax){
					r = 1;//��һ�ʤ
				}else{
					r = 2;//���ʧ��
				}
				//�������
				StringBuilder insert = new StringBuilder("insert into records(userid,cards,result,pointsum) values(" + player.getId() + "," + "'" + allCards + "'" + "," + r + ","+ player.getPointsum() +")");
				//�洢�����ݿ�
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
