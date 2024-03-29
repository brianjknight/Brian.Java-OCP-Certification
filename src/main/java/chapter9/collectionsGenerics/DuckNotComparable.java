package chapter9.collectionsGenerics;

/****************************************************************************
 * <b>Title:</b> DuckNotComparable.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> CHANGE ME! <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Feb 4, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

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
	
	
}


