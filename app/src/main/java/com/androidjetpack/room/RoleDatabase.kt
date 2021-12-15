package com.androidjetpack.room

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * 作者：Nixon
 * date：2020/7/5.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
@Database(version = 1, entities = [Role::class])
abstract class RoleDatabase : RoomDatabase() {
    abstract fun roleDao():RoleDao

    companion object {
        private var instance: RoleDatabase? = null

        /**
         *startVersion：表示的是升级开始的版本，
         * endVersion：表示要升级到的目标版本，endVersion>startVersion
         */
        fun getInstance(context: Context, isUpdateVersion:Boolean, startVersion:Int, endVersion:Int): RoleDatabase {
            if (instance == null) {
                if (isUpdateVersion){
                    instance = Room.databaseBuilder(
                    //"Role.db" ：数据库名称
                    context.applicationContext,RoleDatabase::class.java,"Role.db" ).allowMainThreadQueries().build()
                }else{
                    /**
                     * startVersion表示的是升级开始的版本，
                     * endVersion表示要升级到的目标版本，endVersion>startVersion。
                     * 同时需要将@Database注解中的version的值修改为和endVersion相同。
                     * 数据库的升级或者降级使用addMigrations方法进行操作
                     */
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoleDatabase::class.java,
                        "Role.db"
                    ).addMigrations(object : Migration(startVersion,endVersion){
                        override fun migrate(database: SupportSQLiteDatabase) {
                            database.execSQL("ALTER TABLE user ADD age INTEGER Default 0 not null ")
                        }
                    }).allowMainThreadQueries().build()
                }
            }
            return instance as RoleDatabase
        }
    }
}