package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @param <T> Тип, которым типизируется класс наследник
 */
public class BaseSchema<T> {
    protected boolean required;
    protected Map<String, Predicate<T>> checks;

    public BaseSchema() {
        this.required = false;
        this.checks = new LinkedHashMap<>();
    }

    /**
     * @param checkName Ключ - название правила валидации
     * @param testCheck Значение - правило валидации
     */
    public void addCheck(String checkName, Predicate<T> testCheck) {
        checks.put(checkName, testCheck);
    }

    /**
     * @param <T> Тип объекта для проверки
     */
    public boolean isValid(T objectForValidation) {
        if (required && objectForValidation == null) {
            return false;
        }
        for (var check : checks.values()) {
            if (!check.test(objectForValidation)) {
                return false;
            }
        }
        return true;
    }
}
