package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean required;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected BaseSchema(boolean required) {
        this.required = required;
    }

    public void addCheck(String checkName, Predicate<T> testCheck) {
        checks.put(checkName, testCheck);
    }

    public boolean isValid(T objectForValidation) {
        if (required && objectForValidation == null) {
            return false;
        }
        if (!required && objectForValidation == null) {
            return true;
        }
        for (Predicate<T> check : checks.values()) {
            if (!check.test(objectForValidation)) {
                return false;
            }
        }
        return true;
    }
}
