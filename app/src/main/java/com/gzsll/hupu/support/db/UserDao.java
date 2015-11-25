package com.gzsll.hupu.support.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table USER.
 */
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserName = new Property(1, String.class, "userName", false, "USER_NAME");
        public final static Property Uid = new Property(2, String.class, "uid", false, "UID");
        public final static Property Token = new Property(3, String.class, "token", false, "TOKEN");
        public final static Property Icon = new Property(4, String.class, "icon", false, "ICON");
        public final static Property SyncTime = new Property(5, Integer.class, "syncTime", false, "SYNC_TIME");
        public final static Property Sex = new Property(6, Integer.class, "sex", false, "SEX");
        public final static Property Level = new Property(7, Integer.class, "level", false, "LEVEL");
        public final static Property IsLogin = new Property(8, Boolean.class, "isLogin", false, "IS_LOGIN");
    }

    ;


    public UserDao(DaoConfig config) {
        super(config);
    }

    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'USER_NAME' TEXT," + // 1: userName
                "'UID' TEXT," + // 2: uid
                "'TOKEN' TEXT," + // 3: token
                "'ICON' TEXT," + // 4: icon
                "'SYNC_TIME' INTEGER," + // 5: syncTime
                "'SEX' INTEGER," + // 6: sex
                "'LEVEL' INTEGER," + // 7: level
                "'IS_LOGIN' INTEGER);"); // 8: isLogin
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(2, userName);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(3, uid);
        }
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(4, token);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(5, icon);
        }
 
        Integer syncTime = entity.getSyncTime();
        if (syncTime != null) {
            stmt.bindLong(6, syncTime);
        }
 
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(7, sex);
        }
 
        Integer level = entity.getLevel();
        if (level != null) {
            stmt.bindLong(8, level);
        }
 
        Boolean isLogin = entity.getIsLogin();
        if (isLogin != null) {
            stmt.bindLong(9, isLogin ? 1l: 0l);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userName
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // uid
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // token
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // icon
                cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // syncTime
                cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // sex
                cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // level
                cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0 // isLogin
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setToken(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIcon(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSyncTime(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setSex(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setLevel(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setIsLogin(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
