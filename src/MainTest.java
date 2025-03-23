import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MainTest {

    // Normal Cases

    @Test
    void testPairNormalCase() {
        // Arrange
        Pair<String, Integer> pair = new Pair<>("Test", 123);

        // Act
        String key = pair.getKey();
        Integer value = pair.getValue();

        // Assert
        assertEquals("Test", key);
        assertEquals(123, value);
    }

    @Test
    void testStackNormalCase() {
        // Arrange
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");

        // Act
        String popped = stack.pop();

        // Assert
        assertEquals("Second", popped);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testSortUtilityNormalCase() {
        // Arrange
        ArrayList<Integer> list = new ArrayList<>(List.of(5, 2, 8, 1, 9));

        // Act
        SortUtility.sort(list);

        // Assert
        assertEquals(List.of(1, 2, 5, 8, 9), list);
    }

    // Edge Cases

    @Test
    void testPairNullValuesEdgeCase() {
        // Arrange
        Pair<String, Integer> pair = new Pair<>(null, null);

        // Act
        String key = pair.getKey();
        Integer value = pair.getValue();

        // Assert
        assertNull(key);
        assertNull(value);
    }

    @Test
    void testStackEmptyEdgeCase() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act & Assert
        assertThrows(EmptyStackException.class, stack::pop);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSortUtilityEmptyListEdgeCase() {
        // Arrange
        ArrayList<String> list = new ArrayList<>();

        // Act
        SortUtility.sort(list);

        // Assert
        assertTrue(list.isEmpty());
    }
}