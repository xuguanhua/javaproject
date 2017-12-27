package me.gjhnstxu.service.front;

import java.util.ArrayList;

import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;

public class FrontService {

	/**
	 * 判断用户名和密码是否正确
	 * true表示用户名和密码正确
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean hasPlayer(String username,String password){
		DBAccess hasPlayer = new DBAccess();
		boolean flag = hasPlayer.hasPlayer(username, password);
		return flag;
	}
	
	/**
	 * 获取玩家的id
	 * @param username
	 * @return
	 */
	public String oid(String username){
		DBAccess oid = new DBAccess();
		String id = oid.oid(username);
		return id;
	}
	
	/**
	 * 获取玩家的登录密码
	 * @param username
	 * @return
	 */
	public String oPassword(String username){
		DBAccess oPassword = new DBAccess();
		String password = oPassword.oPassword(username);
		return password;
	}
	
	/**
	 * 判断玩家是否存在
	 * @param username
	 * @return
	 */
	public boolean ouserName(String username){
		DBAccess ouserName = new DBAccess();
		return ouserName.ouserName(username);
	}
	
	/**
	 * 获取数据库中所有玩家的名字
	 * @return
	 */
	public ArrayList<String> allNames(){
		DBAccess allNames = new DBAccess();
		return allNames.AllNames();
	}
	/**
	 * 判断两个密码是否是相同的
	 * @param p1
	 * @param p2
	 * @return
	 */
	public boolean passwordIsSame(String p1,String p2){
		if(p1.equals(p2)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 */
	public void registerPlayer(String username,String password){
		DBAccess registerPlayer = new DBAccess();
		registerPlayer.registerPlayer(username, password);
	}
	
	/**
	 * 由牌的名称得到牌的id
	 * @param s
	 * @return
	 */
	public int[] change(ArrayList<String> s){
		DBAccess change = new DBAccess();
		ArrayList<Integer> ids = change.change(s);
		int[] n = new int[ids.size()];
		for(int i = 0;i < ids.size(); i++){
			n[i] = ids.get(i);
		}
		return n;
	}
	
	/**
	 *  将玩家点击结束的值存储
	 * @param a
	 */
	public void storage(int a){
		DBAccess storage = new DBAccess();
		storage.storage(a);
	}
	
	/**
	 * 处理玩家出局的人数
	 * @return
	 */
	public int oStorage(){
		DBAccess ostorage = new DBAccess();
		return ostorage.oStorage();
	}
	
	/**
	 * 获取玩家的总点数并进行输赢判断
	 */
	public ArrayList<Integer> oAllPointOfPlayer(){
		DBAccess dbAccess = new DBAccess();
		ArrayList<Integer> points = dbAccess.oAllPointOfPlayer();
		ArrayList<Integer> indexs = new ArrayList<>();
		int max = points.get(0);
		int k = 1;//max值个数
		for(int i:points){
			if(i > 21){
				//获取到该超过21的值的位置
				int j = points.indexOf(i);
				//将i值位置为0
				points.add(j, 0);
			}
		}
		
		for(int i:points){
			if(i > max){
				max = i;
			}
		}
		
		for(int i:points){
			if(i == max){
				indexs.add(points.indexOf(max));
			}
		}
		//将结果加入到indexs的最后
		indexs.add(max);
		return indexs;
	}
	
	/**
	 * 根据玩家的id来获取玩家的名字
	 * @param ids
	 * @return
	 */
	public ArrayList<String> oNamesByIds(ArrayList<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		return dbAccess.oNamesByIds(ids);
	}
	
	/**
	 * 获取所有玩家的所有信息
	 * @param players
	 * @return
	 */
	public ArrayList<Player> queryInformation(ArrayList<Player> players){
		DBAccess dbAccess = new DBAccess();
		dbAccess.queryInformation(players);
		return players;
	}
	
	/**
	 * 将玩家的结果记录
	 * @param players
	 * @param name
	 * @param pointMax
	 */
	public void sRecords(ArrayList<Player> players,int pointMax){
		DBAccess dbAccess = new DBAccess();
		dbAccess.sRecords(players, pointMax);
	}
	
}
