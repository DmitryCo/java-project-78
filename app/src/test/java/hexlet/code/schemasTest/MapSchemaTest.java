package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {

    @Test
    void testMapSchema() {
        Validator v1 = new Validator();
        MapSchema schema1 = v1.map();

        assertThat(schema1.isValid(null)).isTrue();

        schema1.required();
        assertThat(schema1.isValid(null)).isFalse();
        assertThat(schema1.isValid(new HashMap<>())).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema1.isValid(data)).isTrue();

        schema1.sizeof(2);
        assertThat(schema1.isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema1.isValid(data)).isTrue();

        Validator v2 = new Validator();
        MapSchema schema2 = v2.map();
        schema2.required().sizeof(3);

        assertThat(schema2.isValid(null)).isFalse();
        assertThat(schema2.isValid(new HashMap<>())).isFalse();
    }
}
