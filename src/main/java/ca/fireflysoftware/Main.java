package ca.fireflysoftware;
import java.io.IOException;

/**
 * Considering that 1,000,000 random numbers with at most 7 bytes each String stored [999,999 + line break]. 
 * Max file size is 7,000,000 bytes that is equal to 6.675 MB. 
 * It's reasonable to process the task in 2 parts but each file at once.
 * @author silva
 */
public class Main {

	private static final int VOLUME = 1_000_000;
	private static final String UNSORTED_FILE_NAME = "generated-files/unsorted/random-numbers";
	private static final String SORTED_FILE_NAME = "generated-files/sorted/random-numbers";
	private static final String EXTENSION = "txt";

	public static void main(String[] args) throws IOException {
		FireflyAssignment fireflyAssignment = new FireflyAssignment(VOLUME, UNSORTED_FILE_NAME, SORTED_FILE_NAME, EXTENSION);
		fireflyAssignment.process();
	}
}