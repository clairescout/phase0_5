package client;

import org.junit.Test;


import models.Results;

import static org.junit.Assert.assertEquals;

/**
 * Created by clairescout on 1/19/18.
 */

public class StringProcessorProxy_CommandsTest {

    private StringProcessorProxy_Commands sppCommands = new StringProcessorProxy_Commands();


    @Test
    public void testToLowerCaseCommand(){
        Results r = new Results(true, "claire", null);
        Results r2 = sppCommands.toLowerCase("CLAIRE");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testToLowerCaseNull(){
        Results r = new Results(false, null, "String is Null");
        Results r2 = sppCommands.toLowerCase(null);
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testToLowerCaseWeird(){
        Results r = new Results(true, "a!@#@$%asdf", null);
        Results r2 = sppCommands.toLowerCase("a!@#@$%ASDF");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testTrim(){
        Results r = new Results(true, "hello", null);
        Results r2 = sppCommands.trim("     hello    ");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testTrimNull(){
        Results r = new Results(false, null, "String is Null");
        Results r2 = sppCommands.trim(null);
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testTrimSpaceInMiddleOfString(){
        Results r = new Results(true, "i love everything about cs340", null);
        Results r2 = sppCommands.trim("    i love everything about cs340    ");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testParseInteger(){
        Results r = new Results(true, "183", null);
        Results r2 = sppCommands.parseInteger("183");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testInvalidInputParseInteger(){
        Results r = new Results(false, null, "Number Format Exception");
        Results r2 = sppCommands.parseInteger("!#@#%asdf");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }


}
