public class Ques_2{
	
	Ques_2() {
		System.out.println("constructor 1 is running. ");
			}
	Ques_2(int str) {
		this();
		System.out.println(str);
	}
	public static void main(String[] args) {
		Ques_2 obj = new Ques_2(5);
	}
}
