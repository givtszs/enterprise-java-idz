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
public class ContractInfoEntityFacade extends AbstractFacade<ContractInfoEntity> {
    @PersistenceContext(unitName = "IDZ-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContractInfoEntityFacade() {
        super(ContractInfoEntity.class);
    }
}

