
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		System.out.println("----------ReplaceableTree<String>----------");
		
		ReplaceableTree<String> tree1 = new ReplaceableTree<String>();
		tree1.add("Foul");
		tree1.add("Zitrone");
		tree1.add("Kugel");
		tree1.add("Banane");
		tree1.add("hugo");
		tree1.add("Ludwig");
		tree1.add("Anna");
		
		System.out.println("--Tree toString()");
		System.out.println(tree1);
		
		System.out.println("--Tree Ausgabe Inorder");
		
		TreeIter<String> it1_tree1 = tree1.iterator();
		
		while (it1_tree1.hasNext()) {
			System.out.print(it1_tree1.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree contains Zitrone - Ausgabe Inorder");
		
		it1_tree1 = tree1.contains("Zitrone");
		
		while (it1_tree1.hasNext()) {
			System.out.print(it1_tree1.next() + " ");
		}
	
		System.out.println();
		System.out.println("--Tree Search hugo");
		
		Iter<Boolean> it2_tree1 = tree1.search("hugo");
		
		while (it2_tree1.hasNext()) {
			System.out.print(it2_tree1.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree Replace ");
		ReplaceableTree<String> tree1_1 = new ReplaceableTree<String>();
		tree1_1.add("Tor");
		tree1_1.add("Zeitung");
		tree1_1.add("Handy");
		
		System.out.println("--Tree Ausgabe Inorder");
		
		TreeIter<String> it1_tree1_1 = tree1_1.iterator();
		
		while (it1_tree1_1.hasNext()) {
			System.out.print(it1_tree1_1.next() + " ");
		}
		
		//TODO
		//tree1.replace(position, tree);
		
		System.out.println();
		System.out.println("----------InorderTree<Integer>----------");
		
		InorderTree<Integer> tree2 = new InorderTree<Integer>();
		tree2.add(new Integer(23));
		tree2.add(new Integer(11));
		tree2.add(new Integer(4));
		tree2.add(new Integer(34));
		tree2.add(new Integer(9));
		tree2.add(new Integer(56));
		
		System.out.println("--Tree toString()");
		System.out.println(tree2);
		
		System.out.println("--Tree Ausgabe");
		
		TreeIter<Integer> it1_tree2 = tree2.iterator();
		
		while (it1_tree2.hasNext()) {
			System.out.print(it1_tree2.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree contains 4");
		
		it1_tree2 = tree2.contains(4);
		
		while (it1_tree2.hasNext()) {
			System.out.print(it1_tree2.next() + " ");
		}
	
		System.out.println();
		System.out.println("--Tree Search 9");
		
		Iter<Boolean> it2_tree2 = tree2.search(9);
		
		while (it2_tree2.hasNext()) {
			System.out.print(it2_tree2.next() + " ");
		}
		
		System.out.println();
		System.out.println("-----PreorderTree-----");
		
		PreorderTree<Student> tree3 = new PreorderTree<Student>();
		tree3.add(new Student("Hugo Sanchez", 1));
		tree3.add(new Student("Maria Schreiber", 2));
		tree3.add(new Student("Fadi Lumba", 5));
		tree3.add(new Student("Otto Karl", 7));
		tree3.add(new Student("Kurt Weniger", 4));
		tree3.add(new Student("Anna Bach", 9));
		
		System.out.println("--Tree toString()");
		System.out.println(tree3);
		
		System.out.println("--Tree Ausgabe");
		
		TreeIter<Student> it1_tree3 = tree3.iterator();
		
		while (it1_tree3.hasNext()) {
			System.out.print(it1_tree3.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree contains Fadi Lumba");
		it1_tree3 = tree3.contains(new Student("Fadi Lumba", 5));
		
		while (it1_tree3.hasNext()) {
			System.out.print(it1_tree3.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree Search Kurt Bach");
		Iter<Boolean> it2_tree3 = tree3.search(new Student("Kurt Bach", 4));
		
		while (it2_tree3.hasNext()) {
			System.out.print(it2_tree3.next() + " ");
		}
		
		System.out.println();
		System.out.println("-----PostorderTree-----");
		
		PostorderTree<Professor> tree4 = new PostorderTree<Professor>();
		tree4.add(new Professor("Florian Proll", "Informatik"));
		tree4.add(new Professor("Anton Wall", "Elektronik"));
		tree4.add(new Professor("Lukas Schreiber", "Physik"));
		tree4.add(new Professor("Josef Haller", "Informatik"));
		tree4.add(new Professor("Patrick Graber", "Chemie"));
		
		System.out.println("--Tree toString()");
		System.out.println(tree4);
		
		TreeIter<Professor> it1_tree4 = tree4.iterator();
		
		while (it1_tree4.hasNext()) {
			System.out.print(it1_tree4.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree contains Anton Wall");
		it1_tree4 = tree4.contains(new Professor("Anton Wall", "Elektronik"));
		
		while (it1_tree4.hasNext()) {
			System.out.print(it1_tree4.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree Search Josef Haller");
		Iter<Boolean> it2_tree4 = tree4.search(new Professor("Josef Haller", "Informatik"));
		
		while (it2_tree4.hasNext()) {
			System.out.print(it2_tree4.next() + " ");
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
		System.out.println();
		System.out.println("----------ReplaceableTree<Person>----------");
		ReplaceableTree<Person> tree5 = new ReplaceableTree<Person>();
		tree5.add(new Student("Test Testmann", 22));
		tree5.add(new Professor("Dirk Bach", "Informatik"));
		tree5.add(new Professor("Paul Polak", "Elektronik"));
		tree5.add(new Professor("Alfred Gehart", "Physik"));
		tree5.add(new Student("Gerd Lauf", 58));
		tree5.add(new Student("Benjamin Pogner", 45));
		
		System.out.println("--Tree toString()");
		System.out.println(tree5);
		
		TreeIter<Person> it1_tree5 = tree5.iterator();
		
		while (it1_tree5.hasNext()) {
			System.out.print(it1_tree5.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree contains Paul Polak");
		it1_tree5 = tree5.contains(new Professor("Paul Polak", "Elektronik"));
		
		while (it1_tree5.hasNext()) {
			System.out.print(it1_tree5.next() + " ");
		}
		
		System.out.println();
		System.out.println("--Tree Search Gerd Lauf");
		Iter<Boolean> it2_tree5 = tree5.search(new Student("Gerd Lauf", 58));
		
		while (it2_tree5.hasNext()) {
			System.out.print(it2_tree5.next() + " ");
		}
		
		// TODO
		//tree5.replace(position, tree);
		
	}

}
