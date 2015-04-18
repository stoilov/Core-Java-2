package findbrokenlinks;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrokenLinks {

	public static void findBrokenLinks(Path path) {
		File[] listOfFiles = path.toFile().listFiles();
		for (File file : listOfFiles) {
			if(!Files.isSymbolicLink(file.toPath())) {
				System.out.printf("Not a symbolic link: '%s'", file);
			}
		}
	}
	
}
