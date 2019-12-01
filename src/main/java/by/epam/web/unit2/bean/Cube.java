package by.epam.web.unit2.bean;

import java.io.Serializable;

public class Cube implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private int id;
	private Point pointA;  //���� ����� ��������� � ����, ����� ������ ����� �� ����������
	private Point pointB;
	private Point pointC;
	private Point pointD;
	private double side=-1; //��� �������� � ��������, ��� ��������� ������������ ����������: �������� �� ������������� ����, 
	//���������� ������� � ��. 
	
	//��� ���������� ���� ����� 4 ����� ��� ���������� 3 �������� � ����� �������


	public Cube() {
	}

	public Cube(Point p1, Point p2, Point p3, Point p4) {
		
		pointA = p1;
		pointB = p2;
		pointC = p3;
		pointD = p4;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSide() {
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointA == null) ? 0 : pointA.hashCode());
		result = prime * result + ((pointB == null) ? 0 : pointB.hashCode());
		result = prime * result + ((pointC == null) ? 0 : pointC.hashCode());
		result = prime * result + ((pointD == null) ? 0 : pointD.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cube other = (Cube) obj;
		if (pointA == null) {
			if (other.pointA != null)
				return false;
		} else if (!pointA.equals(other.pointA))
			return false;
		if (pointB == null) {
			if (other.pointB != null)
				return false;
		} else if (!pointB.equals(other.pointB))
			return false;
		if (pointC == null) {
			if (other.pointC != null)
				return false;
		} else if (!pointC.equals(other.pointC))
			return false;
		if (pointD == null) {
			if (other.pointD != null)
				return false;
		} else if (!pointD.equals(other.pointD))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cube [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", pointD=" + pointD + "]";
	}

	
	
	

}
