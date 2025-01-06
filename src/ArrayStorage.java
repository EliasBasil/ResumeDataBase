import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int pointer = 0;

    void clear() {
        for (int i = 0; i < pointer; i++) {
            storage[i] = null;
        }
        pointer = 0;
    }

    void save(Resume r) {
        storage[pointer] = r;
        pointer++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < pointer; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < pointer; i++) {
            if (storage[i].uuid.equals(uuid)) {
                i++;
                for (; i < pointer; i++) {
                    storage[i - 1] = storage[i];
                }
                storage[pointer] = null;
                pointer--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, pointer);
    }

    int size() {
        return pointer;
    }
}