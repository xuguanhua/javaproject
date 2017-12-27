package me.gjhnstxu.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GetCard {

	static int numberOfPlayers=4;//玩家数量
	static int numberOfHandCard=13;//牌每种花色的数量
	static String[] pokers=new String[52];//总的牌数量
	static String[] cardNow = new String[52];//现在的牌
	static ArrayList<String> list=new ArrayList<String>();//存储总的牌
	static ArrayList<String> list1 = new ArrayList<String>();//存储id为1的玩家的牌
	static ArrayList<String> list2 = new ArrayList<String>();//存储id为2的玩家的牌
	static ArrayList<String> list3 = new ArrayList<String>();//存储id为3的玩家的牌
	static ArrayList<String> list4 = new ArrayList<String>();//存储id为4的玩家的牌
	
	
	//创建牌
	public static String[] newPoker() {
		String[] huase = {"红桃","黑桃","梅花","方块"};
		String[] paiValue = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int index = 0;
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				pokers[index++]=huase[j]+paiValue[i];
			}
		}
		return pokers;//返回牌
	}
	
	//创建洗牌shuffleCard()方法
	public ArrayList<String> shuffleCard(String[] array){
		//定义新的数组，用以存储洗好的牌
		String[] newpokers =new String[pokers.length];
		//定义新的数组，用以存储表示被随机取出的牌
		boolean[] mark =new boolean[pokers.length];
			//洗牌
			for(int i=0;i<pokers.length;i++) {
				//创建随机数
				Random rd = new Random();
				//获取随机数的下标
				int index = rd.nextInt(pokers.length);
				//判断标识
				if(mark[index]==false) {
					//将未洗过的牌存储到newpokers
					String temp = pokers[i];
					pokers[i] = pokers[index];
					pokers[index] = temp;
				}
				else {
					i--;
				}
			}
			//newpoker内的牌拷贝到新的数组pokers
			newpokers=Arrays.copyOf(pokers,newpokers.length);
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(newpokers));
			return list;
	}		

	
}
