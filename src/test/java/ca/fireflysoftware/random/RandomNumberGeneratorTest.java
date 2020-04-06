package ca.fireflysoftware.random;

import java.util.IntSummaryStatistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

	@DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
		RandomNumberGenerator generator = new RandomNumberGenerator(1000, 15, 20);
		IntSummaryStatistics summaryStatistics = generator.generateStream().sorted().summaryStatistics();
        assertTrue(summaryStatistics.getMin() >= 10);
        assertTrue(summaryStatistics.getMax() <= 20);
        assertEquals(1000, summaryStatistics.getCount());
    }
}