package tests;

import org.testng.annotations.Test;
import utils.Utils;

public class TestGetPropsFromConfigFile {

    @Test
    public void readConfig(){
        Utils util = new Utils();
        System.out.println(util.getPropsFromConfigFile().getProperty("app.name"));
        System.out.println(util.getPropsFromConfigFile().getProperty("app.version"));
    }

    @Test
    public void readProperty(){
        Utils util = new Utils();
        String TILE_SIZE = util.getValueFromConfigFileByKey("tile.size");
        String screenshot_dir = util.getValueFromConfigFileByKey("screenshot.dir");

        System.out.println(TILE_SIZE);
        System.out.println(screenshot_dir);
    }

}
