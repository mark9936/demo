package com.demo.mapstruct;

import java.util.Collection;
import java.util.List;

public interface GenericMapper<S, D> {

    D mapToBean(S source);

    S mapToEntity(D source);

    List<D> mapAsListToBean(List<S> sourceList);

    List<S> mapAsListToEntity(List<D> sourceList);

    Collection<D> mapAsCollectionToBean(Collection<S> sourceCollection);

    Collection<S> mapAsCollectionToEntity(Collection<D> sourceCollection);
}
