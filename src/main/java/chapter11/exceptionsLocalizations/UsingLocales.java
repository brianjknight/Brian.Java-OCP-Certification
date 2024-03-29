package chapter11.exceptionsLocalizations;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Locale.Category;

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
		System.out.println();
		
		double price = 1_005_299.99;
		NumberFormat localFormat = NumberFormat.getCurrencyInstance();
		String localPrice = localFormat.format(price);
		System.out.println("localPrice: " + localPrice);

		try {
			double backToDouble = (Double) localFormat.parse(localPrice);  // parse() method in various types declares a checked ParseException
			System.out.println("backToDouble: " + backToDouble);
		} catch (ParseException e) {
			System.out.println("could not conver tot double");
		}
		
		BigDecimal bigPrice = BigDecimal.valueOf(price);
		NumberFormat italianPrice = NumberFormat.getCurrencyInstance(Locale.ITALIAN);
		System.out.println("italianPrice: " + italianPrice.format(bigPrice));
		
		BigDecimal percentage = BigDecimal.valueOf(.159194654165486);
		NumberFormat percFormat = NumberFormat.getPercentInstance(Locale.CHINESE);
		System.out.println("percFormat: " + percFormat.format(percentage));
		System.out.println();
		
		long x = 314_900_000L;
		NumberFormat compactDefault = NumberFormat.getCompactNumberInstance();
		NumberFormat compactShort = NumberFormat.getCompactNumberInstance(Locale.getDefault(),Style.SHORT);
		NumberFormat compactLong = NumberFormat.getCompactNumberInstance(Locale.getDefault(),Style.LONG);
		System.out.println(compactDefault.format(x));
		System.out.println(compactShort.format(x));
		System.out.println(compactLong.format(x-314_000_000));
		System.out.println(NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT).format(x-314_000_000));
		System.out.println();
		
		////////////////////////////////////////////////
		// Formatting date/time
		
		LocalDateTime ltd = LocalDateTime.now();
		DateTimeFormatter dtfMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(dtfMedium.format(ltd));
		System.out.println(dtfMedium.withLocale(Locale.CANADA_FRENCH).format(ltd));
		System.out.println();
		
		DateTimeFormatter dtfSplit = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT); // separate date & time styles
		System.out.println(dtfSplit.format(ltd));
		System.out.println(dtfSplit.withLocale(Locale.CANADA_FRENCH).format(ltd));
		System.out.println();
		
		Locale spanish = new Locale("es","ES");  //default locale is currently en_us
		var money = 5.99;
		NumberFormat nfCur = NumberFormat.getCurrencyInstance();
		
		System.out.println(spanish.getDisplayLanguage() + " " +  spanish.getDisplayCountry() + " " + nfCur.format(money)); // so I'm printing the locale instance fields but in the default language
		System.out.println();
		
		Locale.setDefault(Category.DISPLAY, spanish);
		System.out.println(spanish.getDisplayLanguage() + " " +  spanish.getDisplayCountry() + " " + nfCur.format(money));
		System.out.println();
		
		// note that a NEW NumberFormat instance is needed after changing the Category
		Locale.setDefault(Category.FORMAT, spanish); // no MY locale is set to spanish
		System.out.println(spanish.getDisplayLanguage() + " " +  spanish.getDisplayCountry() + " " + nfCur.format(money)); 
		System.out.println(spanish.getDisplayLanguage() + " " +  spanish.getDisplayCountry() + " " + NumberFormat.getCurrencyInstance().format(money));
		System.out.println();
		
	}
	
}


