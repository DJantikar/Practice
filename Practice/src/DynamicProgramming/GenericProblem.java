package DynamicProgramming;

public class GenericProblem<T> {
    T obj1;
    T obj2;

    public void setting(T obj1,T obj2){
        this.obj1=obj1;
        this.obj2=obj2;
    }

    @SuppressWarnings("unchecked")
	public T add(){
        if (obj1 instanceof String) {
            return (T) ((String) obj1 + (String) obj2);
        } else if (obj1 instanceof Integer) {
            return (T) ((Integer) ((Integer) obj1 + (Integer) obj2));
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
    	GenericProblem<Integer> obj1 = new GenericProblem<>();
    	obj1.setting(3, 4);
    	GenericProblem<String> obj2 = new GenericProblem<>();
    	obj2.setting("Hi ", "Deepa");
		System.out.println(obj1.add());
		System.out.println(obj2.add());
	}
}