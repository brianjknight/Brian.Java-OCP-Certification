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
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyyyy 'Brian''s time' ! H:mm:ss a"); // 'a'for AM/PM based on provided hour
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM_d 'year:'y 'Brian''s time' | hh:mm:ss a"); // hh (12 hour) vs HH (24 hour)
		
		System.out.println(dt.format(formatter1)); // .format() called on LocalDateTime with a formatter
		System.out.println(formatter1.format(dt)); // .format() called on formatter with a dataTime
		System.out.println(formatter2.format(dt));
		System.out.println();
		
		double d = 1234.56;
		
		NumberFormat nfZeroFill = new DecimalFormat("0000000000000,00.0000######");
		System.out.println(nfZeroFill.format(d));
		NumberFormat nfZeroFillOther = new DecimalFormat("00000000,0,0,0,0000.0000000");
		System.out.println(nfZeroFillOther.format(d));
		
		DecimalFormat df = new DecimalFormat("###,#00.0#");
		System.out.println(df.format(d));
		
		NumberFormat nfBalance = new DecimalFormat("'Current balance: $'###!X,###.000");
		System.out.println(nfBalance.format(d));
		
		NumberFormat longFormat = new DecimalFormat("000.00");
		System.out.println("longFormat: " + longFormat.format(1L));
		Float f = 5.5F;
		System.out.println("try Float: " + longFormat.format(f));
		
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number num = nf.parse("123 456,789 !a(8%~"); // formatting with default enUS stops at the space returns 123
			System.out.println(num);
		} catch(Exception e) {
			System.out.println("format exception");
		}
		
	}
}


