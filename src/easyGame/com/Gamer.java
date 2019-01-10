package easyGame.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 玩家类
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
	//创建两名玩家
	public void creatGamer() {
		for (int i = 0; i < 2; i++) {
			System.out.println("请输入第" + (i + 1) + "位玩家ID和姓名");
			while(true) {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.print("输入ID:");
					int ID = scan.nextInt();
					System.out.print("输入姓名：");
					String name = scan.next();
					Gamer gamer = new Gamer(ID, name);
					getGamerList().add(gamer);
					break;
				} catch (Exception e) {
					System.out.println("请输入整型类型ID");
				}
			}
		}
		for (int i = 0; i < getGamerList().size(); i++) {
			System.out.println("欢迎玩家["+getGamerList().get(i).getGamerName()+"]加入游戏");
		}
		
			
	}
	
	//打印玩家各自手牌
	public void printGamersPoker() {
		System.out.println("玩家各自手牌公示：");
		for (int i = 0; i < getGamerList().size(); i++) {
			System.out.print("ID为"+getGamerList().get(i).getGamerID()+"的玩家"+getGamerList().get(i).getGamerName()+":[ ");
			for (int j = 0; j < getGamerList().get(i).getTempPokerList().size(); j++) {
				Poker tempPoker = getGamerList().get(i).getTempPokerList().get(j);
				System.out.print(tempPoker.getPokerType()+tempPoker.getPokerValue()+" ");
			}
			System.out.print("]");
			System.out.println();
		}
		
	}

}
