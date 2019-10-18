/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anshulsblog.service.example.datalayer.entity.compositeprimarykey;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AssignmentUserPK implements Serializable {

	private static final long serialVersionUID = -9174202057498766413L;

	@Basic(optional = false)
    @Column(name = "assignmentid")
    private Integer assignmentId;
    
    @Basic(optional = false)
    @Column(name = "studentid")
    private Integer studentId;

	public AssignmentUserPK() {
		super();
	}

	public AssignmentUserPK(Integer assignmentId, Integer studentId) {
		super();
		this.assignmentId = assignmentId;
		this.studentId = studentId;
	}

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignmentId == null) ? 0 : assignmentId.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
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
		AssignmentUserPK other = (AssignmentUserPK) obj;
		if (assignmentId == null) {
			if (other.assignmentId != null)
				return false;
		} else if (!assignmentId.equals(other.assignmentId))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssignmmentUserPK [assignmentId=" + assignmentId + ", studentId=" + studentId + "]";
	}
}
