package chapter1.building_blocks;

//import java.lang.System; // redundant java.lang is automatically imported
//import java.lang.*;  // redundant

import java.util.List;
import static java.util.List.copyOf; // 
//import static java.util.List.add;
import java.util.ArrayList;

//import java.lang.Math.PI; // cannot import methods unless static method and static import
import static java.lang.Math.PI;
import static java.lang.Math.*; 
//import static java.lang.*;
import java.lang.Math.*; // tries to import all classes under Math (even though there are none) not static fields/methods
import java.nio.file.Paths.*;
//import java.util.*;  // redundant
//import java.util.Random;

//import java.lang.*.*; // only ONE wildcard allowed


// naming conflicts
//import java.util.Date;
//import java.sql.Date;  // does not compile

// ambiguous imports: imports will compile 
	// HOWEVER declaring a Date object WILL NOT compile
//import java.util.*; 
//import java.sql.*;

// better imports to compile code
import java.util.Date;
import java.sql.*;

public class Imports {

	static String hello = "hello";
	
	public static void main(String[] args) {
		double d = Math.PI;
		double pi = PI;
		
//		Date utilDate = new Date(); // ambiguous with 2 wild card imports
		
		// compiles with 
//		Date utilDate = new Date();
////		java.sql.Date sqlDateA = new Date(); // does not compile since Date is assumed to be util.Date
//		java.sql.Date sqlDateB = new java.sql.Date(0);
	
		// without imports:
//		java.util.Date utilDateBad = new Date(); // does not compile if import is missing
		Date utilDate1 = new Date();
		java.util.Date utilDate2 = new java.util.Date();
		java.sql.Date sqlDate1 = new java.sql.Date(0);
		
		
		String h = chapter1.building_blocks.Imports.hello;
	}
	
	void testNonStaticStaticImport() {
		List<String> list = new ArrayList<>();
	}
	
}


