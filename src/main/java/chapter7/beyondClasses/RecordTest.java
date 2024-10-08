package chapter7.beyondClasses;

public class RecordTest {
	public static void main(String[] args) {
//		PersonRecord empty = new PersonRecord(); // does not create default no args constructor
		PersonRecord brian = new PersonRecord("Brian", "Knight", 39, 160, 6.0, "oreos");
		
		System.out.println(brian);
		System.out.println(brian.first());
		System.out.println(brian.favortieFood());
		System.out.println(brian.weight());
		System.out.println(PersonRecord.species);
		
		PersonRecord allison;
		try {
			allison = new PersonRecord("Allison","Fedorowicz");
			
			System.out.println(allison);
			
			allison.changeSpecies("fish");
			System.out.println(allison.weight());
			System.out.println("Allison species: " + allison.species);
			System.out.println("Brian species: " + brian.species);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
