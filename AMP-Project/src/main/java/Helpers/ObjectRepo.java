package Helpers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectRepo {
    private static final Properties projectProperties = new Properties();
    static File directoryPath = new File("src/main/resources/ObjectRepositories");
    static File[] listOfFiles = directoryPath.listFiles();
    static {
        try {
            InputStream resourceInputStream = null;
            for (int i = 0; i < listOfFiles.length; i++) {
                resourceInputStream = ObjectRepo.class.getClassLoader().getResourceAsStream("ObjectRepositories/"+listOfFiles[i].getName());
                projectProperties.load(resourceInputStream);
            }
            resourceInputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String getSelector(String key) {
        return projectProperties.getProperty(key, null);
    }
}
