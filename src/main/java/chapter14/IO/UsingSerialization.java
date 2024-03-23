package chapter14.IO;

import java.io.Serializable;

public class UsingSerialization implements Serializable {
	
	// JVM uses to UID determine the version of the class if its structure changes
	// e.g. adding/removing fields
	// not required
	private static final long serialVersionUID = 30854598878809393L; 

	private String name = "Brian";
	
	private int age = 39;
	
	// transient and static fields (except for version ID) are not serialized
	private transient String dob = "08/27/1984";
	private static String cookie = "oreo";
	
	
}


