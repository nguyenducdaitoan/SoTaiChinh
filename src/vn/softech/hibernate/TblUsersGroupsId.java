package vn.softech.hibernate;
// Generated Feb 3, 2012 4:17:59 PM by Hibernate Tools 3.4.0.CR1



/**
 * TblUsersGroupsId generated by hbm2java
 */
public class TblUsersGroupsId  implements java.io.Serializable {


     private long usersId;
     private long groupsId;

    public TblUsersGroupsId() {
    }

    public TblUsersGroupsId(long usersId, long groupsId) {
       this.usersId = usersId;
       this.groupsId = groupsId;
    }
   
    public long getUsersId() {
        return this.usersId;
    }
    
    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }
    public long getGroupsId() {
        return this.groupsId;
    }
    
    public void setGroupsId(long groupsId) {
        this.groupsId = groupsId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblUsersGroupsId) ) return false;
		 TblUsersGroupsId castOther = ( TblUsersGroupsId ) other; 
         
		 return (this.getUsersId()==castOther.getUsersId())
 && (this.getGroupsId()==castOther.getGroupsId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getUsersId();
         result = 37 * result + (int) this.getGroupsId();
         return result;
   }   


}


