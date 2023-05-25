
public class CallSingleton {

	public static void main(String[] args) {
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		Singleton c = Singleton.getInstance();
		System.out.println(a.hashCode()+" "+b.hashCode()+" "+c.hashCode());
	}

}
