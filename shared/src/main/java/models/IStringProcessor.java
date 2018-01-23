package models;

/**
 * Created by clairescout on 1/13/18.
 */

public interface IStringProcessor {

    Results toLowerCase(String s);
    Results trim(String s);
    Results parseInteger(String s);
}
