package me.gjhnstxu.bean;

import java.util.List;

/**
 * 
 * @author xuguanhua
 *
 * 玩家的总类
 */
public class PlayerTotal {

	private int total;//玩家的数量
	private List<Player> context;
	
	/**
	 * 两个构造器
	 */
	public PlayerTotal(){
		
	}
	
	public PlayerTotal(int total,List<Player> context){
		this.total = total;
		this.context = context;
	}

	
	/**
	 * PlayerTotal的所有成员变量的获取器和设置器
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
