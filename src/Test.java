
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Person p = new Student("Franz");
		Person p1 = new Professor("Franz");
		
		System.out.println(p.name.compareTo(p1.name));
		
		
		
		/*
		 * Testcases
		 * 
		 * 
		 * ReplaceableTree<String>
		 * 
		 * InorderTree<Integer>
		 * 
		 * PreorderTree<Student>
		 * 
		 * PostorderTree<Professor>
		 * 
		 * 
		 * 
		 * ReplaceableTree<Person>
		 * 
		 * add Student + Professor
		 * 
		 * ersetzen durch PreorderTree<Student> und PostorderTree<Professor>
		 * 
		 */
	}

}
