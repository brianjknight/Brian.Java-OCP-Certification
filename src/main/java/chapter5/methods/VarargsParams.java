package chapter5.methods;

public class VarargsParams {
	public static void main(String[] args) {
		VarargsParams vp = new VarargsParams();
		
		//varargs param can be ommited
		vp.method1();
		int[] nums = {1,2,3};
		vp.method1(nums);
		vp.method1(new int[] {4,5,6});
	}
	
	void method1(int... nums) {
		for (int i : nums) {
			System.out.println(i);
		}
	}
	
	
}
