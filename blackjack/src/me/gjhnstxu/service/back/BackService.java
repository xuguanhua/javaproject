package me.gjhnstxu.service.back;

import java.util.ArrayList;

import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;

/**
 * 玩家相关的业务逻辑
 */
public class BackService {

	/**
	 * 清空数据库中的特定表
	 * @param table
	 */
	public void empty(String table){
		DBAccess empty = new DBAccess();
		empty.empty(table);
	}
	
	/**
	 * 获得id为id的玩家的牌
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
	 * 第一次获取牌
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
	 * 根据第一位玩家的id将第一位玩家置为房主
	 * @param id
	 */
	public void sIsHoster(String id){
		DBAccess sIsHoster = new DBAccess();
		sIsHoster.sIsHoster(id);
	}
	
	/**
	 * 获取玩家的信息
	 * @param players
	 */  
	public void queryInformation(ArrayList<Player> players){
		DBAccess queryCard = new DBAccess();
		queryCard.queryInformation(players);
	}
	
	/**
	 * 玩家是否要牌的处理
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
	 * 获取玩家的总点数
	 * @param players
	 */
	public void inPointNum(ArrayList<Player> players){
		DBAccess inPointNum = new DBAccess();
		inPointNum.inPointNum(players);
	}

	/**
	 * 获取玩家的状态
	 * @param player
	 * @param id
	 * @return
	 */
	public void obtainStatus(Player player,String id){
		DBAccess obtainStatus = new DBAccess();
		obtainStatus.obtainStatus(player, id);
	}
}
