package com.anshulsblog.service.example.datalayer.entity.projection;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.anshulsblog.service.example.datalayer.entity.AssignmentUser;


@Projection(name = "AssignmentUserAndAssignment", types = AssignmentUser.class)
public interface AssignmentUserAndAssignmentProjection {
	
	@Value("#{target.getUserId().getAssignmentId()}")
	Integer getAssignmentId();
	
	@Value("#{target.getUserId().getStudentId()}")
	Integer getStudentId();
	
	String getUsername();
	Date getDueon();
	Date getAvailableon();
	Integer getIndex();
	Integer getShift();
	
	@Value("#{target.getAssignment().getUuid()}")
	String getAssignmentUUID();
	
	@Value("#{target.getAssignment().getClassid()}")
	Integer getClassid();
	
	@Value("#{target.getAssignment().getType()}")	
	String getAssignmentType();
	
	@Value("#{target.getUserId().getAssignmentId() + '_' + target.getUserId().getStudentId()}")
	String getAssignmentUserId();	
	
	/*@Value("#{target.getAssignment().getAssignableList()[0].getItemList().![uuid]}")
	List<String> getItemUUIDList(); 
	
	@Value("#{target.getSession() != null ? target.getSession().getAttemptedQuestions() : null}")	
	Integer getAttemptedQuestions();*/
	
}
