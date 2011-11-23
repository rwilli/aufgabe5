
public class Student extends Person {
	private int matrNr;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, int nr) {
		this.name = name;
		this.matrNr = nr;
	}

	public int getMatrNr() {
		return matrNr;
	}

	public void setMatrNr(int matrNr) {
		this.matrNr = matrNr;
	}

}
