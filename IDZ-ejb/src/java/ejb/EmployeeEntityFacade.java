/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author John
 */
@Stateless
public class EmployeeEntityFacade extends AbstractFacade<EmployeeEntity> {
    @PersistenceContext(unitName = "IDZ-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeEntityFacade() {
        super(EmployeeEntity.class);
    }
    
    public List<EmployeeEntity> findByDegree(Long degreeId) {
        TypedQuery<EmployeeEntity> query;
        if (degreeId == null) {
            query = em.createQuery("SELECT n FROM EmployeeEntity n WHERE n.academicDegree IS NULL", EmployeeEntity.class);    
        } else {
            query = em.createQuery("SELECT n FROM EmployeeEntity n WHERE n.academicDegree.id = :degreeId", EmployeeEntity.class);    
            query.setParameter("degreeId", degreeId);
        }
        return query.getResultList();
    }
}
