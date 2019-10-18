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

import com.anshulsblog.service.example.datalayer.entity.Assignment;


@RepositoryRestResource(path = "assignments")
@Transactional
public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE Assignment a set a.releasedate=CURRENT_TIMESTAMP where a.assignmentId IN :assignmentids")
	public int updateAssignmentReleaseDate(@Param("assignmentids") Set<Integer> assignmentIds);
	
	/*@Transactional( readOnly = true )  
	@Query(nativeQuery = true, value = "SELECT asg.id, asg.label, asg.type, asg.classid, asg.availableon, asg.dueon, asg.showmarks, asg.itemsource, asl.parentobjectid, COUNT(DISTINCT(ast.itemid)) AS 'itemCount', "
			+ " COUNT(CASE WHEN asgusr.availableon > CURRENT_TIMESTAMP() AND asgusr.isdeleted=0 AND asgusr.studentid NOT IN(?2) THEN 'scheduled' END) DIV COUNT(DISTINCT(ast.itemid)) AS 'scheduled',"
			+ " COUNT(CASE WHEN asgusr.availableon < CURRENT_TIMESTAMP() AND ses.id IS NULL AND asgusr.isdeleted=0 AND asgusr.studentid NOT IN(?2) THEN 'notstarted' END)  DIV COUNT(DISTINCT(ast.itemid)) AS 'notstarted', "
			+ " COUNT(CASE WHEN asgusr.dueon > CURRENT_TIMESTAMP() AND ses.completed <> 1 AND asgusr.isdeleted=0 AND asgusr.studentid NOT IN(?2) THEN 'inprogress' END) DIV COUNT(DISTINCT(ast.itemid)) AS 'inprogress', "
			+ " COUNT(CASE WHEN ses.completed = 1 AND ses.marksreleased <> 1 AND asgusr.isdeleted=0 AND asgusr.studentid NOT IN(?2) THEN 'completed' END) DIV COUNT(DISTINCT(ast.itemid)) AS 'completed', "
			+ " COUNT(CASE WHEN ses.marksreleased = 1 AND asgusr.isdeleted=0 AND asgusr.studentid NOT IN(?2) THEN 'released' END) DIV COUNT(DISTINCT(ast.itemid)) AS 'released' "
			+ " FROM lo_assignment asg JOIN lo_assignableassignmentmap asgmp ON asg.id = asgmp.assignmentid AND asg.status = 1 "
			+ " JOIN lo_assignable asl ON asgmp.assignableid = asl.id "
			+ " JOIN lo_assignableitemassignablemap ast ON asl.id=ast.assignableid "
			+ " JOIN lo_assignmentuser asgusr ON asg.id = asgusr.assignmentid"
			+ " LEFT JOIN lo_session ses ON asgusr.assignmentid = ses.assignmentid "
			+ " AND asgusr.studentid = ses.studentid "
			+ " WHERE asg.classid = ?1 GROUP BY asg.id ")
	public List<Object> findAllAssignmentsForTeacherCourseView(@Param("classid") Integer classId, @Param("instructorids") Set<Integer> instructorIds);
	
	@Transactional( readOnly = true )  
	@Query(nativeQuery = true, value = "SELECT asg.id, asg.label, asg.type, asg.classid, asgusr.availableon, asgusr.dueon, asg.showmarks, asg.itemsource, asl.parentobjectid, "
			+ " COUNT(CASE WHEN asgusr.availableon < CURRENT_TIMESTAMP() AND ses.id IS NULL THEN 'notstarted' END) AS 'notstarted', "
			+ " COUNT(CASE WHEN asgusr.dueon > CURRENT_TIMESTAMP() AND ses.completed <> 1 THEN 'inprogress' END) AS 'inprogress',"
			+ " COUNT(CASE WHEN ses.completed = 1 AND ses.marksreleased <> 1 THEN 'completed' END) AS 'completed',"
			+ " COUNT(CASE WHEN ses.marksreleased = 1 THEN 'released' END) AS 'released'"
			+ " FROM lo_assignment asg JOIN lo_assignableassignmentmap asgmp ON asg.id = asgmp.assignmentid AND asg.status = 1 "
			+ " JOIN lo_assignable asl ON asgmp.assignableid = asl.id "
			+ " JOIN lo_assignmentuser asgusr ON asg.id = asgusr.assignmentid "
			+ " LEFT JOIN lo_session ses ON asgusr.assignmentid = ses.assignmentid "
			+ " AND asgusr.studentid = ses.studentid "
			+ " WHERE asg.classid = ?1 AND asgusr.studentid = ?2 AND asgusr.availableon < CURRENT_TIMESTAMP() AND asgusr.isdeleted = 0 GROUP BY asg.id ")
	public List<Object> findAllAssignmentsForStudentCourseView(Integer classId, Integer studentId);
	*/
	@Modifying
	@Transactional
	@Query(value ="UPDATE Assignment a set a.dueon = :dueon where a.assignmentId = :assignmentid")
	public int updateAssignmentDueDate(@Param("assignmentid") Integer assignmentId, @Param("dueon") Date dueOn);

	@Modifying
	@Transactional
	@Query(value ="UPDATE Assignment a set a.status = 0 where a.assignmentId = :assignmentId")
	public int updateAssignmentStatus(@Param("assignmentId") Integer assignmentId);
	
	@Transactional
	@Query(value ="Select a FROM Assignment a where a.assignedWholeClass = 1 AND a.dueon > CURRENT_TIMESTAMP AND a.classid = :classid AND a.status = 1 ")
	public List<Assignment> findAssignmentsByAssignedWholeClassFlagDueDateAndClassId(@Param("classid") Integer classId);

	@Transactional( readOnly = true )  
	@Query(value ="select a FROM Assignment a WHERE a.assignmentId IN :assignmentids")
	public List<Assignment> findAssignmentsByIds(@Param("assignmentids") Set<Integer> assignmentIds);
	

}