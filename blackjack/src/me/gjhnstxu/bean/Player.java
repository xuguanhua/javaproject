package me.gjhnstxu.bean;

import java.util.ArrayList;

/**
 *�����
 */
public class Player {

	private String id;//���id
	private String username;//�������
	private int pointsum;//����ܵ���
	private int room;//��ҷ����
	private String status;//��ʾ��ҵ�ǰ��״̬
	private ArrayList<String> card;//��ҵ���
	
	public Player(String id,String username,ArrayList<String> card){
		this.id = id;
		this.username = username;
		this.card = card;
	}
	
	public Player(){
		
	}

	/**
	 * ��������ҵ����г�Ա�����Ļ�ȡ�����޸���
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
