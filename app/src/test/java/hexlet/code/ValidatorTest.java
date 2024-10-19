package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class ValidatorTest {
    @Test
    public void validationTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required().minLength(2));
        schemas.put("lastName", v.string().required().minLength(3));
        schemas.put("sex", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "Max");
        human1.put("lastName", "Holiday");
        human1.put("sex", "male");
        human1.put("age", 46);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("firstName", "Adrian");
        human2.put("lastName", "Howard");
        human2.put("sex", null);
        human2.put("age", 53);
        assertThat(schema.isValid(human2)).isFalse();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("firstName", "S");
        human3.put("lastName", "Miller");
        human3.put("sex", "female");
        human3.put("age", 53);
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("firstName", "Ellis");
        human4.put("lastName", "Brooks");
        human4.put("sex", "female");
        human4.put("age", -21);
        assertThat(schema.isValid(human4)).isFalse();

        schema.sizeof(4);
        assertThat(schema.isValid(human2)).isFalse();

        schema.required();
        assertThat(schema.isValid(human2)).isFalse();
    }
}
