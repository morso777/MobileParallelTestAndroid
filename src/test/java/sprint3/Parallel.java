package sprint3;

import PageObjects.BaseTestParallelSauceLabs;
import PageObjects.HomePage;
import org.testng.annotations.Test;

public class Parallel extends BaseTestParallelSauceLabs {

    HomePage homePage;

    @Test(priority = 1)
    public void LaunchApp() {
        homePage.checkContinueButton();
    }
}
