package com.anshulsblog.service.example.datalayer.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "assignment")
public class Assignment implements Serializable {

	private static final long serialVersionUID = -5477569438886841423L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer assignmentId;
	
	@Column(name = "UUID")
    private String uuid;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "type")
    private String type;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "classid")
    private Integer classid;
    
    @Column(name = "assignedby")
    private Integer assignedby;
    
    @Column(name = "availableon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date availableon;
    
    @Column(name = "dueon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueon;
    
    @Column(name = "releasedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releasedate;
    
    @Column(name = "assignedon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedon;
    
    @Column(name = "teachernotes")
    private String teachernotes;
    
    @Column(name = "questionmaxattempts")
    private Integer questionmaxattempts;
    
    @Column(name = "showmarks")
    private Integer showmarks;
    
    @Column(name = "showanswer")
    private Integer showanswer;
    
    @Column(name = "showsolution")
    private Integer showsolution;
    
    @Column(name = "autosubmitstatus")
    private Integer autosubmitstatus;
    
    @Column(name = "feedbackreleaseon")
    private String feedbackreleaseon;
    
    @Column(name = "itemsource")
    private Integer itemsource;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "assignedwholeclass")
    private Integer assignedWholeClass;
    
	@Version
    @Column(name = "version")
    private Integer version;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment" )
    private List<AssignmentUser> userList = new ArrayList<>(); 
    
    
    public Assignment() {
    }

    public Assignment(Integer assignmentid) {
        this.assignmentId = assignmentid;
    }

    public Assignment(Integer assignmentid, Integer classid) {
        this.assignmentId = assignmentid;
        this.classid = classid;
    }

        
    public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Integer getAssignedby() {
        return assignedby;
    }

    public void setAssignedby(Integer assignedby) {
        this.assignedby = assignedby;
    }

    public Date getAvailableon() {
        return availableon;
    }

    public void setAvailableon(Date availableon) {
        this.availableon = availableon;
    }

    public Date getDueon() {
        return dueon;
    }

    public void setDueon(Date dueon) {
        this.dueon = dueon;
    }

        
    public Date getAssignedon() {
        return assignedon;
    }

    public void setAssignedon(Date assignedon) {
        this.assignedon = assignedon;
    }

    public String getTeachernotes() {
        return teachernotes;
    }

    public void setTeachernotes(String teachernotes) {
        this.teachernotes = teachernotes;
    }

    public Integer getQuestionmaxattempts() {
		return questionmaxattempts;
	}

	public void setQuestionmaxattempts(Integer questionmaxattempts) {
		this.questionmaxattempts = questionmaxattempts;
	}

	public Integer getShowmarks() {
		return showmarks;
	}

	public void setShowmarks(Integer showmarks) {
		this.showmarks = showmarks;
	}

	public Integer getShowanswer() {
		return showanswer;
	}

	public void setShowanswer(Integer showanswer) {
		this.showanswer = showanswer;
	}

	public Integer getShowsolution() {
		return showsolution;
	}

	public void setShowsolution(Integer showsolution) {
		this.showsolution = showsolution;
	}

	public Integer getAutosubmitstatus() {
		return autosubmitstatus;
	}

	public void setAutosubmitstatus(Integer autosubmitstatus) {
		this.autosubmitstatus = autosubmitstatus;
	}

	public String getFeedbackreleaseon() {
		return feedbackreleaseon;
	}

	public void setFeedbackreleaseon(String feedbackreleaseon) {
		this.feedbackreleaseon = feedbackreleaseon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	public List<AssignmentUser> getUserList() {
		return userList;
	}

	public void setUserList(List<AssignmentUser> userList) {
		this.userList = userList;
	}
	
	public Integer getItemsource() {
		return itemsource;
	}

	public void setItemsource(Integer itemsource) {
		this.itemsource = itemsource;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAssignedWholeClass() {
		return assignedWholeClass;
	}

	public void setAssignedWholeClass(Integer assignedWholeClass) {
		this.assignedWholeClass = assignedWholeClass;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentId != null ? assignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((this.assignmentId == null && other.assignmentId != null) || (this.assignmentId != null && !this.assignmentId.equals(other.assignmentId))) {
            return false;
        }
        return true;
    }
    
    
   
}