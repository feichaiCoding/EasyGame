package easyGame.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Initial {
	private List<Poker> tempPokerList;//打乱顺序扑克容器
	private int pokerIndex;//发牌计数器
	
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
	//洗牌方法一
	public int[] generateValue(int len) {//产生len个不重复的随机数
		int[] indexArr = new int[len];
		Random random = new Random();//产生随机数
		//先产生一个顺序数组
		for (int i = 0; i < len; i++) {
			indexArr[i] = i;
		}
		//然后打乱
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
	//洗牌方法二
	public void shufflePoker(Poker poker) {
		//setTempPokerList(poker.getPokerList());//由于shuffle会打乱原本数组，所以如果不想原集合被打乱应该将其放入一个临时容器中
		for (int i = 0; i < poker.getPokerList().size(); i++) {
			getTempPokerList().add(poker.getPokerList().get(i));
		}
		Collections.shuffle(getTempPokerList());
	}
	//打印乱序后的扑克
	public void printPoker() {
		System.out.println("乱序后的扑克：");
		for (int i = 0; i < getTempPokerList().size(); i++) {
			System.out.print("["+getTempPokerList().get(i).getPokerType()+getTempPokerList().get(i).getPokerValue()+"] ");
			if((i+1)%13 == 0 && i != 0) {
				System.out.println();
			}
		}
	}
	
	//发牌
	public void allocaPoker(int alloPokerNum, Gamer gamer) {
		System.out.println("-------------发牌开始---------------");
		for (int i = 0; i < alloPokerNum; i++) {
			for (int j = 0; j < gamer.getGamerList().size(); j++) {
				System.out.println("玩家["+gamer.getGamerList().get(j).getGamerName()+"]拿牌");
				gamer.getGamerList().get(j).getTempPokerList().add(getTempPokerList().get(getPokerIndex()));
				setPokerIndex(getPokerIndex()+1);//计数器加1
			}
		}
		System.out.println("-------------发牌结束---------------");
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
		int maxPokerIndex = pokerIndexArr[0];//每个玩家最大手牌索引值
		for (int i = 0; i < pokerIndexArr.length; i++) {
			if(maxPokerIndex < pokerIndexArr[i]) {
				maxPokerIndex = pokerIndexArr[i];
			}
		}
		System.out.println(maxPokerIndex+"玩家["+gamer.getGamerName()+"]最大手牌："+poker.getPokerList().get(maxPokerIndex).getPokerType() + poker.getPokerList().get(maxPokerIndex).getPokerValue());
		return maxPokerIndex;
	}
	//开始游戏(大小比较黑红梅芳)
	public void startPlayGame(int alloPokerNum, Gamer gamer, Poker poker) {
		System.out.println("开始游戏：");
		
		int gamerNum = gamer.getGamerList().size();
		int[] maxGamerIndexArr = new int[gamerNum];//每个玩家各自最大手牌索引值
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
		System.out.println("恭喜玩家["+gamer.getGamerList().get(winIndex).getGamerName()+"]获胜");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Initial initial = new Initial();
		//1、创建扑克
		Poker poker = new Poker();
		poker.creatPoker();
		poker.printPoker(); 
		//2、洗牌
		initial.shufflePoker(poker);
		//initial.washPoker(poker);
		//initial.printPoker();
		//poker.printPoker();
		//3、创建玩家
		Gamer gamer = new Gamer();
		gamer.creatGamer();
		//4、发牌
		System.out.println("请输入发牌数");
		int pokerNum = 1;
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				pokerNum = scan.nextInt();
				if(pokerNum < 1) {
					System.out.println("请输入有效发牌数(>0)");
					continue;
				}else {
					break;
				}
				
			} catch (Exception e) {
				System.out.println("请输入整型类型的发牌数");
			}
		}
		
		initial.allocaPoker(pokerNum, gamer);
		gamer.printGamersPoker();
		//5、开始游戏
		initial.startPlayGame(pokerNum, gamer, poker);
	}

}
