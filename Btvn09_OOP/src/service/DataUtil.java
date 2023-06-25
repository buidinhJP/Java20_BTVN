package service;

import java.util.Collection;

public class DataUtil {
    public static <T> Boolean isEmptyCollection(Collection<T> collection){
        return collection == null || collection.isEmpty();
    }
}