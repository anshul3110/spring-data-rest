/**
 * 
 */
package com.anshulsblog.service.example.datalayer.entity.compositeprimarykey;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.anshulsblog.service.example.datalayer.entity.AssignmentUser;


@Component
public class AssignmentUserPKConvertor implements BackendIdConverter{
	
	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {

		if (id != null) {
			// Make sure you validate the input

			String[] parts = id.split("_");

			try {
				Integer activityId = Integer.parseInt(parts[0]);

				Integer sessionId = Integer.parseInt(parts[1]);

				return new AssignmentUserPK(activityId, sessionId);
			} catch (NumberFormatException nfe) {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String toRequestId(Serializable source, Class<?> entityType) {
		AssignmentUserPK id = (AssignmentUserPK) source;
		return String.format("%s_%s", id.getAssignmentId(), id.getStudentId());
	}

	@Override
	public boolean supports(Class<?> type) {
		return AssignmentUser.class.equals(type);
	}

}
