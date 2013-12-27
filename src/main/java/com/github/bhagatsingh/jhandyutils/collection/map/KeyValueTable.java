package com.github.bhagatsingh.jhandyutils.collection.map;
/**
 * The KeyValueTable class contains key and it value.
 * @author Bhagat Singh
 *
 * @param <K> for key
 * @param <V> for value
 */
public class KeyValueTable<K, V> {
	private final K key;
	private V value;
	//I am not using hash code for this implementation.
	int hashCode;
	
	public KeyValueTable(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	
	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}
	
}
