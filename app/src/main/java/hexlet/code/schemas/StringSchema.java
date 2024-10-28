package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        addCheck("isRequired", (value -> value != null && !value.isEmpty()));
    }

    public StringSchema required() {
        super.required = true;
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
