package wordcountresult;

public class WordCountResult {

	private int numberOfWords;
	private int numberOfLines;
	private int numberOfCharacters;

	public WordCountResult(int numberOfLines, int numberOfWords,
			int numberOfCharacters) {
		this.numberOfWords = numberOfWords;
		this.numberOfLines = numberOfLines;
		this.numberOfCharacters = numberOfCharacters;
	}

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public int getNumberOfCharacters() {
		return numberOfCharacters;
	}
}
