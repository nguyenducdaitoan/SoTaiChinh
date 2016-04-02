package vn.softech.hibernate;
// Generated Feb 17, 2012 3:49:07 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * TblAnswer generated by hbm2java
 */
public class TblAnswer  implements java.io.Serializable {

	private Long answerId;
     private TblQuestion tblQuestion;
     private TblUsers tblUsers;
     private String answer;
     private Date created;
     private Date modified;

    public TblAnswer() {
    }

    public TblAnswer(TblQuestion tblQuestion, TblUsers tblUsers, String answer, Date created, Date modified) {
       this.tblQuestion = tblQuestion;
       this.tblUsers = tblUsers;
       this.answer = answer;
       this.created = created;
       this.modified = modified;
    }
   
    public Long getAnswerId() {
        return this.answerId;
    }
    
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
    public TblQuestion getTblQuestion() {
        return this.tblQuestion;
    }
    
    public void setTblQuestion(TblQuestion tblQuestion) {
        this.tblQuestion = tblQuestion;
    }
    public TblUsers getTblUsers() {
        return this.tblUsers;
    }
    
    public void setTblUsers(TblUsers tblUsers) {
        this.tblUsers = tblUsers;
    }
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getModified() {
        return this.modified;
    }
    
    public void setModified(Date modified) {
        this.modified = modified;
    }

	

}

