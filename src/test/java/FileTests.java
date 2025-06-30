import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.fsmanagementextended.file.JsonFile;
import ru.vladislav117.fsmanagementextended.file.VariantFile;
import ru.vladislav117.variant.Variant;

public final class FileTests {
    @Test
    public void testJsonFile() {
        FSManagementExtendedTestUtils.checkTestDirectory();
        JsonFile file = new JsonFile("test/json.json");

        Assertions.assertFalse(file.exists());

        file.writeIfNotExists(new JsonPrimitive(1));

        Assertions.assertTrue(file.exists());

        JsonElement content = file.read();

        Assertions.assertEquals(1, content.getAsJsonPrimitive().getAsInt());

        file.delete();

        Assertions.assertFalse(file.exists());
    }

    @Test
    public void testVariantFile() {
        FSManagementExtendedTestUtils.checkTestDirectory();
        VariantFile file = new VariantFile("test/variant.json");

        Assertions.assertFalse(file.exists());

        file.writeIfNotExists(Variant.newInteger(1));

        Assertions.assertTrue(file.exists());

        Variant content = file.read();

        Assertions.assertEquals(1, content.asInteger());

        file.delete();

        Assertions.assertFalse(file.exists());
    }
}
