import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		String names[] = {"Piyush","Manish","Chandan","Nikhil"};
		
		Stream.of(names).forEach(x->System.out.println(x));
		
		List<String> nameList = Arrays.asList(names);
		
		nameList.stream().forEach(x->System.out.println(x));
		
		List<Integer> nums = Arrays.asList(23,3,4,4,5,6);
		List<Integer> square = nums.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.toList());
		System.out.println(square);
		Set<Integer> squareSet = nums.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.toSet());
		System.out.println(squareSet);
		
		int squareSum = nums.stream().filter(x->x%2==0).map(x->x*x).reduce(0,(ans,y)->ans+y);
		System.out.println(squareSum);
		
		int min = nums.stream().min((x,y)->x-y).get();
		System.out.println(min);
		
		int max = nums.stream().max((x,y)->x.compareTo(y)).get();
		System.out.println(max);
	}

}
