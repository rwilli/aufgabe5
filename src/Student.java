/**
 * Student class extends Person
 * 
 * @author Gruppe222
 */
public class Student extends Person {
	
	private int matrNr;
	
	public Student(String name) {
		super(name);
	}
	
	public Student(String name, int nr) {
		super(name);
		this.matrNr = nr;
	}

	public int getMatrNr() {
		return matrNr;
	}

	public void setMatrNr(int matrNr) {
		this.matrNr = matrNr;
	}

	@Override
	public String toString() {
		return this.name + " " + this.matrNr;
	}
	
}
