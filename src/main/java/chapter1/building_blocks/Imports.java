package chapter1.building_blocks;

//import java.lang.System; // redundant java.lang is automatically imported
//import java.lang.*;  // redundant
//import java.lang.Math.PI; // cannot import methods unless static method and static import
import static java.lang.Math.PI;
//import java.util.*;  // redundant
//import java.util.Random;

//import java.lang.*.*; // only one wildcard allowed


// naming conflicts
//import java.util.Date;
//import java.sql.Date;  // does not compile

// ambiguous imports: imports will compile 
	// HOWEVER declaring a Date object WILL NOT compile
//import java.util.*; 
//import java.sql.*;

// better imports to compile code
//import java.util.Date;
//import java.sql.*;

public class Imports {

	public static void main(String[] args) {
		double d = Math.PI;
		double pi = PI;
		
//		Date utilDate = new Date(); // ambiguous with 2 wild card imports
		
		// compiles with 
//		Date utilDate = new Date();
//		java.sql.Date sqlDateA = new Date(); // does not compile since Date is assumed to be util.Date
//		java.sql.Date sqlDateB = new java.sql.Date(0);
	
		// without imports:
//		java.util.Date utilDateBad = new Date(); // does snot compile if import is missing
		java.util.Date utilDate1 = new java.util.Date();
		java.sql.Date sqlDate1 = new java.sql.Date(0);
	}
	
}


