package chapter1.building_blocks;

//import java.lang.System; // redundant java.lang is automatically imported
//import java.lang.*;  // redundant
//import java.util.*;  // redundant
//import java.util.Random;

//import java.lang.*.*; // only one wildcard allowed

//import java.util.Random.nextInt; // cannot import methods (unless it is a static import of static method)

// naming conflicts
//import java.util.Date;
//import java.sql.Date;  // does not compile

// ambiguous imports: imports will compile 
	// HOWEVER declaring a Date object WILL NOT compile
//import java.util.*; 
//import java.sql.*;

//import java.util.Date;
//import java.sql.*;

public class Imports {

	public static void main(String[] args) {
//		Date utilDate = new Date(); // ambiguous with 2 wild card imports
		
		// compiles with 
//		Date utilDate = new Date();
////		java.sql.Date sqlDate = new Date(); // does not compile since Date is assumed to be util.Date
//		java.sql.Date sqlDate = new java.sql.Date(0);
		
		// without imports:
//		java.util.Date utilDate = new Date(); // does snot compile if import is missing
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(0);
	}
	
}


