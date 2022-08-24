import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
	
	static int level = 1;
	static int counter = 0;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the file path: ");
		String filePath = input.nextLine();
		
		File file = new File(filePath);

		System.out.printf("File source: " + file.toString() + "\nTotal File Size: %.2f"  + " Megabytes" + "\nTotal number of files: " + file.list().length, getFileSize(file));
		System.out.println();
		System.out.println("----------------------------------------------------------------");

		 extracted(file);
		 
		 
	}
	
	

	private static void extracted(File file) {
		File[] children = file.listFiles();
	    StringBuilder builder = new StringBuilder();
	    
		
		for (int i = 0; i < children.length; i++) {
			if (children[i].isFile()) {
				
				for (int j = counter; j < level; j++) {
					builder.append("\t");
					counter++;
				}
				
				System.out.println(builder + children[i].getName());
			}
			if (children[i].isDirectory()) {
				
				for (int j = counter; j < level; j++) {
					builder.append("\t");
					counter++;
				}
				System.out.println(builder + "Directory Name: " + children[i].getName());
				System.out.printf(builder + "Total Directory Size: %.2f Megabytes"
						+ builder + "Number of Files in directory: " + children[i].list().length , getFileSize(children[i]));
				System.out.println("\n");
				level++;
				level++;
				extracted(children[i]);
				
			}
		}
	}
	private static double getFileSize(File folder) {
		 double length = 0;
	       
	        // listFiles() is used to list the
	        // contents of the given folder
	        File[] files = folder.listFiles();
	 
	        int count = files.length;
	 
	        // loop for traversing the directory
	        for (int i = 0; i < count; i++) {
	            if (files[i].isFile()) {
	                length += files[i].length();
	            }
	            else {
	                length += getFileSize(files[i]);
	            }
	        }
	        return length / 1000000;
	}
	

}
