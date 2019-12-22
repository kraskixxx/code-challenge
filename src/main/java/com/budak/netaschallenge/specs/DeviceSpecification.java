package com.budak.netaschallenge.specs;

import com.budak.netaschallenge.domain.Device;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samet BUDAK
 * @since
 */
public class DeviceSpecification implements Specification<Device> {

    private final Device example;

    public DeviceSpecification(Device example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Device> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(example.getBrand())) {
            predicates.add(cb.like(cb.lower(root.get("brand")), example.getBrand().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(example.getModel())) {
            predicates.add(cb.like(cb.lower(root.get("model")), example.getModel().toLowerCase() + "%"));
        }

        if (example.getOs() != null) {
            predicates.add(cb.equal(root.get("os"), example.getOs()));
        }

        if (!StringUtils.isEmpty(example.getOsVersion())) {
            predicates.add(cb.equal(root.get("osVersion"), example.getOsVersion()));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}