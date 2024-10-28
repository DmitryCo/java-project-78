package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        addCheck("isRequired", (value -> value != null));
    }

    public NumberSchema required() {
        super.required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", i -> i == null || i > 0);
        return this;
    }

    public NumberSchema range(int lowBorder, int highBorder) {
        addCheck("range", i -> ((Integer) i >= lowBorder && (Integer) i <= highBorder));
        return this;
    }
}
