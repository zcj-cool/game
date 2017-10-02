package game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class gameStarted {

	public static void main(String[] args) {
		
		//新建一个玩家
		Player player1 = new Player(1,0,3,"玩家1");
		//新建一个玩家
		Player player2 = new Player(1,0,3,"玩家2");
		//新建一个电脑
		Player computer = new Player(0,0,3,"电脑");
		List<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(computer);
		System.out.println("game is started:");
		//主程序
		playGame(players);
		
	}
	private static void playGame(List<Player> players) {
		Scanner reader= null;
		Player win = null;
		try {
			while (true) {
				for (Player player : players) {
					while (true) {
					System.out.println("本轮玩家："+player.getName());
					//创建两个骰子
					int t1 = getRandomOfInt(6);
					int t2 = getRandomOfInt(6);
					System.out.println("骰子1："+t1+"  骰子2："+t2);
					//执行逻辑
					luoji(t1,t2,player);
					//分数大于100结束
					if(player.getGrade()>=100){
						win = player;
						break;
					//结束回合
					}else if (player.getStatus()==4) {
						break;	
					}else {
							System.out.println("请重新输入...\n");
							reader = new Scanner(System.in);
							String a = reader.nextLine();
							int status = player.getStatus();
							if(player.getGrade()>40&&player.getSort()==0&&player.getStatus()!=2){
								System.out.println("电脑大于40分，能hold就hold");
								break;
							}else if("hold".equals(a)&&status<4&&status>=1&&status!=2){
								break;
							}
							
						
					}
					}
				}	
				if (win!=null) {
					break;
				}
			}
			System.out.println("游戏结束，胜利者："+win.getName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			reader.close();
		}
		
		
	}

	private static void luoji(int t1, int t2, Player player) {
		int grade = player.getGrade();
		System.out.println("当前分数："+grade);
		if(t1 == t2){
            if(t1 == 1) {
            	player.setGrade(grade+=25);
    			player.setStatus(2);
    			System.out.println("玩家："+player.getName()+"：两个骰子都是1，加25分，必须roll again，分数为："+player.getGrade());
            }
            else {
            	player.setGrade(grade+=(t1+t2)*2);
    			player.setStatus(2);
    			System.out.println("玩家："+player.getName()+"：只两个骰子相同，分数为两个骰子点数之和的两倍，必须 roll again,分数为："+player.getGrade());
            }
        }
        else if(t1 == 1 || t2 == 1){
        	System.out.println("玩家："+player.getName()+"：只有一个骰子是1，分数变为0分，结束这回合");
			player.setGrade(0);
			player.setStatus(4);
        }
        else{
        	player.setGrade(grade+=(t1+t2));
			player.setStatus(3);
			System.out.println("玩家："+player.getName()+"：两个骰子不同，分数为两个骰子之和且玩家可以选择hold或roll again,分数为："+player.getGrade());
        }
	
	}
	//获取随机数
	public static int getRandomOfInt(int max){
		Random r = new Random();
		if(max>=0){
			return r.nextInt(max);
		}else{
			return r.nextInt();
		}
	};

}
