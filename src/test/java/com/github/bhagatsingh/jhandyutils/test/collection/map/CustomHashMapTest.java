package com.github.bhagatsingh.jhandyutils.test.collection.map;

import java.util.Iterator;

import org.junit.Test;

import com.github.bhagatsingh.jhandyutils.collection.map.CustomHashMap;
import com.github.bhagatsingh.jhandyutils.collection.map.KeyValueTable;



/**
 * CustomHashMap class Test Case to test all possible scenarios of a HashMap
 * 
 * @author Bhagat Singh
 *
 */
public class CustomHashMapTest {

	@Test
	public void test() {
		//Test Type Safe HashMap
		testTypSafeCustomMap();
		//Test Non Type Safe HashMap
		testNonTypeSafeCustomMap();	
	}
	
	/**
	 * The method testTypSafeCustomMap tests type safe map for specified keys/values only
	 */
	public void  testTypSafeCustomMap(){
		CustomHashMap<Integer, String> testMap = null;
		try{
			testMap = new CustomHashMap<Integer, String>();
			//null string as key
			testMap.put(1, "Number 1");
			testMap.put(1, "Number 1 again");
			
			//negative value as key
			testMap.put(-1, "I am Negativ Number");
		
			//float value as key
			testMap.put(new Integer("2"), "Number 2");
		
			//null as key
			testMap.put(null, "Real null");
			testMap.put(null, "Overwriting Real null");
	
			/**
			 * Get value for a key
			 */
			System.out.println("\n********* Printing indivisual element of type safe Map *********");
			System.out.println("\nValue for 1: "+ testMap.get(1));
			System.out.println("Value for -1: "+ testMap.get(-1));
			System.out.println("Value for 2: "+ testMap.get(2));
			System.out.println("Value for null: "+ testMap.get(null));
			
			/**
			 * Print all map elements
			 */
			Iterator<KeyValueTable<Integer, String>> iterator = testMap.iterator();
			System.out.println("\n********* Printing all elements of Type Safe Map *********");
			while(iterator.hasNext()){
				KeyValueTable<Integer, String> value = iterator.next();
				System.out.println("Key: "+ value.getKey());
				System.out.println("Value: "+ value.getValue());
				System.out.println("*******************************");
			}
			
			/**
			 * Size of Before clearing map elements
			 */
			System.out.println("\nMap Size Before clear: "+ testMap.size());
			
			/**
			 * Remove an element from map
			 */
			testMap.remove(null);
			System.out.println("\nMap Size afer remove: "+ testMap.size());
			/**
			 * Print all map elements after remove
			 */
			Iterator<KeyValueTable<Integer, String>> iterator1 = testMap.iterator();
			System.out.println("\n********* Printing all elements of Map after null key remove*********");
			while(iterator1.hasNext()){
				KeyValueTable<Integer, String> value = iterator1.next();
				System.out.println("Key: "+ value.getKey());
				System.out.println("Value: "+ value.getValue());
				System.out.println("*******************************");
			}
			
			/**
			 * Clear map elements
			 */
			testMap.clear();
			
			/**
			 * Size of after clearing map elements
			 */
			System.out.println("Map Size After clear: "+ testMap.size());
		}catch(Exception exp){
			exp.printStackTrace();
			throw new RuntimeException(exp);
		}finally{
			if(testMap !=null)testMap .clear(); testMap =null;
		}
		
	}
	
	/**
	 * The method testNonTypeSafeCustomMap tests non type safe map for any kinds of keys/ values
	 */
	public void testNonTypeSafeCustomMap() {
		CustomHashMap testMap = null;
		try{
			
			testMap = new CustomHashMap();
			//null string as key
			testMap.put("null", "I am String Null");
			testMap.put("null", "I am 2nd String Null");
			
			//negative value as key
			testMap.put(-1, "I am Negativ Number");
		
			//float value as key
			testMap.put(0.75f, "I am float");
		
			//null as key
			testMap.put(null, "I am real null");
			testMap.put(null, "I am 2nd real null");
					
			/**
			 * 
			 */
			System.out.println("\n********* Printing indivisual element of Map *********");
			System.out.println("Value of null String Key: "+ testMap.get("null"));
			System.out.println("Value of negative Key: "+ testMap.get(-1));
			System.out.println("Value of float Key: "+ testMap.get(0.75f));
			System.out.println("Value of null Key: "+ testMap.get(null));
			
			/**
			 * Print all map elements
			 */
			Iterator<KeyValueTable> iterator = testMap.iterator();
			System.out.println("\n********* Printing all elements of Map*********");
			while(iterator.hasNext()){
				KeyValueTable value = iterator.next();
				System.out.println("Key: "+ value.getKey());
				System.out.println("Value: "+ value.getValue());
				System.out.println("*******************************");
			}
			
			/**
			 * Size of Before clearing map elements
			 */
			System.out.println("\nMap Size Before clear: "+ testMap.size());
			
			/**
			 * Remove an element from map
			 */
			testMap.remove(null);
			System.out.println("\nMap Size afer remove: "+ testMap.size());
			/**
			 * Print all map elements after remove
			 */
			Iterator<KeyValueTable> iterator1 = testMap.iterator();
			System.out.println("\n********* Printing all elements of Map after null key remove*********");
			while(iterator1.hasNext()){
				KeyValueTable value = iterator1.next();
				System.out.println("Key: "+ value.getKey());
				System.out.println("Value: "+ value.getValue());
				System.out.println("*******************************");
			}
			
			/**
			 * Clear map elements
			 */
			testMap.clear();
			
			/**
			 * Size of after clearing map elements
			 */
			System.out.println("Map Size After clear: "+ testMap.size());
		}catch(Exception exp){
			exp.printStackTrace();
			throw new RuntimeException(exp);
		}finally{
			if(testMap !=null)testMap .clear(); testMap =null;
		}
	}
	
	
}
