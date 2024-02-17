package chapter11.exceptionsLocalizations;

import java.util.Locale;

public class UsingLocales {

	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		
		System.out.println(Locale.GERMAN);
		System.out.println(Locale.GERMANY);
		System.out.println(new Locale("de","AT")); // german and Austria
		System.out.println(new Locale("de12!@","ATXX")); // allowed
		
		Locale custom = new Locale.Builder()
									.setLanguage("xxxx")
									.setRegion("XX")
									.build();
//		Locale customBad = new Locale.Builder()
//				.setLanguage("xxxx")
//				.setRegion("XXZZ") // exception thrown
//				.build();
		System.out.println(custom);
		
		
		
	}
	
	
}


