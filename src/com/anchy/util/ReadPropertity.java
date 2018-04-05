package com.anchy.util;
import java.io.IOException;
import java.util.Properties;
public class ReadPropertity {
	 static Properties props = new Properties();
     static {
             try {
                     props.load(ReadPropertity.class.getResourceAsStream("utils.properties"));
                     System.out.println("+++++++++++++++++++"+props.getProperty("emailsmtp"));
                     System.out.println("+++++++++++++++++++"+props.getProperty("emailaddress"));
                     System.out.println("+++++++++++++++++++"+props.getProperty("emailpass"));
             } catch (IOException e1) {
                     e1.printStackTrace();
             }
     }
     public static final String EMAILSMTP=props.getProperty("emailsmtp");
     public static final String EMAILADDRESS=props.getProperty("emailaddress");
     public static final String EMAILPASS=props.getProperty("emailpass");
     public static String getProperty(String key) {
             return props.getProperty(key);
     }
}
