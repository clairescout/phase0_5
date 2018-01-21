package client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import theseclasses.Results;

import static org.junit.Assert.assertEquals;

/**
 * Created by clairescout on 1/19/18.
 */

public class StringProcessorProxy_CommandsTest {

    private StringProcessorProxy_Commands sppCommands = new StringProcessorProxy_Commands();

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void testToLowerCaseCommand(){
        Results r = new Results(true, "claire", null);
        Results r2 = sppCommands.toLowerCase("CLAIRE");
        assertEquals(r.getMessage(), r2.getMessage());
        assertEquals(r.isSuccess(), r2.isSuccess());
        assertEquals(r.getData(), r2.getData());
    }
}
