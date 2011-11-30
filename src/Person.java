/**
 * Abstract class Person implements Comparable<Person>
 * 
 * @author Gruppe222
 * 
 */
public abstract class Person implements Comparable<Person> {

	protected String name;

	/**
	 * Constructor sets the name of a new Person
	 * 
	 * @param name
	 *            as string.
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Compares two persons' names.
	 * 
	 * @param that
	 *            another Person.
	 * @return -1, 0, or 1
	 */
	public int compareTo(Person that) {

		for (int i = 0; i < this.name.length() && i < that.name.length(); i++) {

			if (this.name.charAt(i) < that.name.charAt(i))
				return -1;

			if (this.name.charAt(i) > that.name.charAt(i))
				return 1;

		}

		if (this.name.length() < that.name.length())
			return -1;
		if (this.name.length() > that.name.length())
			return 1;

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
			// added name comparison to equals
		} else if (name.compareTo(other.name) != 0)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
