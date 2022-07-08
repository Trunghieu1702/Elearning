package edu.mta.Elearning.object;

import edu.mta.Elearning.entity.BaseEntity;
import edu.mta.Elearning.entity.DbCboxDepth;

public class CboxDepth extends BaseObject{
    private DbCboxDepth dbCboxDepth;
    public CboxDepth(DbCboxDepth dbCboxDepth) {
        setDbCboxDepth(dbCboxDepth);
    }

    public DbCboxDepth getDbCboxDepth() {
        return dbCboxDepth;
    }

    public CboxDepth() {
        this(new DbCboxDepth());
    }

    public int getFolderId() {
        return dbCboxDepth.getFolderId();
    }

    public void setFolderId(int folderId) {
        dbCboxDepth.setFolderId(folderId);
    }

    public int getParentId() {
        return dbCboxDepth.getParentId();
    }

    public void setParentId(int parentId) {
        dbCboxDepth.setParentId(parentId);
    }

    public int getDepth() {
        return dbCboxDepth.getDepth();
    }

    public void setDepth(int depth) {
        dbCboxDepth.setDepth(depth);
    }

    public void setDbCboxDepth(DbCboxDepth dbCboxDepth) {
        if (dbCboxDepth == null)
            throw new IllegalArgumentException("dbCboxDepth must not be null.");
        this.dbCboxDepth = dbCboxDepth;
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
        return getDbCboxDepth();
    }
}
