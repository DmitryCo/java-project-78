package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super(false);
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
