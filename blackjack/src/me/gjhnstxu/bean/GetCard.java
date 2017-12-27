package me.gjhnstxu.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GetCard {

	static int numberOfPlayers=4;//�������
	static int numberOfHandCard=13;//��ÿ�ֻ�ɫ������
	static String[] pokers=new String[52];//�ܵ�������
	static String[] cardNow = new String[52];//���ڵ���
	static ArrayList<String> list=new ArrayList<String>();//�洢�ܵ���
	static ArrayList<String> list1 = new ArrayList<String>();//�洢idΪ1����ҵ���
	static ArrayList<String> list2 = new ArrayList<String>();//�洢idΪ2����ҵ���
	static ArrayList<String> list3 = new ArrayList<String>();//�洢idΪ3����ҵ���
	static ArrayList<String> list4 = new ArrayList<String>();//�洢idΪ4����ҵ���
	
	
	//������
	public static String[] newPoker() {
		String[] huase = {"����","����","÷��","����"};
		String[] paiValue = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int index = 0;
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				pokers[index++]=huase[j]+paiValue[i];
			}
		}
		return pokers;//������
	}
	
	//����ϴ��shuffleCard()����
	public ArrayList<String> shuffleCard(String[] array){
		//�����µ����飬���Դ洢ϴ�õ���
		String[] newpokers =new String[pokers.length];
		//�����µ����飬���Դ洢��ʾ�����ȡ������
		boolean[] mark =new boolean[pokers.length];
			//ϴ��
			for(int i=0;i<pokers.length;i++) {
				//���������
				Random rd = new Random();
				//��ȡ��������±�
				int index = rd.nextInt(pokers.length);
				//�жϱ�ʶ
				if(mark[index]==false) {
					//��δϴ�����ƴ洢��newpokers
					String temp = pokers[i];
					pokers[i] = pokers[index];
					pokers[index] = temp;
				}
				else {
					i--;
				}
			}
			//newpoker�ڵ��ƿ������µ�����pokers
			newpokers=Arrays.copyOf(pokers,newpokers.length);
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(newpokers));
			return list;
	}		

	
}
