import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

	
		// TODO Auto-generated method stub
		
		static Integer[] intArray= {1,2,3,4,5};
		static String[] Character= {"A","R","K"};
		static Boolean[] stringBool= {true,false,false};
		
		
		@SuppressWarnings("rawtypes")
		public static List arrayToList(Object[] array, List<Object>list) {
			for(Object object:array) {
				list.add(object);
				
			}
			return list;
		}
			public static void main(String[] args) {
				List<Integer> intList = arrayToList(intArray, new ArrayList<Object>());
				List<Character> Charlist=arrayToList(Character, new ArrayList<Object>());
				List<Boolean> boolList=arrayToList(stringBool, new ArrayList<Object>());
		}

	}


