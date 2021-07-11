package com.hardis.transferFichier.model;

import com.hardis.transferFichier.exceptions.AllExceptions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ReferenceTest {

    @Test
    void exception_NumeroArguments()  {
        AllExceptions thrown = assertThrows(AllExceptions.class, () ->new Reference("1462100403;100.1;9"));
        assertTrue(thrown.getMessage().contains("Incorrect number of arguments"));

    }
    @Test
    void ColorTest_reference()  {
      Reference ref= new Reference("1462100403;B;105.23;97");
      assertTrue(ref.getColor().equals(ColorRGB.B));
    }
    @Test
    void exception_numReference()  {
        AllExceptions thrown = assertThrows(AllExceptions.class, () ->new Reference("1462144;G;5.56;19"));
        assertTrue(thrown.getMessage().contains("Incorrect value for numReference"));

    }

    @Test
    void exception_color()  {
        AllExceptions thrown = assertThrows(AllExceptions.class, () ->new Reference("1462100403;A;100.1;9"));
        assertTrue(thrown.getMessage().contains("Incorrect value for color"));
    }

}
