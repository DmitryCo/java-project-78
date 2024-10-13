package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        addCheck("isAllowedAndEmpty", s -> (s != null) && (!required || !s.isEmpty()));
        addCheck("isString", Objects::nonNull);
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int lengthOfString) {
        addCheck("minLength", s -> ((String) s).length() >= lengthOfString);
        return this;
    }

    public StringSchema contains(String contentLimit) {
        addCheck("contains", s -> ((String) s).contains(contentLimit));
        return this;
    }
}
