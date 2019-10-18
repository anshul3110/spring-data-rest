/**
 * 
 */
package com.anshulsblog.service.example.datalayer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.Where;

import com.anshulsblog.service.example.datalayer.entity.compositeprimarykey.AssignmentUserPK;


@Entity
@Table(name = "assignmentuser")
@Where(clause = "isdeleted = false")
public class AssignmentUser implements Serializable{

	private static final long serialVersionUID = 3147523490975062914L;

	@EmbeddedId
    @Basic(optional = false)
    AssignmentUserPK userId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "dueon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueon;
	
	@Column(name = "availableon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date availableon;
	
	@Column(name = "startindex")
    private Integer index;
	
	@Column(name = "shift")
    private Integer shift;
	
	@Column(name = "isdeleted")
	private boolean isdeleted;

    @ManyToOne
    @JoinColumn( name = "assignmentid", referencedColumnName = "id", insertable = false, updatable = false )
	private Assignment assignment;
 
	public AssignmentUserPK getUserId() {
		return userId;
	}

	public void setUserId(AssignmentUserPK userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDueon() {
		return dueon;
	}

	public void setDueon(Date dueon) {
		this.dueon = dueon;
	}

	public Date getAvailableon() {
		return availableon;
	}

	public void setAvailableon(Date availableon) {
		this.availableon = availableon;
	}
	
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}
	
	public boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentUser other = (AssignmentUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssignmentUser [userId=" + userId + ", username=" + username + ", dueon=" + dueon + ", availableon="
				+ availableon + ", index=" + index + ", shift=" + shift + ", assignment=" + assignment + ", isdeleted="
                +isdeleted + "]";
	}
	
}
