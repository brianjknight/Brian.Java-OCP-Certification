package chapter11.exceptionsLocalizations;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class UsingResourceBundles {
	
	public static void main(String[] args) {
		ResourceBundle rbEN = ResourceBundle.getBundle("Zoo", Locale.US);
		System.out.println("rbEN: " + rbEN.getString("hello") + " " + rbEN.getString("open"));

		ResourceBundle rbFR = ResourceBundle.getBundle("Zoo", new Locale("fr","FR")); // exact bundle fr_FR not found so looks for Zoo_fr.props
		System.out.println("rbFR: " + rbFR.getString("hello") + " " + rbFR.getString("open"));
		
		ResourceBundle rbCA = ResourceBundle.getBundle("Zoo", new Locale("ca"));
		// most specific ca is not found > cannot drop country CA > use default locale en_US > drop country US > finds en as the selected bundle
		System.out.println("rcCA: " + rbCA.getString("hello") + " " + rbCA.getString("open")); 
		
		System.out.println();
		
		Locale xx_XX = new Locale("xx", "XX");
		Locale xx = new Locale("xx");
		Locale yy = new Locale("yy","YY");

		ResourceBundle rb_default_en = ResourceBundle.getBundle("Zoo", yy); // if not found looks for default locale of en_US > drops country and finds en.props
		System.out.println(rb_default_en.getString("hello") + " " + rb_default_en.getString("open"));
		System.out.println("****");
		
		ResourceBundle rb_xx_XX = ResourceBundle.getBundle("XXXX", xx_XX);  // finds exact match
		System.out.println(rb_xx_XX.getString("hello") + " " + rb_xx_XX.getString("open")); 
		System.out.println("^^^^");
		
		ResourceBundle rb_xx = ResourceBundle.getBundle("XXXX", xx);
		System.out.println(rb_xx.getString("hello") + " " + rb_xx.getString("open"));
		String openValue = rb_xx.getString("open");
		System.out.println("openValue.formatted(): " + openValue.formatted("xxMYxxPARAM"));
		System.out.println(rb_xx.getString("hello") + " " + MessageFormat.format(openValue, "myXXparam"));
		System.out.println("^^^^");
		
//		ResourceBundle rbXXXXdefault = ResourceBundle.getBundle("XXXX", yy); // throws exception no default is found since XXXX has no default bundle
//		System.out.println(rbXXXXdefault.getString("hello") + " " + rbXXXXdefault.getString("open"));
//		System.out.println("@@@@");
	}
}


