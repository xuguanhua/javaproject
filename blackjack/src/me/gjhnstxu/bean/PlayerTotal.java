package me.gjhnstxu.bean;

import java.util.List;

/**
 * 
 * @author xuguanhua
 *
 * ��ҵ�����
 */
public class PlayerTotal {

	private int total;//��ҵ�����
	private List<Player> context;
	
	/**
	 * ����������
	 */
	public PlayerTotal(){
		
	}
	
	public PlayerTotal(int total,List<Player> context){
		this.total = total;
		this.context = context;
	}

	
	/**
	 * PlayerTotal�����г�Ա�����Ļ�ȡ����������
	 */
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Player> getContext() {
		return context;
	}

	public void setContext(List<Player> context) {
		this.context = context;
	}

	
}
