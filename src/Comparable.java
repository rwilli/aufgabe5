/**
 * 
 */

/**
 * Interface that compares two objects.
 * 
 * @author Gruppe222
 */
public interface Comparable<T> {
	
	/**
	 * Compares to objects.
	 * Returns - 1 if current instance < object.
	 * Returns = 0 if current instance = object.
	 * Returns + 1 if current instance > object.
	 * 
	 * @param object
	 * 
	 * @return -1, 0, or 1
	 */
	int compareTo(T that);
	
}
