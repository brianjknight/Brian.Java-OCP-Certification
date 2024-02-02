package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> Mammal.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> CHANGE ME! <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Jan 31, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

public class Mammal {
	String type;
	String name;
	
	public List<CharSequence> play() { return new ArrayList<>(); }
	public CharSequence sleep() { return ""; }
}


