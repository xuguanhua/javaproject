package me.gjhnstxu.service.front;

import java.util.ArrayList;

import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;

public class FrontService {

	/**
	 * �ж��û����������Ƿ���ȷ
	 * true��ʾ�û�����������ȷ
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
	 * ��ȡ��ҵ�id
	 * @param username
	 * @return
	 */
	public String oid(String username){
		DBAccess oid = new DBAccess();
		String id = oid.oid(username);
		return id;
	}
	
	/**
	 * ��ȡ��ҵĵ�¼����
	 * @param username
	 * @return
	 */
	public String oPassword(String username){
		DBAccess oPassword = new DBAccess();
		String password = oPassword.oPassword(username);
		return password;
	}
	
	/**
	 * �ж�����Ƿ����
	 * @param username
	 * @return
	 */
	public boolean ouserName(String username){
		DBAccess ouserName = new DBAccess();
		return ouserName.ouserName(username);
	}
	
	/**
	 * ��ȡ���ݿ���������ҵ�����
	 * @return
	 */
	public ArrayList<String> allNames(){
		DBAccess allNames = new DBAccess();
		return allNames.AllNames();
	}
	/**
	 * �ж����������Ƿ�����ͬ��
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
	 * �û�ע��
	 * @param username
	 * @param password
	 */
	public void registerPlayer(String username,String password){
		DBAccess registerPlayer = new DBAccess();
		registerPlayer.registerPlayer(username, password);
	}
	
	/**
	 * ���Ƶ����Ƶõ��Ƶ�id
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
	 *  ����ҵ��������ֵ�洢
	 * @param a
	 */
	public void storage(int a){
		DBAccess storage = new DBAccess();
		storage.storage(a);
	}
	
	/**
	 * ������ҳ��ֵ�����
	 * @return
	 */
	public int oStorage(){
		DBAccess ostorage = new DBAccess();
		return ostorage.oStorage();
	}
	
	/**
	 * ��ȡ��ҵ��ܵ�����������Ӯ�ж�
	 */
	public ArrayList<Integer> oAllPointOfPlayer(){
		DBAccess dbAccess = new DBAccess();
		ArrayList<Integer> points = dbAccess.oAllPointOfPlayer();
		ArrayList<Integer> indexs = new ArrayList<>();
		int max = points.get(0);
		int k = 1;//maxֵ����
		for(int i:points){
			if(i > 21){
				//��ȡ���ó���21��ֵ��λ��
				int j = points.indexOf(i);
				//��iֵλ��Ϊ0
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
		//��������뵽indexs�����
		indexs.add(max);
		return indexs;
	}
	
	/**
	 * ������ҵ�id����ȡ��ҵ�����
	 * @param ids
	 * @return
	 */
	public ArrayList<String> oNamesByIds(ArrayList<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		return dbAccess.oNamesByIds(ids);
	}
	
	/**
	 * ��ȡ������ҵ�������Ϣ
	 * @param players
	 * @return
	 */
	public ArrayList<Player> queryInformation(ArrayList<Player> players){
		DBAccess dbAccess = new DBAccess();
		dbAccess.queryInformation(players);
		return players;
	}
	
	/**
	 * ����ҵĽ����¼
	 * @param players
	 * @param name
	 * @param pointMax
	 */
	public void sRecords(ArrayList<Player> players,int pointMax){
		DBAccess dbAccess = new DBAccess();
		dbAccess.sRecords(players, pointMax);
	}
	
}
