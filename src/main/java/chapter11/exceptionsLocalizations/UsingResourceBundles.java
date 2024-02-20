package chapter11.exceptionsLocalizations;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class UsingResourceBundles {
	
	public static void main(String[] args) {
		ResourceBundle rbEN = ResourceBundle.getBundle("Zoo", Locale.US);
		System.out.println(rbEN.getString("hello") + " " + rbEN.getString("open"));

		ResourceBundle rbFR = ResourceBundle.getBundle("Zoo", new Locale("fr")); // no country is given so Java drops to find by language only
		System.out.println(rbFR.getString("hello") + " " + rbFR.getString("open"));
		System.out.println();
		
		Locale xx_XX = new Locale("xx", "XX");
		Locale xx = new Locale("xx");
		Locale yy = new Locale("yy","YY");

		ResourceBundle rb_default_en = ResourceBundle.getBundle("Zoo", yy); // if not found looks for default en_US the en
		System.out.println(rb_default_en.getString("hello") + " " + rb_default_en.getString("open"));
		System.out.println("****");
		
		ResourceBundle rb_xx_XX = ResourceBundle.getBundle("XXXX", xx_XX);
		System.out.println(rb_xx_XX.getString("hello") + " " + rb_xx_XX.getString("open"));
		System.out.println("^^^^");
		
		ResourceBundle rb_xx = ResourceBundle.getBundle("XXXX", xx);
		String openValue = rb_xx.getString("open");
		System.out.println(rb_xx.getString("hello") + " " + MessageFormat.format(openValue, "myParam"));
		System.out.println("^^^^");
		
//		ResourceBundle rbXXXXdefault = ResourceBundle.getBundle("XXXX", yy); // throws exception no default is found since XXXX has no default bundle
//		System.out.println(rbXXXXdefault.getString("hello") + " " + rbXXXXdefault.getString("open"));
//		System.out.println("@@@@");
	}
}


