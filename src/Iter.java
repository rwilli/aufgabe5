
public interface Iter<T> {
	/**
	 * returns the next element in the iteration
	 * 
	 * @return
	 */
	public Iter<T> next();
	
	/**
	 * returns the previous element in the iteration
	 * 
	 * @return
	 */
	public Iter<T> previous();
	
	/**
	 * returns true if the iteration has more elements
	 * 
	 * @return
	 */
	public boolean hasNext();
	
	/**
	 * returns true if the iteration has previous elements
	 * 
	 * @return
	 */
	public boolean hasPrevious();

}
