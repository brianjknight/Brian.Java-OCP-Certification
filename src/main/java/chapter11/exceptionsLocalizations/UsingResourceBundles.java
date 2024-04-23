package chapter11.exceptionsLocalizations;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class UsingResourceBundles {
	
	public static void main(String[] args) {
		System.out.println("Locale.US: " + Locale.US); // US country creates Locale of en_US
		ResourceBundle rbEN = ResourceBundle.getBundle("Zoo", Locale.US);
		// 
		System.out.println("rbEN: " + rbEN.getString("hello") + ", " + rbEN.getString("open"));

		ResourceBundle rbFR = ResourceBundle.getBundle("Zoo", new Locale("fr","FR")); // exact bundle fr_FR not found so looks for Zoo_fr.props
		System.out.println("rbFR: " + rbFR.getString("hello") + ", " + rbFR.getString("open"));
		
		ResourceBundle rb_fr = ResourceBundle.getBundle("Zoo", new Locale("fr")); 
		System.out.println("rb_fr: " + rb_fr.getString("hello") + ", " + rb_fr.getString("open"));
			
		
		ResourceBundle rbCA = ResourceBundle.getBundle("Zoo", new Locale("ca"));
		// most specific ca is not found > cannot drop country CA > use default locale en_US > drop country US > finds en as the selected bundle
		System.out.println("rcCA: " + rbCA.getString("hello") + ", " + rbCA.getString("open")); 
		
		System.out.println();
		
		Locale xx_XX = new Locale("xx", "XX");
		System.out.println("xx_XX: " + xx_XX);
		Locale xx = new Locale("xx");
		System.out.println("xx: " + xx);
		Locale yy = new Locale("yy","YY");
		System.out.println("yy: " + yy);
		System.out.println();

		ResourceBundle rb_default_en = ResourceBundle.getBundle("Zoo", yy); // if not found looks for default locale of en_US > drops country and finds en.props
		System.out.println("rb_default_en: " + rb_default_en.getString("hello") + ", " + rb_default_en.getString("open"));
		System.out.println();
		
		ResourceBundle rb_xx_XX = ResourceBundle.getBundle("XXXX", xx_XX);  // finds exact match
		System.out.println("rb_xx_XX: " + rb_xx_XX.getString("hello") + ", " + rb_xx_XX.getString("open")); 
		System.out.println();
		
		ResourceBundle rb_xx = ResourceBundle.getBundle("XXXX", xx);
		System.out.println("rb_xx: " + rb_xx.getString("hello") + ", " + rb_xx.getString("open"));
		String openValue = rb_xx.getString("open");
		System.out.println("String.format(): " + String.format(openValue, "xxMYxxPARAM")); // does not work with {} "xxopenxx and {0}" vs  "xxopenxx and %s"
		System.out.println("rb_xx MessageFormat.format(): " + rb_xx.getString("hello") + ", " + MessageFormat.format(openValue, "myXXparam"));
		System.out.println();
		
		ResourceBundle rbXXXXdefault = ResourceBundle.getBundle("XXXX", yy); // throws exception no default is found since XXXX has no default bundle
		// XXXX yy > XXXX default locale en_US > XXXX en > XXXX bundle default 
		System.out.println(rbXXXXdefault.getString("hello") + " " + rbXXXXdefault.getString("open"));
		System.out.println();
	}
}


