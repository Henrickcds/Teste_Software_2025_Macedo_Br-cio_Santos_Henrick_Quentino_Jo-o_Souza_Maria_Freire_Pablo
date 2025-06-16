package com.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCircle {

    @Test
    public void testArea() {
        Circle c = new Circle(2.0);
        double expected = Math.PI * 4; // π * r^2
        assertEquals(expected, c.getArea(), 0.0001);
    }

    @Test
    public void testCircumference() {
        Circle c = new Circle(2.0);
        double expected = 2 * Math.PI * 2; // 2πr
        assertEquals(expected, c.getCircumference(), 0.0001);
    }
}