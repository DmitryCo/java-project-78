package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T> extends BaseSchema<Map<String, T>> {

    public MapSchema() {
        super(false);
    }

    public MapSchema<T> required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(Integer size) {
        addCheck("mapSize", m -> m.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addCheck("shape", map -> {
            for (Map.Entry<String, BaseSchema<T>> entry : schemas.entrySet()) {
                if (!entry.getValue().isValid(map.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
