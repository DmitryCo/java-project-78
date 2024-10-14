package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean required;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public void addCheck(String checkName, Predicate<T> testCheck) {
        checks.put(checkName, testCheck);
    }

    public boolean isValid(T objectForValidation) {
        if (Objects.equals(objectForValidation, null)) {
            return !required;
        }
        for (String key : checks.keySet()) {
            if (!checks.get(key).test(objectForValidation)) {
                return false;
            }
        }
        return true;
    }
}
