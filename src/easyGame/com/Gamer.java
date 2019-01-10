package easyGame.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * �����
 * @author SHsama
 *
 */
public class Gamer {
	private int gamerID;
	private String gamerName;
	private List<Gamer> gamerList;
	private List<Poker> tempPokerList;
	
	public int getGamerID() {
		return gamerID;
	}
	public void setGamerID(int gamerID) {
		this.gamerID = gamerID;
	}
	public String getGamerName() {
		return gamerName;
	}
	public void setGamerName(String gamerName) {
		this.gamerName = gamerName;
	}
	
	public List<Gamer> getGamerList() {
		return gamerList;
	}
	public void setGamerList(List<Gamer> gamerList) {
		this.gamerList = gamerList;
	}
	
	public List<Poker> getTempPokerList() {
		return tempPokerList;
	}
	public void setTempPokerList(List<Poker> tempPokerList) {
		this.tempPokerList = tempPokerList;
	}
	public Gamer() {
		setGamerList(new ArrayList<Gamer>());
	}
	public Gamer(int gamerID, String gameName) {
		// TODO Auto-generated constructor stub
		setGamerID(gamerID);
		setGamerName(gameName);
		setTempPokerList(new ArrayList<Poker>());
	}
	//�����������
	public void creatGamer() {
		for (int i = 0; i < 2; i++) {
			System.out.println("�������" + (i + 1) + "λ���ID������");
			while(true) {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.print("����ID:");
					int ID = scan.nextInt();
					System.out.print("����������");
					String name = scan.next();
					Gamer gamer = new Gamer(ID, name);
					getGamerList().add(gamer);
					break;
				} catch (Exception e) {
					System.out.println("��������������ID");
				}
			}
		}
		for (int i = 0; i < getGamerList().size(); i++) {
			System.out.println("��ӭ���["+getGamerList().get(i).getGamerName()+"]������Ϸ");
		}
		
			
	}
	
	//��ӡ��Ҹ�������
	public void printGamersPoker() {
		System.out.println("��Ҹ������ƹ�ʾ��");
		for (int i = 0; i < getGamerList().size(); i++) {
			System.out.print("IDΪ"+getGamerList().get(i).getGamerID()+"�����"+getGamerList().get(i).getGamerName()+":[ ");
			for (int j = 0; j < getGamerList().get(i).getTempPokerList().size(); j++) {
				Poker tempPoker = getGamerList().get(i).getTempPokerList().get(j);
				System.out.print(tempPoker.getPokerType()+tempPoker.getPokerValue()+" ");
			}
			System.out.print("]");
			System.out.println();
		}
		
	}

}
