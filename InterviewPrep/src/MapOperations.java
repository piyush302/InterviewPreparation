import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MapOperations {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, null);
		
		map.entrySet().forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
		
		for(Entry<Integer,String> i :map.entrySet()) {
			System.out.println(i.getKey()+" "+i.getValue());
		}
		
		Map<Integer,String> map1 = map.entrySet().stream().filter(x->x.getKey()<3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		map1.entrySet().forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
		
		Map<String,Integer> employee = new HashMap<>();
		employee.put("Piyush", 5000);
		employee.put("Mayank", 3000);
		employee.put("Chandan", 2000);
		employee.put("Manish", 1000);
		employee.put("Nikhil", 500);
		
		employee.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,entry->entry.getValue()<3000 ? entry.getValue()+1000:entry.getValue())).entrySet().forEach(x->System.out.println(x));
		System.out.println("Hello");
		employee.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,entry->entry.getValue())).entrySet().forEach(x->System.out.println(x));
		
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 50000);
		salaries.put("Mary", 60000);
		salaries.put("Bob", null);

		Map<String, Integer> updatedSalaries = salaries.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> Optional.ofNullable(entry.getValue()).map(value -> value < 50000 ? value + 10000 : value).orElse(null)));

		System.out.println(updatedSalaries);
		
		
	}
}
