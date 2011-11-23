
public class Professor extends Person {
	private int institut;
	
	public Professor(String name) {
		this.name = name;
	}
	
	public Professor(String name, int institut) {
		this.name = name;
		this.institut = institut;
	}

	public int getInstitut() {
		return institut;
	}

	public void setInstitut(int institut) {
		this.institut = institut;
	}

}
