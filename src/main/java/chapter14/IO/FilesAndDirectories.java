package chapter14.IO;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndDirectories {

	public static void main(String[] args) {
		
		System.out.println("my file system separator is: " + System.getProperty("file.separator"));
		
		System.out.println();
		
		var myfile = Paths.get("test.txt");
        try(var bfr = Files.newBufferedReader(myfile, Charset.forName("US-ASCII") )){
            String line = null;
            while( (line = bfr.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.out.println();
        System.out.println("enthuware test 5 question 19:");
        Path p1 = Paths.get("photos/../beaches/./calangute/a.txt");
        System.out.println("p1: " + p1);
        Path p2 = p1.normalize();
        System.out.println("p2: " + p2 );
        Path p3 = p1.relativize(p2);
        Path p4 = p2.relativize(p1);

        System.out.println(
            p1.getNameCount()+" "+p2.getNameCount()+" "+
            p3.getNameCount()+" "+p4.getNameCount());
        
        
        System.out.println();
        System.out.println("system properties:");
        for(var x : System.getProperties().entrySet()){
        	  var m = x.getKey();
        	  System.out.println(x);
        	}
	}
	
	
	
}


