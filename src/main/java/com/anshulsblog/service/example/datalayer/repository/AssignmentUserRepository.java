package com.anshulsblog.service.example.datalayer.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.anshulsblog.service.example.datalayer.entity.AssignmentUser;
import com.anshulsblog.service.example.datalayer.entity.compositeprimarykey.AssignmentUserPK;


@RepositoryRestResource(path="assignmentusers")
@Transactional
public interface AssignmentUserRepository extends CrudRepository<AssignmentUser, AssignmentUserPK>{
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE AssignmentUser au set au.dueon = :dueon where au.userId.studentId IN :studentids AND au.userId.assignmentId = :assignmentid")
	public int updateUsersDueOnDateForAnAssignment(@Param("assignmentid") Integer assignmentId, @Param("studentids") Set<Integer> studentIds, @Param("dueon") Date dueOn);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE AssignmentUser au set au.dueon = :dueon where au.userId.studentId = :studentid AND au.userId.assignmentId = :assignmentid")
	public int updateDueDateForAnAssignment(@Param("assignmentid") Integer assignmentId, @Param("studentid") Integer studentId, @Param("dueon") Date dueOn);

	
	@Modifying
	@Transactional
	@Query(value ="UPDATE AssignmentUser au set au.isdeleted = 1 where au.userId.assignmentId = :assignmentId AND au.userId.studentId = :studentId")
	public void deleteStudentFromAssignment(@Param("assignmentId") Integer assignmentId, @Param("studentId") Integer studentId);
		
	@Modifying
	@Transactional
	@Query(value ="UPDATE AssignmentUser au set au.isdeleted = 1  where au.userId.assignmentId = :assignmentId AND au.userId.studentId IN :userIdListOfAssignmentUsers")
	public int deleteAssignment(@Param("assignmentId") Integer assignmentId, @Param("userIdListOfAssignmentUsers") List<Integer> userIdListOfAssignmentUsers);

    @Modifying
    @Transactional
    @Query(value = "UPDATE AssignmentUser au set au.dueon = :dueon, au.availableon = :availableon, au.index = :index, au.shift = :shift, au.isdeleted = 0" +
            " where au.userId = :userId")
    public int updateAssignmentUser(@Param("dueon") Date dueon, @Param("availableon") Date availableon, @Param("index") Integer index,
                                    @Param("shift") Integer shift, @Param("userId") AssignmentUserPK userId);

}
