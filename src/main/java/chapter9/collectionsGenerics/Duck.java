package chapter9.collectionsGenerics;

import java.util.Objects;

public class Duck implements Comparable<Duck>{

	private String name;
	private int age;
	private double weight;
	private String favFood;
	private int money;
	
	public Duck() {};
	
	public Duck(String name, int age, double weight, String favFood, int money) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.favFood = favFood;
		this.money = money;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public double getWeight() {return weight;}
	public void setWeight(double weight) {this.weight = weight;}
	public String getFavFood() {return favFood;}
	public void setFavFood(String favFood) {this.favFood = favFood;}
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
	
	public int compareTo(Duck d) {
		if (d == null) throw new IllegalArgumentException(); // prevent null pointers
		if (this == d) return 0;
		
		if (this.name == null && d.name == null) return this.age - d.age;
//		if (this.name == null && d.name == null) return Integer.compare(this.age, d.age); // equivalent to above line
		if (this.name == null) return -1;
		if (d.name == null) return 1;
		
		if (this.name.compareTo(d.name) == 0) {
			return this.age - d.age; // primitives cannot be null
//			return Integer.compare(this.age, d.age); // also works
		} else {
			return this.name.compareTo(d.name);
		}
	}
	
	public boolean equals(Duck d) {
		if (d == null) return false;
		if (this == d) return true;
		return this.name == d.name && this.age == d.age;
//		return Objects.equals(this.name, d.name) && Objects.equals(this.age,  d.age); 
	}
	
	public int hashCode() {
		return Objects.hash(name,age);
	}

	@Override
	public String toString() {
		return "Duck [name=" + name + ", age=" + age + ", weight=" + weight + ", favFood=" + favFood + ", money="
				+ money + "]";
	}
	
	
	class Duckling implements Comparable<String> { // Comparable type can be different than class
		String name;
		
		@Override
		public int compareTo(String o) {
			return name.compareTo(o);
		}
		
	}
}


