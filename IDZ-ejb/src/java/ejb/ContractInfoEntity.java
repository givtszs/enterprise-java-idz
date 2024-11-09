/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Entity
public class ContractInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hiringDate;
    
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;
    
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;
    
    @Temporal(TemporalType.DATE)
    private Date prevVacationStartDate;
    
    @Temporal(TemporalType.DATE)
    private Date prevVacationEndDate;
    
    @Temporal(TemporalType.DATE)
    private Date nextVacationStartDate;
    
    @Temporal(TemporalType.DATE)
    private Date nextVacationEndDate;

    public Long getId() {
        return id;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Date getPrevVacationStartDate() {
        return prevVacationStartDate;
    }

    public void setPrevVacationStartDate(Date prevVacationStartDate) {
        this.prevVacationStartDate = prevVacationStartDate;
    }

    public Date getPrevVacationEndDate() {
        return prevVacationEndDate;
    }

    public void setPrevVacationEndDate(Date prevVacationEndDate) {
        this.prevVacationEndDate = prevVacationEndDate;
    }

    public Date getNextVacationStartDate() {
        return nextVacationStartDate;
    }

    public void setNextVacationStartDate(Date nextVacationStartDate) {
        this.nextVacationStartDate = nextVacationStartDate;
    }

    public Date getNextVacationEndDate() {
        return nextVacationEndDate;
    }

    public void setNextVacationEndDate(Date nextVacationEndDate) {
        this.nextVacationEndDate = nextVacationEndDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContractInfoEntity)) {
            return false;
        }
        ContractInfoEntity other = (ContractInfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ContractInfoEntity[ id=" + id + " ]";
    }
    
}
