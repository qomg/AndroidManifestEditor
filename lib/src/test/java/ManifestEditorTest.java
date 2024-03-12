import com.wind.meditor.ManifestEditorMain;
import org.junit.Test;

public class ManifestEditorTest {
    @Test
    public void testAddMetadata() {
        String home = System.getProperty("user.home");
        new ManifestEditorMain().doMain(
                home + "/Downloads/app-release.apk",
                "-md",
                "UMENG_CHANNEL:1234",
                "-s",
                "-f"
        );
    }
}
