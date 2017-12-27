package me.gjhnstxu.servlet.back;

import java.util.ArrayList;

import me.gjhnstxu.bean.Player;
import me.gjhnstxu.dao.DBAccess;
import me.gjhnstxu.service.front.FrontService;

public class Test {

	public static void main(String[] args){
		String idss = "1";
     	Player playerww = new Player();
     	DBAccess dao = new DBAccess();
     	playerww = dao.queryCard(idss,playerww);
		ArrayList<String> cardlist = playerww.getCard();
		for(String i:cardlist){
			System.out.println("值是：" + i);
		}
		
		FrontService front = new FrontService();
		int[] cardIdList = front.change(cardlist);
		for(int i:cardIdList){
			System.out.println("值是：" + i);
		}
	}
}

