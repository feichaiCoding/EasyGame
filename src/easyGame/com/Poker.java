package easyGame.com;

import java.util.ArrayList;
import java.util.List;

/**
 * 扑克类
 * @author SHsama
 *
 */
public class Poker {
	private String pokerType;//扑克花色
	private String pokerValue;//扑克大小
	
	private String[] pokerTypeArr;
	private String[] pokerValueArr;
	
	private List<Poker> pokerList;
	
	public String getPokerType() {
		return pokerType;
	}
	public void setPokerType(String pokerType) {
		this.pokerType = pokerType;
	}
	public String getPokerValue() {
		return pokerValue;
	}
	public void setPokerValue(String pokerValue) {
		this.pokerValue = pokerValue;
	}
	
	public String[] getPokerTypeArr() {
		return pokerTypeArr;
	}
	public void setPokerTypeArr(String[] pokerTypeArr) {
		this.pokerTypeArr = pokerTypeArr;
	}
	public String[] getPokerValueArr() {
		return pokerValueArr;
	}
	public void setPokerValueArr(String[] pokerValueArr) {
		this.pokerValueArr = pokerValueArr;
	}
	public List<Poker> getPokerList() {
		return pokerList;
	}
	public void setPokerList(List<Poker> pokerList) {
		this.pokerList = pokerList;
	}
	public Poker() {
		setPokerTypeArr(new String[]{"方块", "梅花", "红心", "黑桃"});
		setPokerValueArr(new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"});
		setPokerList(new ArrayList<Poker>());
	}
	public Poker(String pokerType, String pokerValue) {
		setPokerType(pokerType);
		setPokerValue(pokerValue);
	}
	
	//创建扑克牌
	public void creatPoker() {
		System.out.println("创建扑克中，请稍等...");
		
		for (String type : getPokerTypeArr()) {
			for (String value : getPokerValueArr()) {
				Poker poker = new Poker(type, value);
				getPokerList().add(poker);
			}
		}
		
	}
	
	//显示创建的扑克牌
	public void printPoker() {
		System.out.println("创建成功：");
//		for (Poker poker : getPokerList()) {
//			System.out.print("["+poker.getPokerType()+poker.getPokerValue()+"] ");
//		}
		for (int i = 0; i < getPokerList().size(); i++) {
			System.out.print("["+getPokerList().get(i).getPokerType()+getPokerList().get(i).getPokerValue()+"] ");
			if((i+1)%13 == 0 && i != 0) {
				System.out.println();
			}
		}
	}
	
}
