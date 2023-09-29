package fakeplayer.ketongu10.commands.video;

import java.util.HashMap;

public class Dict {
    private HashMap<Integer, String> dict = new HashMap<>();

    /**
     * Добавление элемента по ключу
     */
    public void add(Integer key, String value) {
        dict.put(key, value);
    }

    /**
     * Добавляет значение в конец HashMap
     */
    public void add(String value) {
        dict.put(dict.size(), value);
    }

    /**
     * Удаляет значение по ключу
     */
    public String remove(Integer key) {
        return dict.remove(key);
    }

    /**
     * Возвращает значение по ключу
     */
    public String get(Integer key) {
        return dict.get(key);
    }

    /**
     * Возвращает длину HashMap
     */
    public int length() {
        return dict.size();
    }

    /**
     * Пересоздаёт HashMap
     */
    public void clear() {
        dict = new HashMap<>();
        add("Запись из Java");
    }
}