package com.gzsll.hupu.support.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * Master of DAO (schema version 45): knows all DAOs.
 */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 45;

    /**
     * Creates underlying database table using DAOs.
     */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        BoardDao.createTable(db, ifNotExists);
        UserDao.createTable(db, ifNotExists);
        DBGroupThreadDao.createTable(db, ifNotExists);
        DBCoverDao.createTable(db, ifNotExists);
        DBUserInfoDao.createTable(db, ifNotExists);
        DBThreadInfoDao.createTable(db, ifNotExists);
        DBGroupsDao.createTable(db, ifNotExists);
        DBThreadReplyItemDao.createTable(db, ifNotExists);
        DBMiniReplyListItemDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        BoardDao.dropTable(db, ifExists);
        UserDao.dropTable(db, ifExists);
        DBGroupThreadDao.dropTable(db, ifExists);
        DBCoverDao.dropTable(db, ifExists);
        DBUserInfoDao.dropTable(db, ifExists);
        DBThreadInfoDao.dropTable(db, ifExists);
        DBGroupsDao.dropTable(db, ifExists);
        DBThreadReplyItemDao.dropTable(db, ifExists);
        DBMiniReplyListItemDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(BoardDao.class);
        registerDaoClass(UserDao.class);
        registerDaoClass(DBGroupThreadDao.class);
        registerDaoClass(DBCoverDao.class);
        registerDaoClass(DBUserInfoDao.class);
        registerDaoClass(DBThreadInfoDao.class);
        registerDaoClass(DBGroupsDao.class);
        registerDaoClass(DBThreadReplyItemDao.class);
        registerDaoClass(DBMiniReplyListItemDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
