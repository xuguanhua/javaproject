package me.gjhnstxu.service.back;

import java.util.ArrayList;

import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;

/**
 * �����ص�ҵ���߼�
 */
public class BackService {

	/**
	 * ������ݿ��е��ض���
	 * @param table
	 */
	public void empty(String table){
		DBAccess empty = new DBAccess();
		empty.empty(table);
	}
	
	/**
	 * ���idΪid����ҵ���
	 * @param userid
	 * @param player
	 * @return
	 */
	public Player queryCard(String userid,Player player){
		DBAccess queryCard = new DBAccess();
		Player playCards = queryCard.queryCard(userid, player);
		return playCards;
	}
	
	/**
	 * ��һ�λ�ȡ��
	 * @param list
	 * @param id
	 * @param player
	 * @return
	 */
	public ArrayList<Player> insertFrist(ArrayList<String> list,ArrayList<Player> players){
		DBAccess queryCard = new DBAccess();
		ArrayList<Player> playCards = queryCard.insertFrist(list,players);
		return playCards;
	}
	
	/**
	 * ���ݵ�һλ��ҵ�id����һλ�����Ϊ����
	 * @param id
	 */
	public void sIsHoster(String id){
		DBAccess sIsHoster = new DBAccess();
		sIsHoster.sIsHoster(id);
	}
	
	/**
	 * ��ȡ��ҵ���Ϣ
	 * @param players
	 */  
	public void queryInformation(ArrayList<Player> players){
		DBAccess queryCard = new DBAccess();
		queryCard.queryInformation(players);
	}
	
	/**
	 * ����Ƿ�Ҫ�ƵĴ���
	 * @param id
	 * @param param
	 * @param players
	 * @param list
	 * @param i
	 */
	public void giveCard(String id,String param,ArrayList<Player> players,ArrayList<String> list,int i){
		DBAccess giveCard = new DBAccess();
		giveCard.giveCard(id, param, players, list, i);
	}
	
	/**
	 * ��ȡ��ҵ��ܵ���
	 * @param players
	 */
	public void inPointNum(ArrayList<Player> players){
		DBAccess inPointNum = new DBAccess();
		inPointNum.inPointNum(players);
	}

	/**
	 * ��ȡ��ҵ�״̬
	 * @param player
	 * @param id
	 * @return
	 */
	public void obtainStatus(Player player,String id){
		DBAccess obtainStatus = new DBAccess();
		obtainStatus.obtainStatus(player, id);
	}
}
