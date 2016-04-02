package vn.softech.hibernate;
// Generated Feb 17, 2012 3:49:07 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblQuestionAssign generated by hbm2java
 */
public class TblQuestionAssign  implements java.io.Serializable {

     private Integer questionAssignId;
     private TblQuestion tblQuestion;
     private TblUsers assigner;
     private TblUsers assignToUsersId;
     private Date assignDate;

    public TblQuestionAssign() {
    }

    public TblQuestionAssign(TblQuestion tblQuestion, TblUsers assigner, TblUsers assignToUsersId, Date assignDate) {
       this.tblQuestion = tblQuestion;
       this.setAssigner(assigner);
       this.setAssignToUsersId(assignToUsersId);
       this.assignDate = assignDate;
    }
   
    public Integer getQuestionAssignId() {
        return this.questionAssignId;
    }
    
    public void setQuestionAssignId(Integer questionAssignId) {
        this.questionAssignId = questionAssignId;
    }
    public TblQuestion getTblQuestion() {
        return this.tblQuestion;
    }
    
    public void setTblQuestion(TblQuestion tblQuestion) {
        this.tblQuestion = tblQuestion;
    }    
    
    public Date getAssignDate() {
        return this.assignDate;
    }
    
    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

	public TblUsers getAssigner() {
		return assigner;
	}

	public void setAssigner(TblUsers assigner) {
		this.assigner = assigner;
	}

	public TblUsers getAssignToUsersId() {
		return assignToUsersId;
	}

	public void setAssignToUsersId(TblUsers assignToUsersId) {
		this.assignToUsersId = assignToUsersId;
	}




}


