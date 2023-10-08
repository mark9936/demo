package com.demo.mapstruct;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MapStructService {

    @Autowired
    private ApplicationContext context;

    public <S, D> D mapToBean(S source, Class<? extends GenericMapper<S, D>> mapperClass) {
        GenericMapper<S, D> mapper = context.getBean(mapperClass);
        return mapper.mapToBean(source);
    }

    public <S, D> S mapToEntity(D source, Class<? extends GenericMapper<S, D>> mapperClass) {
        GenericMapper<S, D> mapper = context.getBean(mapperClass);
        return mapper.mapToEntity(source);
    }

    public <S, D> List<D> mapAsListToBean(List<S> source,
            Class<? extends GenericMapper<S, D>> mapperClass) {
        GenericMapper<S, D> mapper = context.getBean(mapperClass);
        return mapper.mapAsListToBean(source);
    }

    public <S, D> List<S> mapAsListEntity(List<D> source,
            Class<? extends GenericMapper<S, D>> mapperClass) {
        GenericMapper<S, D> mapper = context.getBean(mapperClass);
        return mapper.mapAsListToEntity(source);
    }

    public <S, D> Collection<D> mapAsCollectionToBean(Collection<S> sourceCollection,
            Class<? extends GenericMapper<S, D>> mapperClass) {
        if (sourceCollection.isEmpty()) {
            return Collections.emptyList();
        }

        GenericMapper<S, D> mapper = context.getBean(mapperClass);
        return mapper.mapAsCollectionToBean(sourceCollection);
    }

    public <S, D> Collection<S> mapAsCollectionToEntity(Collection<D> sourceCollection,
            Class<? extends GenericMapper<S, D>> mapperClass) {
        if (sourceCollection.isEmpty()) {
            return Collections.emptyList();
        }

        GenericMapper<S, D> mapper = context.getBean(mapperClass);
        return mapper.mapAsCollectionToEntity(sourceCollection);
    }
}
