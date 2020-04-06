package ca.fireflysoftware.random;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

	private int size;
	private int startOffset;
	private int endOffset;

	public RandomNumberGenerator(int size, int startOffset, int endOffset) {
		this.size = size;
		this.startOffset = startOffset;
		this.endOffset = endOffset;
	}
	
	public IntStream generateStream() {
		return new Random().ints(size, startOffset, endOffset);
	}
	
}