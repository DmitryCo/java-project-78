package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean required;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected BaseSchema(boolean required) {
        this.required = false;
        Predicate<T> nonNull = value -> !(value == null);
        this.checks.put("nonNull", nonNull);
    }

    public void addCheck(String checkName, Predicate<T> testCheck) {
        checks.put(checkName, testCheck);
    }

    public boolean isValid(T objectForValidation) {
        var isNull = !checks.get("nonNull").test(objectForValidation);
        if (!required && isNull) {
            return true;
        }
        for (var check : checks.values()) {
            if (!check.test(objectForValidation)) {
                return false;
            }
        }
        return true;
    }
}
