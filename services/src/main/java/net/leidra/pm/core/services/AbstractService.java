package net.leidra.pm.core.services;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.leidra.pm.core.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * Created by afuentes on 14/12/15.
 */
public abstract class AbstractService<ENTITY, DTO> {
    @Autowired
    protected GenericRepository<ENTITY> repository;
    protected static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private Class<ENTITY> entityClass;
    private Class<DTO> dtoClass;

    @PostConstruct
    public void postConstruct() {
        configureMapper();
    }

    protected void configureMapper() {
        Type[] actualTypeArguments = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments();
        entityClass = (Class)actualTypeArguments[0];
        dtoClass = (Class)actualTypeArguments[1];

        getMapperFactory().classMap(entityClass, dtoClass);
    }

    public DTO findOne(Long id) {
        ENTITY entity = this.repository.findOne(id);

        return convertToDto(entity);
    }

    public Set<DTO> findAll() {
        List<ENTITY> entities = this.repository.findAll();

        return convertToDtos(entities);
    }

    protected DTO convertToDto(ENTITY entity) {
        return getMapperFactory().getMapperFacade().map(entity, dtoClass);
    }

    protected Set<DTO> convertToDtos(List<ENTITY> entity) {
        return getMapperFactory().getMapperFacade().mapAsSet(entity, dtoClass);
    }

    protected ENTITY convertToEntity(DTO dto) {
        return getMapperFactory().getMapperFacade().map(dto, entityClass);
    }

    protected Set<ENTITY> convertToEntities(List<DTO> dto) {
        return getMapperFactory().getMapperFacade().mapAsSet(dto, entityClass);
    }

    protected MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
