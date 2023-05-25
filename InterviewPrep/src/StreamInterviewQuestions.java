import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamInterviewQuestions {

	public static void main(String[] args) {
		// Find occurrence of each character in a string.
		String s = "HelloWorld";
		Map<Object,Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(map);
		
		//Find duplicate element in the string
		List<Object> dup = Arrays.stream(s.split("")).collect(Collectors.groupingBy(e->e,Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
		System.out.println(dup);
		
		//Find Unique non Duplicate elements
		List<Object> nonDup = Arrays.stream(s.split("")).collect(Collectors.groupingBy(e->e,Collectors.counting())).entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).collect(Collectors.toList());
		System.out.println(nonDup);
		
		//Find first non repeating element of given string.
		String result = Arrays.stream(s.split("")).collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(e->e.getValue()==1).findFirst().get().getKey();
		System.out.println(result);
		
		//Second highest number in an array
		//Here boxed is used to convert int to object Integer because sorted with comparator will not work.For int sorted will work but it wont take comparator as an argument
		int[] arr = {4,12,43,6,76,77,84};
		int sHighest = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(sHighest);
		
		//Longest string in an array
		String[] strArr = {"hello","piyush","mayankdar","manishksaaa","bye"};
		
		String longString = Arrays.stream(strArr).reduce((x,y)->(x.length()-y.length())>0?x:y).get();
		System.out.println(longString);
		
		//Find all element in array that starts with 1;
		
		int[] arr1 = {4,12,43,6,76,17,84};
		
		List<String> res1 = Arrays.stream(arr1).boxed().map(e->e+"").filter(e->e.startsWith("1")).collect(Collectors.toList());
		System.out.println(res1);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John Doe", "Sales", 5000));
		employees.add(new Employee("Jane Smith", "Marketing", 6000));
		employees.add(new Employee("David Johnson", "Engineering", 7000));
		employees.add(new Employee("Emily Davis", "Finance", 5500));
		employees.add(new Employee("Mike Brown", "Sales", 5500));
		employees.add(new Employee("Karen Lee", "Marketing", 6500));
		//Get highest salary department wise
		Map<String, Optional<Employee>> highestSalaryByDepartment = employees.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary()))));
		System.out.println(highestSalaryByDepartment);
		//Get average salary in each department.
		
		Map<String, Double> avgSal = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e->e.getSalary())));
		System.out.println(avgSal);
		//All employee above average salary
		
		List<Employee> employeesWithHighSalary = employees.stream()
			    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
			    .entrySet()
			    .stream()
			    .flatMap(entry -> employees.stream()
			            .filter(emp -> emp.getDepartment().equals(entry.getKey()) && emp.getSalary() > entry.getValue()))
			    .collect(Collectors.toList());
		System.out.println(employeesWithHighSalary);
	}

}
