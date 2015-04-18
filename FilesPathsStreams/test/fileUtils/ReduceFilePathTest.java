package fileUtils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReduceFilePathTest {

	@Test
	public void test() {
		String path = "/home//radorado/code/./hackbulgaria/week0/../";
		String actual = FileUtils.reduceFilePath(path);
		assertEquals("/home/radorado/code/hackbulgaria", actual);
	}

}
