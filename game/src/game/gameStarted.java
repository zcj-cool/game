package game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class gameStarted {

	public static void main(String[] args) {
		
		//�½�һ�����
		Player player1 = new Player(1,0,3,"���1");
		//�½�һ�����
		Player player2 = new Player(1,0,3,"���2");
		//�½�һ������
		Player computer = new Player(0,0,3,"����");
		List<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(computer);
		System.out.println("game is started:");
		//������
		playGame(players);
		
	}
	private static void playGame(List<Player> players) {
		Scanner reader= null;
		Player win = null;
		try {
			while (true) {
				for (Player player : players) {
					while (true) {
					System.out.println("������ң�"+player.getName());
					//������������
					int t1 = getRandomOfInt(6);
					int t2 = getRandomOfInt(6);
					System.out.println("����1��"+t1+"  ����2��"+t2);
					//ִ���߼�
					luoji(t1,t2,player);
					//��������100����
					if(player.getGrade()>=100){
						win = player;
						break;
					//�����غ�
					}else if (player.getStatus()==4) {
						break;	
					}else {
							System.out.println("����������...\n");
							reader = new Scanner(System.in);
							String a = reader.nextLine();
							int status = player.getStatus();
							if(player.getGrade()>40&&player.getSort()==0&&player.getStatus()!=2){
								System.out.println("���Դ���40�֣���hold��hold");
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
			System.out.println("��Ϸ������ʤ���ߣ�"+win.getName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			reader.close();
		}
		
		
	}

	private static void luoji(int t1, int t2, Player player) {
		int grade = player.getGrade();
		System.out.println("��ǰ������"+grade);
		if(t1 == t2){
            if(t1 == 1) {
            	player.setGrade(grade+=25);
    			player.setStatus(2);
    			System.out.println("��ң�"+player.getName()+"���������Ӷ���1����25�֣�����roll again������Ϊ��"+player.getGrade());
            }
            else {
            	player.setGrade(grade+=(t1+t2)*2);
    			player.setStatus(2);
    			System.out.println("��ң�"+player.getName()+"��ֻ����������ͬ������Ϊ�������ӵ���֮�͵����������� roll again,����Ϊ��"+player.getGrade());
            }
        }
        else if(t1 == 1 || t2 == 1){
        	System.out.println("��ң�"+player.getName()+"��ֻ��һ��������1��������Ϊ0�֣�������غ�");
			player.setGrade(0);
			player.setStatus(4);
        }
        else{
        	player.setGrade(grade+=(t1+t2));
			player.setStatus(3);
			System.out.println("��ң�"+player.getName()+"���������Ӳ�ͬ������Ϊ��������֮������ҿ���ѡ��hold��roll again,����Ϊ��"+player.getGrade());
        }
	
	}
	//��ȡ�����
	public static int getRandomOfInt(int max){
		Random r = new Random();
		if(max>=0){
			return r.nextInt(max);
		}else{
			return r.nextInt();
		}
	};

}
