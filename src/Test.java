
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
		/*ReplaceableTree<String> tree1 = new ReplaceableTree<String>();
		tree1.add("Foul");
		tree1.add("Zitrone");
		tree1.add("Kugel");
		tree1.add("Banane");
		tree1.add("hugo");
		tree1.add("Ludwig");
		tree1.add("Anna");
		
		TreeIter<String> it1 = tree1.contains("Bananae");
		
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		tree1.contains("Kirsche");
		
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		Iter<Boolean> i1 = tree1.search(("Ludwig"));*/
		
		
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
		
		TreeIter<Student> it3 = tree3.iterator();
		System.out.println(it3.next());
		while (it3.hasNext()) {
			System.out.println(it3.next().toString());
		}
		
		/*it3 = tree3.contains(new Student("Otto Haber", 7));
		
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		Iter<Boolean> it4 = tree3.search(new Student("Kurt Bach", 4));
		
		while (it4.hasNext()) {
			System.out.println(it4.next());
		}
		
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
