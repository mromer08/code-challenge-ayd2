package com.usac.ayd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CC1Test {

    CC1 cc1;
    @BeforeEach
    void setUp() {
        cc1 = new CC1();
    }

    @Test
    void DosPalabrasNoSonAnagramas() {
        assertFalse(cc1.esAnagrama("hola", "cola"));
    }
}