package com.kh.semiProject.professor.model.vo;

public class ClsPlan extends ProfessorClass {
	
	private String goal;
	private String book;
	private String pGrade;
	private String pGrade2;
	private String pPlan;
	private String etc;
	private String cheat;
	
	public ClsPlan() {
		super();
	}
	
	public ClsPlan(String prf_no, String cls_no, String cls_name, int capacity, int days, int average, int year,
			int semester, String cls_type) {
		super(prf_no, cls_no, cls_name, capacity, days, average, year, semester, cls_type);
	}
	
	public ClsPlan(String prf_no, String cls_no, String cls_name, int capacity, int average, int year, int semester) {
		super(prf_no, cls_no, cls_name, capacity, average, year, semester);
	}
	
	public ClsPlan(String goal, String book, String pGrade, String pGrade2, String pPlan, String etc, String cheat) {
		super();
		this.goal = goal;
		this.book = book;
		this.pGrade = pGrade;
		this.pGrade2 = pGrade2;
		this.pPlan = pPlan;
		this.etc = etc;
		this.cheat = cheat;
	}
	
	@Override
	public String toString() {
		return "ClsPlan [goal=" + goal + ", book=" + book + ", pGrade=" + pGrade + ", pGrade2=" + pGrade2 + ", pPlan="
				+ pPlan + ", etc=" + etc + ", cheat=" + cheat + "]";
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getpGrade() {
		return pGrade;
	}

	public void setpGrade(String pGrade) {
		this.pGrade = pGrade;
	}

	public String getpGrade2() {
		return pGrade2;
	}

	public void setpGrade2(String pGrade2) {
		this.pGrade2 = pGrade2;
	}

	public String getpPlan() {
		return pPlan;
	}

	public void setpPlan(String pPlan) {
		this.pPlan = pPlan;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getCheat() {
		return cheat;
	}

	public void setCheat(String cheat) {
		this.cheat = cheat;
	}
	
}
