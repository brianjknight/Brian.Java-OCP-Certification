package chapter11.exceptionsLocalizations;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class FormattingValues {
	public static void main(String[] args) {
		
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)); // default so redundant call to format here
		System.out.println();
		
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println();
		
		var dt = LocalDateTime.of(2022, Month.OCTOBER, 2, 16, 15, 30);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyyyy 'Brian''s time' ! HH:mm:ss a"); // 'a'for AM/PM based on provided hour
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMM/d 'year:'y 'Brian''s time' | hh:mm:ss a"); // hh (clock hour) vs HH
		// if the 'a' is dropped, why is the hour is still 04 instead of 16?
		
		System.out.println(dt.format(formatter1)); // .format() called on LocalDateTime with a formatter
		System.out.println(formatter1.format(dt)); // .format() called on formatter with a dataTime
		System.out.println(formatter2.format(dt));
		System.out.println();
		
		double d = 1234.56;
		
		NumberFormat nfZeroFill = new DecimalFormat("0000000000000,00.0000");
//		NumberFormat nfZeroFill = new DecimalFormat("000,000000000000.0000");
		System.out.println(nfZeroFill.format(d));
		
		NumberFormat nfOmitZero = new DecimalFormat("###,###.#");
		System.out.println(nfOmitZero.format(d));
		
		NumberFormat nfBalance = new DecimalFormat("Current balance: ###!X,###.000");
		System.out.println(nfBalance.format(d));
	}
}


