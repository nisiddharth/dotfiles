class GeeksforGeeks implements Cloneable {
	int a, b;

	protected void getData() {
		System.out.println("Inside GeeksforGeeks " + (a + b));
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		GeeksforGeeks obj = new GeeksforGeeks();
		obj.getData();
		obj.a = 6;
		obj.b = 8;
		obj.getData();
		GeeksforGeeks o2 = (GeeksforGeeks) obj.clone();
		o2.getData();
		o2.b = 9;
		obj.getData();
		o2.getData();
	}
}
