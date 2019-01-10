package easyGame.com;

import java.util.ArrayList;
import java.util.List;

/**
 * �˿���
 * @author SHsama
 *
 */
public class Poker {
	private String pokerType;//�˿˻�ɫ
	private String pokerValue;//�˿˴�С
	
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
		setPokerTypeArr(new String[]{"����", "÷��", "����", "����"});
		setPokerValueArr(new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"});
		setPokerList(new ArrayList<Poker>());
	}
	public Poker(String pokerType, String pokerValue) {
		setPokerType(pokerType);
		setPokerValue(pokerValue);
	}
	
	//�����˿���
	public void creatPoker() {
		System.out.println("�����˿��У����Ե�...");
		
		for (String type : getPokerTypeArr()) {
			for (String value : getPokerValueArr()) {
				Poker poker = new Poker(type, value);
				getPokerList().add(poker);
			}
		}
		
	}
	
	//��ʾ�������˿���
	public void printPoker() {
		System.out.println("�����ɹ���");
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
