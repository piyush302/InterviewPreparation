import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapOperations1 {

	public static void main(String[] args) {
		String input = "Hello, World!";
		Map<Object, Long> map = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(map);

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John Doe", "Sales", 5000));
		employees.add(new Employee("Jane Smith", "Marketing", 6000));
		employees.add(new Employee("David Johnson", "Engineering", 7000));
		employees.add(new Employee("Emily Davis", "Finance", 5500));
		employees.add(new Employee("Mike Brown", "Sales", 5500));
		employees.add(new Employee("Karen Lee", "Marketing", 6500));
		Map<String, Optional<Employee>> highestSalaryByDepartment = employees.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary()))));
		System.out.println(highestSalaryByDepartment);
	}

}
