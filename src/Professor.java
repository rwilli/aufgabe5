
public class Professor extends Person {
	private String institut;
	
	public Professor(String name) {
		super(name);
	}
	
	public Professor(String name, String institut) {
		super(name);
		this.institut = institut;
	}

	public String getInstitut() {
		return institut;
	}

	public void setInstitut(String institut) {
		this.institut = institut;
	}

	@Override
	public int compareTo(Person that) {
		// TODO Auto-generated method stub
		return 0;
	}

}
