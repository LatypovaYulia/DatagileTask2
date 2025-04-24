import com.codeborne.selenide.Configuration;
import org.junit.Before;

import java.io.IOException;

public class BaseTest {
    @Before
    public void startUp() throws IOException {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.downloadsFolder = "build/downloads";
    }
}
