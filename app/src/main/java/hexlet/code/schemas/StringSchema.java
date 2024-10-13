package hexlet.code.schemas;

public final class StringSchema {

    public StringSchema() {
        addCheck("isAllowedAndEmpty", s -> (s != null) && (!required || !s.isEmpty()));
        addCheck("isString", Objects::nonNull);
    }

    public StringSchema minLength(int lengthOfString) {
        addCheck("minLength", s -> ((String) s).length() >= lengthOfString);
        return this;
    }

    public StringSchema contains(String restriction) {
        addCheck("contains", s -> ((String) s).contains(restriction));
        return this;
    }

    public StringSchema required() {
        required = true;
        return this;
    }
}
