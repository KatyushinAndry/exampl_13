package pure.main.owner.helpers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import pure.main.owner.config.DriverConfig;

public class DriverHelper {
    private static final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    private static DriverConfig getDriverConfig(){
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    public static boolean isRemote(){
        return config.isRemote();
    }

    public static String getVideoUrl(){
        return getDriverConfig().videoStorage();
    }


    public static void configureDriver(String baseUrl){
        Configuration.startMaximized = true;
        Configuration.baseUrl = baseUrl;
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.timeout = 4000;

        if (isRemote()) {
            Configuration.remote = config.getURL().toString();
        }
    }
}
