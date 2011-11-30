/**
 * Interface TreeIter. TreeIter is a generic type with type variable T.
 * 
 * @author Gruppe222
 * 
 * @param <T>
 *            type variable T
 */
public interface TreeIter<T> extends Iter<T> {

	/**
	 * Creates a new iterator over a subtree of the current position of the old
	 * iterator.
	 * 
	 * @return a new TreeIter that may iterate over a subtree.
	 */
	public TreeIter<T> down();

}
