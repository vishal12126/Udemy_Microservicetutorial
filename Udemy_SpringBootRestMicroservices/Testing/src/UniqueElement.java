import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UniqueElement {

	public static void main(String[] args) {

		int[] arrayInput = {1,2,3,2,1,5,5,6,7,6,7};
		int result = hashMapSolutionUsingJava8(arrayInput);
		System.out.println("Result :" + result);

	}
	
  public static int hashMapSolution(int[] inputArray){
	  HashMap<Integer, Integer> map = new HashMap<>();
	  for(int num : inputArray){
		  Integer occurence = map.get(num);
		  map.put(num, occurence==null ? 1:occurence +1);
	  }
	  for(Map.Entry<Integer,Integer> e : map.entrySet()){
		  if(e.getValue() == 1){
			  return e.getKey();
		  }
	  }
	  return -1;
  }
  //Using Java 8
  public static Integer hashMapSolutionUsingJava8(int[] inputArray){
	  HashMap<Integer, Integer> map = new HashMap<>();
      
	   Arrays.stream(inputArray).forEach(d -> {
   			  Integer occurence = map.get(d);
			  map.put(d, occurence==null ? 1:occurence +1);
	   });

	   Optional<Integer> optionalIsbn = map.entrySet().stream()
			   .filter(e -> e.getValue() == 1)
			   .map(Map.Entry::getKey).findFirst();
	   
	   System.out.println(" Integer Value " + optionalIsbn.get());
	   
		if(optionalIsbn.get() != 0)	  
	   return optionalIsbn.get();
	  return -1;
  }

}
