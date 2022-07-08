package edu.mta.Elearning.object;

import edu.mta.Elearning.entity.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cboxs extends BaseObject{

    private DbCboxs dbCboxs;
    public  void setDbCboxs(DbCboxs dbCboxs) {
        this.dbCboxs= dbCboxs;
    }

    public DbCboxs getDbCboxs() {
        return dbCboxs;
    }

    public Cboxs() {
        this(new DbCboxs());
    }

    public  Cboxs(DbCboxs dbCboxs)
    {
        setDbCboxs(dbCboxs);
    }



    public int getFolderId() {
        return dbCboxs.getFolderId();
    }

    public int getParentId() {
        return dbCboxs.getParentId();
    }

    public String getFolderName() {
        return dbCboxs.getFolderName();
    }

    public UUID getUser_id() {
        return dbCboxs.getUser_id();
    }
    
    

    public Timestamp getCreationTime() {
        return dbCboxs.getCreationTime();
    }

    public void setFolderId(int folderId) {
        dbCboxs.setFolderId(folderId);;
    }

    public void setParentId(int parentId) {
        dbCboxs.setParentId(parentId);

    }

    public void setFolderName(String folderName) {
        dbCboxs.setFolderName(folderName);
    }

    public void setUser_id(UUID user_id) {
        dbCboxs.setUser_id(user_id);
    }

	/*
	 * public void setContents(List<DbContents> contents) {
	 * //dbCboxs.setUser_id(contents); }
	 * 
	 * public List<DbContents> getContents() { return dbCboxs.getc; }
	 */

    public void setCreationTime(Timestamp creationTime) {
        dbCboxs.setCreationTime(creationTime);
    }

    /**
     * @return
     */
    @Override
    public boolean validate() {
        return false;
    }

    /**
     *
     */
    @Override
    public void finishUpdate() {

    }

    /**
     * @return
     */
    @Override
    public BaseEntity getDbEntity() {
        return getDbCboxs();
    }
}
