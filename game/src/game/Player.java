package game;

public class Player {
	
	//����
	private int grade;
	//��� 1����� 0������
	private int sort;
	//״̬ 1:hold 2:roll again 3:roll and again hold 4:����
	private int status;
	//����
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
		return "��ң�"+this.name+",������"+this.grade;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
	
	
}
