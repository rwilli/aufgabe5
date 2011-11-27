
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Person p = new Student("Franz");
		Person p1 = new Professor("Franz");
		
		System.out.println(p.name.compareTo(p1.name));
		
		
		
		/*
		 * Testcase 1
		 * 
		 * ReplaceableTree<String>
		 *
		 * InorderTree<Integer>
		 * 
		 * PreorderTree<Student>
		 * 
		 * PostorderTree<Professor>
		 * 
		 */ 
		ReplaceableTree<String> tree1 = new ReplaceableTree<String>();
		tree1.add("Foul");
		tree1.add("Zitrone");
		tree1.add("Kugel");
		tree1.add("Banane");
		tree1.add("hugo");
		tree1.add("Ludwig");
		tree1.add("Anna");
		
		
		/*InorderTree<Integer> tree2 = new InorderTree<Integer>();
		tree2.add(new Integer(23));
		tree2.add(new Integer(11));
		tree2.add(new Integer(4));
		tree2.add(new Integer(34));
		tree2.add(new Integer(9));
		tree2.add(new Integer(56));*/
		
		PreorderTree<Student> tree3 = new PreorderTree<Student>();
		tree3.add(new Student("Hugo Test", 1));
		tree3.add(new Student("Max Mustermann", 2));
		tree3.add(new Student("Fritz Fritzmann", 5));
		tree3.add(new Student("Otto Haber", 7));
		tree3.add(new Student("Kurt Bach", 4));
		tree3.add(new Student("Anna Berg", 9));
		
		PostorderTree<Professor> tree4 = new PostorderTree<Professor>();
		tree4.add(new Professor("Florian Proll", "Informatik"));
		tree4.add(new Professor("Anton Wall", "Elektronik"));
		tree4.add(new Professor("Lukas Schreiber", "Physik"));
		tree4.add(new Professor("Josef Haller", "Informatik"));
		tree4.add(new Professor("Patrick Graber", "Chemie"));
		
		
		/*
		 * Testcase 2
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
