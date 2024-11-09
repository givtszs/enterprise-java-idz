/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author John
 */
@Entity
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String position;
    private String courses;
    private int academicLoad;
    private String researchActivity;
    private String organizationalWork;
    private String partTimeJob;
    private String address;
    private String phoneNumber;
    private String email;
    private String birthday;
    private String sex;
    private String hobby;
    
    @ManyToOne
    @JoinColumn(name = "ACADEMIC_DEGREE_ID", nullable = true)
    private AcademicDegreeEntity academicDegree;
    
    @ManyToOne
    @JoinColumn(name = "ACADEMIC_RANK_ID", nullable = true)
    private AcademicRankEntity academicRank;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CONTRACT_INFO_ID", nullable = true)
    private ContractInfoEntity contractInfo;

    public ContractInfoEntity getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(ContractInfoEntity contractInfo) {
        this.contractInfo = contractInfo;
    }

    public AcademicRankEntity getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(AcademicRankEntity academicRank) {
        this.academicRank = academicRank;
    }

    public AcademicDegreeEntity getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegreeEntity academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getAcademicLoad() {
        return academicLoad;
    }

    public void setAcademicLoad(int academicLoad) {
        this.academicLoad = academicLoad;
    }

    public String getResearchActivity() {
        return researchActivity;
    }

    public void setResearchActivity(String researchActivity) {
        this.researchActivity = researchActivity;
    }

    public String getOrganizationalWork() {
        return organizationalWork;
    }

    public void setOrganizationalWork(String organizationalWork) {
        this.organizationalWork = organizationalWork;
    }

    public String getPartTimeJob() {
        return partTimeJob;
    }

    public void setPartTimeJob(String partTimeJob) {
        this.partTimeJob = partTimeJob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity other = (EmployeeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ejb.EmployeeEntity[ id=" + id + " ]";
    }
    
}
