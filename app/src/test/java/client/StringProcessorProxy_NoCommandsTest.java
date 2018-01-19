package client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import theseclasses.Results;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by clairescout on 1/15/18.
 */

public class StringProcessorProxy_NoCommandsTest {

    private StringProcessorProxy_NoCommands spp = new StringProcessorProxy_NoCommands();

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void testParseInteger(){
        Results r = new Results(true, "183", null);
        Results r2 = spp.parseInteger("183");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testNullForParseInteger(){
        Results r = new Results(false, null, "String is Null");
        Results r2 = spp.parseInteger(null);
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testOtherSymbolsParseInteger(){
        Results r = new Results(false, null, "Number Format Exception");
        Results r2 = spp.parseInteger("aweb");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testToLowerCase(){
        Results r = new Results(true, "claire", null);
        Results r2 = spp.toLowerCase("CLAIRE");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testToLowerCaseNull(){
        Results r = new Results(false, null, "String is Null");
        Results r2 = spp.toLowerCase(null);
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }

    @Test
    public void testTrim(){
        Results r = new Results(true, "hello", null);
        Results r2 = spp.trim("     hello    ");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }
}
