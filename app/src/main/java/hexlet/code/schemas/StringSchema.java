package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        super.required = true;
        addCheck("notEmpty", s -> !((String) s).isEmpty());
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
