package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", i -> (Integer) i > 0);
        return this;
    }

    public NumberSchema range(int lowBorder, int highBorder) {
        addCheck("range", i -> ((Integer) i >= lowBorder && (Integer) i <= highBorder));
        return this;
    }
}
