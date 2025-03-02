package com.milktea.springstudyaccounts.account.stub;

import com.milktea.springstudyaccounts.utils.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class StubCrudRepository<T extends BaseEntity> implements CrudRepository<T, Long> {
    private static final String ID_FIELD_NAME = "id";
    private static final int INITIAL_CAPACITY = 50;

    private final Map<Long, T> storage = new ConcurrentHashMap<>(INITIAL_CAPACITY);
    private final AtomicLong idGenerator = new AtomicLong(1);


    @Override
    public <S extends T> S save(S entity) {
        if (entity.getId() == null) {
            ReflectionTestUtils.setField(entity, ID_FIELD_NAME, idGenerator.getAndIncrement());
        }

        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>(INITIAL_CAPACITY);

        for (S entity: entities) {
            savedEntities.add(save(entity));
        }

        return savedEntities;
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }

    @Override
    public Iterable<T> findAll() {
        return storage.values();
    }

    @Override
    public Iterable<T> findAllById(Iterable<Long> ids) {
        List<T> results = new ArrayList<>(INITIAL_CAPACITY);
        for (Long id : ids) {
            T entity = storage.get(id);
            if (entity == null) continue;
            results.add(entity);
        }
        return results;
    }

    @Override
    public long count() {
        return storage.size();
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public void delete(T entity) {
        if (entity.getId() == null) throw new IllegalArgumentException("해당하는 객체가 존재하지 않습니다.");

        deleteById(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        for (Long id: ids) {
            deleteById(id);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }
}
