package constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
        // Prevent object creation
    }

    public static final String CONFIG_FILE_PATH =
            System.getProperty("user.dir")
            + "/src/main/resources/config/config.properties";

    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir")
            + "/test-output/screenshots/";

    public static final int EXPLICIT_WAIT = 10;
}