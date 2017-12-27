package me.gjhnstxu.bean;

import java.util.ArrayList;

/**
 *玩家类
 */
public class Player {

	private String id;//玩家id
	private String username;//玩家名字
	private int pointsum;//玩家总点数
	private int room;//玩家房间号
	private String status;//表示玩家当前的状态
	private ArrayList<String> card;//玩家的牌
	
	public Player(String id,String username,ArrayList<String> card){
		this.id = id;
		this.username = username;
		this.card = card;
	}
	
	public Player(){
		
	}

	/**
	 * 以下是玩家的所有成员变量的获取器和修改器
	 */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPointsum() {
		
		return pointsum;
	}

	public void setPointsum(int pointsum) {
		this.pointsum = pointsum;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public ArrayList<String> getCard() {
		return card;
	}

	public void setCard(ArrayList<String> card) {
		this.card = card;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
