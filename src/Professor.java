/**
 * Class professor extends person
 * 
 * @author Gruppe222
 * 
 */
public class Professor extends Person {
	private String institut;

	/**
	 * Constructor with name as parameter calls the super constructor.
	 * 
	 * @param name
	 *            a string
	 */
	public Professor(String name) {
		super(name);
	}

	/**
	 * Constructor with name and institut as parameters. Calls the super
	 * constructor for setting the name.
	 * 
	 * @param name
	 *            as string
	 * @param institut
	 *            as string
	 */
	public Professor(String name, String institut) {
		super(name);
		this.institut = institut;
	}

	/**
	 * Getter method for institut.
	 * 
	 * @return institut as string.
	 */
	public String getInstitut() {
		return institut;
	}

	/**
	 * Setter method for institut.
	 * 
	 * @param institut
	 *            as string.
	 */
	public void setInstitut(String institut) {
		this.institut = institut;
	}

	/*
	 * (non-Javadoc)
	 * @see Person#toString()
	 */
	@Override
	public String toString() {
		return this.name + " " + this.institut;
	}

}
