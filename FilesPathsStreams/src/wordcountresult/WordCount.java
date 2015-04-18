package wordcountresult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCount {

	public static WordCountResult wordCount(Path path) {

		int lines = 0;
		int words = 0;
		int characters = 0;

		try (BufferedReader input = new BufferedReader(new FileReader(
				path.toFile()))) {

			String line;
			while ((line = input.readLine()) != null) {
				lines++;
				words += line.split(" ").length;
				characters += line.length();
			}
			
			characters += lines - 1;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new WordCountResult(lines, words, characters);
	}
	
	public static WordCountResult wordCount(File file) {
		return wordCount(file.toPath());
	}

}
