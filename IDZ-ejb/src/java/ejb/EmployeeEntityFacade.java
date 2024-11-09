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

    public List<EmployeeEntity> findByDegreeAndRank(String degreeId, String rankId) throws NumberFormatException {
        String _null = "null";
        StringBuilder queryString = new StringBuilder("SELECT n FROM EmployeeEntity n WHERE 1=1");

        if (degreeId != null) {
            if (_null.equals(degreeId)) {
                queryString.append(" AND n.academicDegree IS NULL");
            } else {
                queryString.append(" AND n.academicDegree.id = :degreeId");
            }
        }
        
        if (rankId != null) {
            if (_null.equals(rankId)) {
                queryString.append(" AND n.academicRank IS NULL");
            } else {
                queryString.append(" AND n.academicRank.id = :rankId");
            }
        }

        TypedQuery<EmployeeEntity> query = em.createQuery(queryString.toString(), EmployeeEntity.class);
        if (degreeId != null && !_null.equals(degreeId)) {
            query.setParameter("degreeId", Long.parseLong(degreeId));
        }
        if (rankId != null && !_null.equals(rankId)) {
            query.setParameter("rankId", Long.parseLong(rankId));
        }
        
        return query.getResultList();
    }
}
