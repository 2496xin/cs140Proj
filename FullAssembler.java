package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FullAssembler implements Assembler {

	@Override
	public int assemble(String inputFileName, String outputFileName, StringBuilder error) {
		ArrayList<String> list = new ArrayList<String>();
		try (Scanner input = new Scanner(new File(inputFileName))){
			while (input.hasNext()){
			    list.add(input.next());
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean blank = false;
		int lineNumber;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).trim().length() == 0) {
				blank = true;
				lineNumber = i;
				for (int j = i; j < list.size(); j++) {
					if (list.get(j).trim().length() != 0) {
						
					}
				}
			}
		}
		return 0;
	}

}
