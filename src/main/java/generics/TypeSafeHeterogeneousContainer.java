package generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TypeSafeHeterogeneousContainer {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }


    public static void main(String[] args) {
        TypeSafeHeterogeneousContainer container = new TypeSafeHeterogeneousContainer();
        container.putFavorite(String.class, "a");
        container.putFavorite(String.class, "b");
        System.out.println(container.getFavorite(String.class));
    }
}
