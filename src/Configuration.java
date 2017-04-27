/**
 * Created by xiaobang213452 on 2017/4/26.
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public final class Configuration {

    private final Properties configuration = new Properties();

    /**
     * Loads the configuration from the default file
     * <code>config.properties</code>
     *
     * @throws IOException
     */
    public Configuration() throws IOException {
        this("config.properties");
    }

    /**
     * Loads the configuration from the given file.
     * @param confFile
     * @throws IOException
     */
    public Configuration(String confFile) throws IOException {
        // Load property from file there is one
        FileInputStream fis = new FileInputStream(confFile);
        configuration.load(fis);
        fis.close();
        logger.info("Configuration loaded from file: " + confFile);

    }


    public boolean containsKey(String key) {
        return configuration.containsKey(key);
    }

    /**
     * Returns a given property, converting the value to an integer.
     *
     * @param key - the key identifying the property
     * @param defValue - the default value to use in case the key is not found.
     * @return the value of key property or defValue if key not found
     */
    public int getIntProperty(String key, int defValue) {
        String str = configuration.getProperty(key);
        if (str == null) {
            logger.fine("Property not found: " + key + ". Using default value: " +
                    defValue);
            return defValue;
        }
        return Integer.parseInt(str);
    }

    /**
     * Returns a given property, converting the value to a boolean.
     *
     * @param key - the key identifying the property
     * @param defValue - the default value to use in case the key is not found.
     * @return the value of key property or defValue if key not found
     */
    public boolean getBooleanProperty(String key, boolean defValue) {
        String str = configuration.getProperty(key);
        if (str == null) {
            logger.fine("Property not found: " + key + ". Using default value: " + defValue);
            return defValue;
        }
        return Boolean.parseBoolean(str);
    }

    /**
     *
     * @param key - the key identifying the property
     * @param defValue - the default value to use in case the key is not found.
     *
     * @return the value of key property or defValue if key not found
     */
    public String getProperty(String key, String defValue) {
        String str = configuration.getProperty(key);
        if (str == null) {
            logger.fine("Property not found: " + key + ". Using default value: " + defValue);
            return defValue;
        }
        return str;
    }

    public double getDoubleProperty(String key, double defultValue) {
        String str = configuration.getProperty(key);
        if (str == null) {
            logger.fine("Property not found: " + key + ". Using default value: " + defultValue);
            return defultValue;
        }
        return Double.parseDouble(str);
    }

    public long getLongProperty(String key, long defultValue) {
        String str = configuration.getProperty(key);
        if (str == null) {
            logger.fine("Property not found: " + key + ". Using default value: " + defultValue);
            return defultValue;
        }
        return Long.parseLong(str);
    }

    private final static Logger logger = Logger.getLogger(Configuration.class.getCanonicalName());
}
