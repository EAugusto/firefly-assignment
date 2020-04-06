package ca.fireflysoftware;

import java.util.stream.IntStream;

import ca.fireflysoftware.io.FileReader;
import ca.fireflysoftware.io.FileWriter;
import ca.fireflysoftware.random.RandomNumberGenerator;
import ca.fireflysoftware.utils.StreamUtils;

public class FireflyAssignment {

	private final int volume;
	private final String unsortedFilename;
	private final String sortedFilename;
	private final String extension;
	
	public FireflyAssignment(int volume, String unsortedFilename, String sortedFilename, String extension) {
		this.volume = volume;
		this.unsortedFilename = unsortedFilename;
		this.sortedFilename = sortedFilename;
		this.extension = extension;
	}
	
	/**
	 * Evaluate Inversion of Control
	 */
	public void process() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(volume, 0, volume);
		IntStream randomNumbers = randomNumberGenerator.generateStream();
		
		String id = "-" + System.currentTimeMillis();
		
		FileWriter fileWriter = new FileWriter(unsortedFilename + id, extension);
		fileWriter.write(StreamUtils.getBytes(randomNumbers));
		
		FileReader fileReader = new FileReader(unsortedFilename + id, extension);
		IntStream readIntegers = fileReader.readIntegers().sorted();
		
		fileWriter = new FileWriter(sortedFilename + id, extension);
		fileWriter.write(StreamUtils.getBytes(readIntegers));
	}
	
}