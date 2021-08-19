package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AbstractCompany;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.AppUserService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractCompany> {

    @Inject
    private AppUserService appUserService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setId(entity.getId());
        model.setCreatedDate(entity.getCreatedDate());
        model.setModifiedDate(entity.getModifiedDate());
        if (entity.getCreatedBy() != null){
            model.setCreatedById(entity.getCreatedBy().getId());
        }
        if (entity.getModifiedBy() != null){
            model.setModifiedById(entity.getModifiedBy().getId());
        }
        return model;
    }

    public List<M> createModelsFromList(List<T> entity) {
        return entity.stream().map(this::createModelFromEntity).collect(Collectors.toList());
    }

    public void populateEntityFromModel(T entity, M model) {
        entity.setCreatedDate(model.getCreatedDate());
        entity.setModifiedDate(model.getModifiedDate());
        if (model.getCreatedById() != null) {
            entity.setCreatedBy(appUserService.findById(model.getCreatedById()));
        }
        if (model.getModifiedById() != null) {
            entity.setModifiedBy(appUserService.findById(model.getModifiedById()));
        }
    }

    public abstract M initNewModel();

}
