package chapter14.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class OperatingOnFilePath {

	
		public static void main(String[] args) throws IOException {
			io();
			
			System.out.println("\nnio:");
			nio();
		}
		
		public static void io() {
			// consecutive slashes in string expression are interpreted as a single slash
			var file = new File("src//////main/resources/chapter14/zoo.txt");
			if (file.exists()) {
				System.out.println("Absolute Path: " + file.getAbsolutePath());
				System.out.println("Is Directory: " + file.isDirectory());
				System.out.println("Parent Path: " + file.getParent());
				if (file.isFile()) {
					System.out.println("Size: " + file.length());
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


