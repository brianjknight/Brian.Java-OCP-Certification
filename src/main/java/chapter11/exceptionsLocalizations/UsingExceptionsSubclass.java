package chapter11.exceptionsLocalizations;

import java.io.IOException;
import java.sql.SQLException;

/****************************************************************************
 * <b>Title:</b> UsingExceptionsSubclass.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> CHANGE ME! <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Jul 28, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

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


