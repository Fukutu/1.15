package cofh.lib.util;

public interface IResourceStorage {

    default boolean clear() {

        if (isEmpty()) {
            return false;
        }
        modify(-getCapacity());
        return true;
    }

    default boolean isFull() {

        return getSpace() <= 0;
    }

    default int getSpace() {

        return getCapacity() - getStored();
    }

    void modify(int amount);

    boolean isEmpty();

    int getCapacity();

    int getStored();

    String getUnit();

}
