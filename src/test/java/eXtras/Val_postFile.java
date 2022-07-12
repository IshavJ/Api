package eXtras;

import org.apache.commons.lang3.RandomStringUtils;

public class Val_postFile {
    public static String get_Name(){
        String getname = RandomStringUtils.randomAlphabetic(1);
        return("Ishav"+getname);
    }

    public static String set_Name(){
        return "Sam" ;
    }

    public static String get_Job(){
        String getJob = RandomStringUtils.randomAlphabetic(1);
        return("Tester"+getJob);
    }

    public static String set_Job(){
        return "Teacher";
    }
}
