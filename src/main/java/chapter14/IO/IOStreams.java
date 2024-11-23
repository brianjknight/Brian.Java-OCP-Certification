package chapter14.IO;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.nio.charset.Charset;

public class IOStreams {
	
	public static void main(String[] args) throws IOException {
	
		// all Input/OutputStreams and Reader/Writers are part of java.io package and use File objects NOT an nio.Path
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/path/to/file"));
		
		Reader fr = new FileReader("/path/to/file", Charset.forName("UTF-8"));
//		Reader fr__fr = new FileReader("/path/to/file", "UTF-8");
		
		// notice below low-level input type is a byte stream converted to char stream reader
		Reader isrStringParam = new InputStreamReader(new FileInputStream("/path/to/file"), "UTF-8");
		Reader isrCharsetParam = new InputStreamReader(new FileInputStream("/path/to/file"), Charset.forName("UTF-8"));
		
	}
	
	
}


