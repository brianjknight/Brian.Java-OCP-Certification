package chapter11.exceptionsLocalizations;

import java.io.IOException;
import java.sql.SQLException;

public class UsingExceptionsSubclass extends UsingExceptions {

	// a constructor must be declared since default would call super() no args which throws a checked exception 
	public UsingExceptionsSubclass() throws IOException, SQLException, Exception {
		super();
		// You can throw new or broader checked exceptions for overridden constructors	
	}
	
//	public UsingExceptionsSubclass(int i) { // does not compile
//		// JVM calls super() which throws a checked exception
//	}
	
}


