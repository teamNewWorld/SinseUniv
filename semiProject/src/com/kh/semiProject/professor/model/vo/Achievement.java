package com.kh.semiProject.professor.model.vo;

public class Achievement extends ProfessorClass {

	private static final long serialVersionUID = 1682L;
	
	private double point;
	private String correction;
	private String retake;
	
	public Achievement() { super(); }
	
	public Achievement(String prf_no, String cls_no, String cls_name, int capacity, int days, int average, int year,
			int semester, String cls_type) {
		super(prf_no, cls_no, cls_name, capacity, days, average, year, semester, cls_type);
	}
	
	public Achievement(String prf_no, String cls_no, String cls_name, int capacity, int average, int year,
			int semester) {
		super(prf_no, cls_no, cls_name, capacity, average, year, semester);
	}

	public Achievement(double point, String correction, String retake) {
		super();
		this.point = point;
		this.correction = correction;
		this.retake = retake;
	}



	@Override
	public String toString() {
		return "Achievement [point=" + point + ", correction=" + correction + ", retake=" + retake + ", getAverage()="
				+ getAverage() + ", getYear()=" + getYear() + ", getSemester()=" + getSemester() + ", getCls_type()="
				+ getCls_type() + ", getCls_no()=" + getCls_no() + ", getCls_name()=" + getCls_name()
				+ ", getDeptName()=" + getDeptName() + "]";
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getCorrection() {
		return correction;
	}

	public void setCorrection(String correction) {
		this.correction = correction;
	}

	public String getRetake() {
		return retake;
	}

	public void setRetake(String retake) {
		this.retake = retake;
	}
	
	
	
	
}
