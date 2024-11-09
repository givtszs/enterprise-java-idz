/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John
 */
@Stateless
public class AcademicDegreeEntityFacade extends AbstractFacade<AcademicDegreeEntity> {
    @PersistenceContext(unitName = "IDZ-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcademicDegreeEntityFacade() {
        super(AcademicDegreeEntity.class);
    }
}
