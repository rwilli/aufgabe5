
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		/*Person p = new Student("Franz");
		Person p1 = new Professor("Franz");
		
		System.out.println(p.name.compareTo(p1.name));*/
		
		
		
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
		System.out.println("----------ReplaceableTree----------");
		ReplaceableTree<String> tree1 = new ReplaceableTree<String>();
		tree1.add("Foul");
		tree1.add("Zitrone");
		tree1.add("Kugel");
		tree1.add("Banane");
		tree1.add("hugo");
		tree1.add("Ludwig");
		tree1.add("Anna");
		
		System.out.println("--Tree Ausgabe");
		TreeIter<String> it1 = tree1.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next().toString() + " ");
		}
		
		/*it1 = tree1.contains("Bananae");
		
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		tree1.contains("Kirsche");
		
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		Iter<Boolean> i1 = tree1.search(("Ludwig"));
		*/
		
		/*InorderTree<Integer> tree2 = new InorderTree<Integer>();
		tree2.add(new Integer(23));
		tree2.add(new Integer(11));
		tree2.add(new Integer(4));
		tree2.add(new Integer(34));
		tree2.add(new Integer(9));
		tree2.add(new Integer(56));*/
		System.out.println();
		System.out.println("-----PreorderTree-----");
		PreorderTree<Student> tree3 = new PreorderTree<Student>();
		tree3.add(new Student("Hugo Test", 1));
		tree3.add(new Student("Max Mustermann", 2));
		tree3.add(new Student("Fritz Fritzmann", 5));
		tree3.add(new Student("Otto Haber", 7));
		tree3.add(new Student("Kurt Bach", 4));
		tree3.add(new Student("Anna Berg", 9));
		
		System.out.println("--Tree Ausgabe");
		TreeIter<Student> it3 = tree3.iterator();
		while (it3.hasNext()) {
			System.out.print(it3.next().toString() + " ");
		}
		System.out.println();
		System.out.println("--Tree contains");
		it3 = tree3.contains(new Student("Max Mustermann", 2));
		
		while (it3.hasNext()) {
			System.out.print(it3.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree Search");
		Iter<Boolean> it4 = tree3.search(new Student("Kurt Bach", 4));
		
		while (it4.hasNext()) {
			System.out.print(it4.next());
		}
		
		System.out.println();
		System.out.println("-----PostorderTree-----");
		PostorderTree<Professor> tree4 = new PostorderTree<Professor>();
		tree4.add(new Professor("Florian Proll", "Informatik"));
		tree4.add(new Professor("Anton Wall", "Elektronik"));
		tree4.add(new Professor("Lukas Schreiber", "Physik"));
		tree4.add(new Professor("Josef Haller", "Informatik"));
		tree4.add(new Professor("Patrick Graber", "Chemie"));
		
		TreeIter<Professor> it5 = tree4.iterator();
		while (it5.hasNext()) {
			System.out.print(it5.next().toString() + " ");
		}
		
		System.out.println();
		System.out.println("-----InorderTree-----");
		InorderTree<Professor> tree5 = new InorderTree<Professor>();
		tree5.add(new Professor("Florian Proll", "Informatik"));
		tree5.add(new Professor("Anton Wall", "Elektronik"));
		tree5.add(new Professor("Lukas Schreiber", "Physik"));
		tree5.add(new Professor("Josef Haller", "Informatik"));
		tree5.add(new Professor("Patrick Graber", "Chemie"));
		
		TreeIter<Professor> it6 = tree5.iterator();
		while (it6.hasNext()) {
			System.out.print(it6.next().toString() + " ");
		}
		
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
