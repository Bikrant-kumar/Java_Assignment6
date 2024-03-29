
class Vampirenumber {
	Boolean s_Flag = false;
	//breaking the number into individual number and storing in an array.
	public int[] breakNumber(int i_Number) {
		int remainder= 0;
		int index=0;
		int length = (int) (Math.log10(i_Number) + 1);
		int array[] = new int[length];
		while (i_Number != 0) {
			remainder = i_Number % 10;
			array[index] = remainder;
			i_Number = i_Number / 10;
			index++;
		}
		return array;
	}
	//converting the array to two equal parts and find the vampire number

	Boolean checkVampire(int[] arr, int i_Number) {
		int firstPart = 0;
		int secondPart = 0;
		for (int index = 0; index < (arr.length) / 2; index++) {
			firstPart += arr[index] * Math.pow(10, (arr.length) / 2 - index - 1);
		}
		for (int index = (arr.length) / 2; index < arr.length; index++) {
			secondPart += arr[index] * Math.pow(10, (arr.length - index - 1));
		}
		if (firstPart * secondPart == i_Number) {
			return true;
		}
		return false;
	}

	//finds all the permutations of the given input array and returns to the checkvampire method.
	void permutaionFinder(int[] arr, int index, int i_Number) {
		if (index >= arr.length - 1) {
			if (this.checkVampire(arr, i_Number)) {
				//flag will set to true if it is a vampire number.
				s_Flag = true;
			}
		}
		for (int i = index; i < arr.length; i++) { 
			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
			permutaionFinder(arr, index + 1, i_Number);
			t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
		}
	}
};

public class Ques_1 {

	public static void main(String[] args) {
		Vampirenumber vampire = new Vampirenumber();
		int number = 1001;
		int counter = 0;
		while (counter < 100) {
			if (((int) (Math.log10(number) + 1))%2 == 0) {
				int[] array = vampire.breakNumber(number);
				vampire.permutaionFinder(array, 0, number);
				if (vampire.s_Flag) {
					System.out.println(number);
					counter++;
					vampire.s_Flag = false;
				}

			}
			number++;
		}
	}}