/**
 * Student class extends Person
 * 
 * @author Gruppe222
 */
public class Student extends Person {

	private int matrNr;

	/**
	 * Constructor with name as parameter. Calls the constructor of the super
	 * class.
	 * 
	 * @param name
	 *            as string
	 */
	public Student(String name) {
		super(name);
	}

	/**
	 * Constructo with name and nr as parameters. Calls the constructor of the
	 * super class to set the name.
	 * 
	 * @param name
	 *            as string
	 * @param nr
	 *            as integer
	 */
	public Student(String name, int nr) {
		super(name);
		this.matrNr = nr;
	}

	/**
	 * Getter for the matrikelnummer.
	 * 
	 * @return matrNr as integer.
	 */
	public int getMatrNr() {
		return matrNr;
	}

	/**
	 * Setter for the matrikelnummer.
	 * 
	 * @param matrNr
	 *            as Integer
	 */
	public void setMatrNr(int matrNr) {
		this.matrNr = matrNr;
	}

	/*
	 * (non-Javadoc)
	 * @see Person#toString()
	 */
	@Override
	public String toString() {
		return this.name + " " + this.matrNr;
	}

}
