package s1t6n1ex1;

public class NoGenericMethods<T> {
	
	private T o1;
	private T o2;
	private T o3;
	
	public NoGenericMethods(T o1, T o2, T o3) {
		super();
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
	}

	public T getO1() {
		return o1;
	}

	public void setO1(T o1) {
		this.o1 = o1;
	}

	public T getO2() {
		return o2;
	}

	public void setO2(T o2) {
		this.o2 = o2;
	}

	public T getO3() {
		return o3;
	}

	public void setO3(T o3) {
		this.o3 = o3;
	}
	
}
	
	