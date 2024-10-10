package chapter14.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class OperatingOnFilePath {
	
		public static void main(String[] args) throws IOException {
			// When you compile and run the Java program, 
			// it executes from the PROJECT's root directory unless you specify a different directory explicitly.
			// SO this main method is executing from Brian.Java-OCP-Certification NOT chapter14.IO.OperatingOnFilePath
			// this is why the relative path is not from IO
			// e.g. "../../../resources/chapter14/zoo.txt" to "main/java/chapter14" is wrong
			// relative path from execution is src/main.....
			// "./" and "../main" are redundant 
			
			System.out.println("'./' path : " + Path.of("./")); // ignores trailing '/'
			
			// notice how getRoot() and toAbsolutePath() change if this is a root or relative path
			Path zooTxtFile = Path.of("src/./main/../main/resources/chapter14/zoo.txt"); 
			Path zooSameFile = Path.of("src/main//resources/chapter14/zoo.txt");
			System.out.println("zooTxtFile.equals(zooSameFile): " + zooTxtFile.equals(zooSameFile));
			System.out.println("Files.isSameFile(p1, p2): " + Files.isSameFile(zooTxtFile, zooSameFile));
			System.out.println("normalized > zooTxtFile.equals(zooSameFile): " + zooTxtFile.normalize().equals(zooSameFile.normalize()));
			System.out.println("toRealPath equals: " + zooTxtFile.toRealPath().equals(zooSameFile.toRealPath()));
			System.out.println("print Path object: " + zooTxtFile);
			System.out.println("toString(): " + zooTxtFile.toString());
			System.out.println("normalize(): " + zooTxtFile.normalize());
			System.out.println("absolute path: " + zooTxtFile.toAbsolutePath());
			System.out.println("toRealPath(): " + zooTxtFile.toRealPath());
			System.out.println("getParent(): " + zooTxtFile.getParent());
			System.out.println("getFileName(): " + zooTxtFile.getFileName());
			System.out.println("getRoot(): " + zooTxtFile.getRoot()); 
			// null if the path is relative i.e. not starting with / or C:  >  can still retrieve absolute path from current directory
			// if does indicate root returns that HOWEVER that will also be the absolute path
			System.out.println("getRoot() of absolute path: " + zooTxtFile.toAbsolutePath().getRoot());
			System.out.println("file exists: " + Files.exists(zooTxtFile));
			System.out.println();
			
			System.out.println("view path: ");
			for (int i=0; i<zooTxtFile.getNameCount(); i++) {
				System.out.println("\t index: " + i + " index name:" + zooTxtFile.getName(i)); 
				// notice last element is zoo.txt
				// path.getName(index i) is different than file.getName()
			}
			System.out.println("subpath(2,5): " + zooTxtFile.subpath(2, 5));
			System.out.println();
			
			Path varargPath = Paths.get("src/main", "resources","///chapter14/"); // resolves path correctly with,without, or multiple /
			System.out.println("Paths.get(varargs): " + varargPath);
			System.out.println("getRoot()" + varargPath.getRoot());
			System.out.println();
			
			System.out.println("io():");
			io();
			System.out.println();
			
			System.out.println("nio:");
			nio();
		}
		
		public static void io() {
			// consecutive slashes in string expression are interpreted as a single slash
			var file = new File("src//////main/resources/chapter14/zoo.txt");
			if (file.exists()) {
				System.out.println("file: " + file);
				System.out.println("Absolute Path: " + file.getAbsolutePath());
				System.out.println("Is Directory: " + file.isDirectory());
				System.out.println("Parent Path: " + file.getParent());
				if (file.isFile()) {
					System.out.println("Length: " + file.length());
					System.out.println("Last Modified: " + file.lastModified());
					System.out.println("File name: " + file.getName());
				} else {
					for (File subfile : file.listFiles()) {
						System.out.println(" " + subfile.getName());
					} 
				}	 
			} 
			System.out.println();
			var resourceDirectory = new File("src/main/resources");
			var directory = new File(resourceDirectory, "/chapter14");
			if (directory.exists()) {
				System.out.println("Absolute Path: " + directory.getAbsolutePath());
				System.out.println("Is Directory: " + directory.isDirectory());
				System.out.println("Parent Path: " + directory.getParent());
				if (directory.isDirectory()) {
					System.out.println("Size: " + directory.length());
					System.out.println("Last Modified: " + directory.lastModified());
					System.out.println("Directory name: " + directory.getName());
					File[] list = directory.listFiles();
					System.out.println("Directory files: " + Arrays.toString(list));
					for (File subfile : list) {
						System.out.println("subfile: " + subfile.getName());
					} 
				} 
			} else {
				System.out.println("doesn't exist: " + directory);
			}
		}
		
		public static void nio() throws IOException {
			var path = Path.of("src/main/resources","/chapter14");
			
			if (Files.exists(path)) {
				System.out.println("Absolute Path: " + path.toAbsolutePath());
				System.out.println("Is Directory: " + Files.isDirectory(path));
				System.out.println("Parent Path: " + path.getParent());
				if (Files.isRegularFile(path)) {
					System.out.println("Size: " + Files.size(path));
					System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
				} else {
					try (Stream<Path> stream = Files.list(path)) {  // NIO stream methods open a connection which must be closed
						stream.forEach(p -> System.out.println(" " + p.getFileName()));
					} 
				}
			}
			
			
		}
		
}


