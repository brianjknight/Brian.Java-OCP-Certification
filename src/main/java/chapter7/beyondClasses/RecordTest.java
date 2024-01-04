package chapter7.beyondClasses;

public class RecordTest {
	public static void main(String[] args) {
		PersonRecord brian = new PersonRecord("Brian", "Knight", 39, 160, 6.0, "oreos");
		
		System.out.println(brian);
		System.out.println(brian.first());
		System.out.println(brian.favortieFood());
		System.out.println(brian.weight());
		System.out.println(PersonRecord.species);
	}
}
