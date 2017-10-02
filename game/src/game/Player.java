package game;

public class Player {
	
	//分数
	private int grade;
	//类别 1：玩家 0：电脑
	private int sort;
	//状态 1:hold 2:roll again 3:roll and again hold 4:结束
	private int status;
	//名称
	private String name;
	public Player(int sort,int grade, int status,String name) {
		this.sort = sort;
		this.grade = grade; 
		this.status = status;
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "玩家："+this.name+",分数："+this.grade;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
	
	
}
