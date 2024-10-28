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
     * @param objectForValidation Тип объекта для проверки
     * @return Является значение валидным
     */
    public boolean isValid(T objectForValidation) {
        Predicate<T> checkRequired = checks.get("isRequired");
        if (!required && !checkRequired.test(objectForValidation)) {
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
