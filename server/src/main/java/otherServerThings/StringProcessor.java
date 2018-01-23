package otherServerThings;


import models.IStringProcessor;
import models.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class StringProcessor implements IStringProcessor {

    private static StringProcessor instance = new StringProcessor();

    private StringProcessor(){}

    public static StringProcessor getInstance(){
        return instance;
    }

    public Results toLowerCase(String s){
        Results r = new Results();
        if(isNull(s)){
            r.setMessage("String is Null");
            r.setSuccess(false);
        }
        else{
            r.setData(s.toLowerCase());//does this work? who knows.
            r.setSuccess(true);
        }
        return r;
    }

    public Results trim(String s){
        Results r = new Results();
        if(isNull(s)){
            r.setMessage("String is Null");
            r.setSuccess(false);
        }
        else{
            r.setData(s.trim());
            r.setSuccess(true);
        }

        return r;
    }

    public Results parseInteger(String s){
        System.out.println("in parse integer");
        Results r = new Results();
        if(isNull(s)){
            r.setMessage("String is Null");
            r.setSuccess(false);
        }
        else{
            try{
                Integer.parseInt(s);
                r.setSuccess(true);
                r.setData(s);
            }
            catch(NumberFormatException e){
                r.setMessage("Number Format Exception");
                r.setSuccess(false);
            }
        }

        return r;
    }

    public boolean isNull(String s){
        if(s != null && !s.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
