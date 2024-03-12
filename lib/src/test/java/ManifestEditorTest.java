import com.wind.meditor.ManifestEditorMain;
import org.junit.Test;

import java.io.File;

public class ManifestEditorTest {
    @Test
    public void testAddMetadata() {
        String home = System.getProperty("user.home");
        String filepath = home + "/Downloads/app-release.apk";
        boolean exists = new File(filepath).exists();
        if (exists) {
            new ManifestEditorMain().doMain(
                    filepath,
                    "-md",
                    "UMENG_CHANNEL:1234",
                    "-s",
                    "-f"
            );
        }
    }
}
