/**
 * Abstract class Person
 * 
 * @author Gruppe222
 *
 */
public abstract class Person implements Comparable<String> {
	
	protected String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public int compareTo(String that) {
		
		for(int i = 0; i < this.name.length() && i < that.length(); i++){
			
			if (this.name.charAt(i) < that.charAt(i)) return -1;
	
			if (this.name.charAt(i) > that.charAt(i) ) return 1;
					
		}
		
		if(this.name.length() < that.length()) return -1;
		if(this.name.length() > that.length()) return 1;		
		
		return 0;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (name.compareTo(other.name) != 0)
			return false;
		return true;
	}
	
	public String toString() {
		return this.name;
	}

}
