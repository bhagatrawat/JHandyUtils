package com.github.bhagatsingh.jhandyutils.collection.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * This class is a custom HashMap class and it will provide only basic functionalities of HashMap.
 * 
 * @author Bhagat Singh
 *
 * @param <K> the type of keys
 * @param <V> the type of mapped values
 */
public class CustomHashMap<K, V> {
	List<KeyValueTable<K, V>> table;
	
	/**
	 * Class Constructor
	 */
	public CustomHashMap() {
		this.table = new ArrayList<KeyValueTable<K, V>>();
	}

	/**
	 * The put method add key value pair object to array list
	 * @param key
	 * @param value
	 * @return value
	 * @throws RuntimeException
	 */
	public V put(K key, V value) {
		try {
			KeyValueTable<K, V> keyValueTable = getKeyValueTable(key);
			if (keyValueTable != null) {
				keyValueTable.setValue(value);
			} else {
				keyValueTable = new KeyValueTable<K, V>(key, value);
				table.add(keyValueTable);
			}
			return keyValueTable.getValue();
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}
	
	/**
	 * The get method returns the value for a key.
	 * @param key
	 * @return value 
	 */
	public V get(Object key){
		KeyValueTable<K, V> keyValue = getKeyValueTable(key);
		return keyValue != null? keyValue.getValue():null;
	}

	/**
	 * The contains method returns true if KeyValueTable object exists in list else returns false.
	 * @param key
	 * @return true/false
	 */
	public boolean contains(Object key) {
		return containsKey(key);
	}
	
	/**
	 * The containsKey method returns true if KeyValueTable object exists in list else returns false.
	 * @param key
	 * @return true/false
	 */
	public boolean containsKey(Object key) {
		return getKeyValueTable(key) != null;
	}

	/**
	 * get getKeyValueTable method returns KeyValueTale object from table list for a key
	 * @param key
	 * @return KeyValueTable
	 */
	private KeyValueTable<K, V> getKeyValueTable(Object key) {
		if(key == null) return getForNullKey();
		Object k;
		for (KeyValueTable<K, V> keyValue : table) {
			if ((k = keyValue.getKey()) == key || key.equals(k)) {
				return keyValue;
			}
		}
		return null;
	}
	
	/**
	 * The getForNullKey method return KeyValueTable object for null key
	 * @return KeyValueTable
	 */
	private KeyValueTable<K, V> getForNullKey() {
		for (KeyValueTable<K, V> keyValue : table) {
			if (keyValue.getKey() == null) {
				return keyValue;
			}
		}
        return null;
    }
	
	/**
	 *  The iterator method returns KeyValueTable list iterator
	 * @return Iterator of KeyValueTable
	 */
	public Iterator<KeyValueTable<K, V>> iterator(){
		return table.iterator();
	}
	
	/**
	 * The size method return size of custom map
	 * @return
	 */
	public int size(){
		return table.size();
	}
	
	/**
	 * The clear method clears custom map
	 */
	public void clear(){
		table.clear();
	}
	
	/**
	 * The remove method removes KeyValueTable from List if it exists.
	 * @param key
	 * @return
	 */
	public boolean remove(Object key){
		return  table.remove(getKeyValueTable(key));
	}
}
