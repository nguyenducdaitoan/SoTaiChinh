package vn.softech.hibernate;
// Generated Feb 3, 2012 4:17:59 PM by Hibernate Tools 3.4.0.CR1



/**
 * TblUrlsGroupsId generated by hbm2java
 */
public class TblUrlsGroupsId  implements java.io.Serializable {


     private long urlsId;
     private long groupsId;

    public TblUrlsGroupsId() {
    }

    public TblUrlsGroupsId(long urlsId, long groupsId) {
       this.urlsId = urlsId;
       this.groupsId = groupsId;
    }
   
    public long getUrlsId() {
        return this.urlsId;
    }
    
    public void setUrlsId(long urlsId) {
        this.urlsId = urlsId;
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
		 if ( !(other instanceof TblUrlsGroupsId) ) return false;
		 TblUrlsGroupsId castOther = ( TblUrlsGroupsId ) other; 
         
		 return (this.getUrlsId()==castOther.getUrlsId())
 && (this.getGroupsId()==castOther.getGroupsId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getUrlsId();
         result = 37 * result + (int) this.getGroupsId();
         return result;
   }   


}


