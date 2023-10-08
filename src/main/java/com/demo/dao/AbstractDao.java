package com.demo.dao;

import static com.demo.util.constants.DBConstants.SCHOOL_ENTITY_MANAGER_FACTORY;
import static com.demo.util.constants.DBConstants.STORE_ENTITY_MANAGER_FACTORY;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {

    @PersistenceContext(unitName = STORE_ENTITY_MANAGER_FACTORY)
    protected EntityManager storeEntityManager;

    @PersistenceContext(unitName = SCHOOL_ENTITY_MANAGER_FACTORY)
    protected EntityManager schoolEntityManager;

    protected <T> void batchSave(List<T> list, EntityManager entityManager) {
        int batchSize = 50;
        batches(list, batchSize).forEach(l -> {
            l.forEach(entityManager::persist);
        });
        entityManager.flush();
        entityManager.clear();
    }

    protected <T> void batchUpdate(List<T> list, EntityManager entityManager) {
        int batchSize = 50;
        batches(list, batchSize).forEach(l -> {
            l.forEach(entityManager::merge);
        });
        entityManager.flush();
        entityManager.clear();
    }

    protected static <T> Stream<List<T>> batches(List<T> source, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length = " + length);
        }
        int size = source.size();
        if (size <= 0) {
            return Stream.empty();
        }
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1)
                .mapToObj(
                        n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
    }
}
