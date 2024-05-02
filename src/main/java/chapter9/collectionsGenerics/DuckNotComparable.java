package chapter9.collectionsGenerics;

public class DuckNotComparable {
	private String name;
	private int age;
	private double weight;
	private String favFood;
	private int money;
	public DuckNotComparable(String name, int age, double weight, String favFood, int money) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.favFood = favFood;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getFavFood() {
		return favFood;
	}
	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "DuckNotComparable [name=" + name + ", age=" + age + ", weight=" + weight + ", favFood=" + favFood
				+ ", money=" + money + "]";
	}
	
	
}


