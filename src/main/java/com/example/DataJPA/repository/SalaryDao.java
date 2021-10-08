package com.example.DataJPA.repository;

import com.example.DataJPA.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SalaryDao {

    @Autowired
    private EntityManager em;

    public List<Salary> findBySalaryAndBonus(double amount, double bonus) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Salary> cq = cb.createQuery(Salary.class);

        Root<Salary> salary = cq.from(Salary.class);
        Predicate salaryAmountPredicate = cb.greaterThan(salary.get("amount"), amount);
        Predicate bonusPredicate = cb.lessThanOrEqualTo(salary.get("bonus"), bonus);
        Predicate finalPredicate = cb.and(salaryAmountPredicate, bonusPredicate);
        cq.where(finalPredicate);

        return em.createQuery(cq).getResultList();

    }


}
