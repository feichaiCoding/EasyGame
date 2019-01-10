package easyGame.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Initial {
	private List<Poker> tempPokerList;//����˳���˿�����
	private int pokerIndex;//���Ƽ�����
	
	public List<Poker> getTempPokerList() {
		return tempPokerList;
	}
	public void setTempPokerList(List<Poker> tempPokerList) {
		this.tempPokerList = tempPokerList;
	}
	
	public int getPokerIndex() {
		return pokerIndex;
	}
	public void setPokerIndex(int pokerIndex) {
		this.pokerIndex = pokerIndex;
	}
	public Initial() {
		setPokerIndex(0);
		setTempPokerList(new ArrayList<Poker>());
	}
	//ϴ�Ʒ���һ
	public int[] generateValue(int len) {//����len�����ظ��������
		int[] indexArr = new int[len];
		Random random = new Random();//���������
		//�Ȳ���һ��˳������
		for (int i = 0; i < len; i++) {
			indexArr[i] = i;
		}
		//Ȼ�����
		for (int i = 0; i < indexArr.length; i++) {
			//int tempIndex = random.nextInt(len);
			int tempIndex = (int) (Math.random() * len);
			indexArr = swap(indexArr, tempIndex, i);
		}
		return indexArr;
	} 
	private int[] swap(int[] arr, int swapIndex, int index) {
		// TODO Auto-generated method stub
		int temp = arr[index];
		arr[index] = arr[swapIndex];
		arr[swapIndex] = temp;
		return arr;
	}
	public void washPoker(Poker poker) {
		int pokerNum = poker.getPokerList().size();
		List<Integer> list = new ArrayList<Integer>();
		int[] tempArr = generateValue(pokerNum);
		for (int i = 0; i < tempArr.length; i++) {
			getTempPokerList().add(poker.getPokerList().get(tempArr[i]));
		}
		
	}
	//ϴ�Ʒ�����
	public void shufflePoker(Poker poker) {
		//setTempPokerList(poker.getPokerList());//����shuffle�����ԭ�����飬�����������ԭ���ϱ�����Ӧ�ý������һ����ʱ������
		for (int i = 0; i < poker.getPokerList().size(); i++) {
			getTempPokerList().add(poker.getPokerList().get(i));
		}
		Collections.shuffle(getTempPokerList());
	}
	//��ӡ�������˿�
	public void printPoker() {
		System.out.println("�������˿ˣ�");
		for (int i = 0; i < getTempPokerList().size(); i++) {
			System.out.print("["+getTempPokerList().get(i).getPokerType()+getTempPokerList().get(i).getPokerValue()+"] ");
			if((i+1)%13 == 0 && i != 0) {
				System.out.println();
			}
		}
	}
	
	//����
	public void allocaPoker(int alloPokerNum, Gamer gamer) {
		System.out.println("-------------���ƿ�ʼ---------------");
		for (int i = 0; i < alloPokerNum; i++) {
			for (int j = 0; j < gamer.getGamerList().size(); j++) {
				System.out.println("���["+gamer.getGamerList().get(j).getGamerName()+"]����");
				gamer.getGamerList().get(j).getTempPokerList().add(getTempPokerList().get(getPokerIndex()));
				setPokerIndex(getPokerIndex()+1);//��������1
			}
		}
		System.out.println("-------------���ƽ���---------------");
	}
	
	public int checkSelfPoker(int alloPokerNum, Gamer gamer, Poker poker) {
		int[] pokerIndexArr = new int[alloPokerNum];
		for (int i = 0; i < alloPokerNum; i++) {
			String tempStr1 = gamer.getTempPokerList().get(i).getPokerType() + gamer.getTempPokerList().get(i).getPokerValue();
			for (int j = 0; j < poker.getPokerList().size(); j++) {
				String tempStr2 = poker.getPokerList().get(j).getPokerType() + poker.getPokerList().get(j).getPokerValue();
				if(tempStr1.equals(tempStr2)) {
					pokerIndexArr[i] = j;
					break;
				}
			}
			
		}
		int maxPokerIndex = pokerIndexArr[0];//ÿ����������������ֵ
		for (int i = 0; i < pokerIndexArr.length; i++) {
			if(maxPokerIndex < pokerIndexArr[i]) {
				maxPokerIndex = pokerIndexArr[i];
			}
		}
		System.out.println(maxPokerIndex+"���["+gamer.getGamerName()+"]������ƣ�"+poker.getPokerList().get(maxPokerIndex).getPokerType() + poker.getPokerList().get(maxPokerIndex).getPokerValue());
		return maxPokerIndex;
	}
	//��ʼ��Ϸ(��С�ȽϺں�÷��)
	public void startPlayGame(int alloPokerNum, Gamer gamer, Poker poker) {
		System.out.println("��ʼ��Ϸ��");
		
		int gamerNum = gamer.getGamerList().size();
		int[] maxGamerIndexArr = new int[gamerNum];//ÿ����Ҹ��������������ֵ
		for (int i = 0; i < gamerNum; i++) {
			maxGamerIndexArr[i] = checkSelfPoker(alloPokerNum, gamer.getGamerList().get(i), poker);
		}
		int winIndex = 0;
		int maxIndex = maxGamerIndexArr[0];
		for (int i = 0; i < maxGamerIndexArr.length; i++) {
			if(maxIndex < maxGamerIndexArr[i]) {
				maxIndex = maxGamerIndexArr[i];
				winIndex = i;
			}
		}
		System.out.println("��ϲ���["+gamer.getGamerList().get(winIndex).getGamerName()+"]��ʤ");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Initial initial = new Initial();
		//1�������˿�
		Poker poker = new Poker();
		poker.creatPoker();
		poker.printPoker(); 
		//2��ϴ��
		initial.shufflePoker(poker);
		//initial.washPoker(poker);
		//initial.printPoker();
		//poker.printPoker();
		//3���������
		Gamer gamer = new Gamer();
		gamer.creatGamer();
		//4������
		System.out.println("�����뷢����");
		int pokerNum = 1;
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				pokerNum = scan.nextInt();
				if(pokerNum < 1) {
					System.out.println("��������Ч������(>0)");
					continue;
				}else {
					break;
				}
				
			} catch (Exception e) {
				System.out.println("�������������͵ķ�����");
			}
		}
		
		initial.allocaPoker(pokerNum, gamer);
		gamer.printGamersPoker();
		//5����ʼ��Ϸ
		initial.startPlayGame(pokerNum, gamer, poker);
	}

}
