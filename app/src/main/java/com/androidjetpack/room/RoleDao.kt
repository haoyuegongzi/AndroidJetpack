package com.androidjetpack.room

import androidx.room.*

/**
 * 作者：Nixon
 * date：2020/7/5.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
@Dao
interface RoleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(mRole:Role)

    //Insert 可以单独插入，也可以批量插入
    @Insert
    fun insertRole(mRole:Role)

    @Insert
    fun insertRoles(mRole:List<Role>)

    //Query的值即使要执行的sql语句
    @Query("SELECT * FROM JinGuangBuDaiXi")
    fun getAll():List<Role>

    @Query("SELECT * FROM JinGuangBuDaiXi WHERE userName in (:names)")
    fun getRolesByMames(names:List<String>):List<Role>

    //注意点：1、在Room使用中，模糊匹配的格式为" like '%' || :userName || '%' ",即在要匹配的参数值前后要加上 “||”，并且“%”要区分出来
    //       2、下面查询用到的变量的名字要跟实体类（比如本demo中的Role.kt）中的变量要保持一致，否则查询失败
    //       3、WHERE后面的变量(比如本例中的“userName”)要用实体类（比如本demo中的Role.kt）中注解后面的字段，否则查询失败：
    //          @ColumnInfo(name = "userName") var name: String
    //          @ColumnInfo(name = "SHIHAO", defaultValue = "jinguangbudaixi") var shihao: String
    //          @ColumnInfo(name = "kongfu") var wugong: String
    //              userName字段对应的是注解@ColumnInfo(name = "userName")中后面的值value："userName"
    //              kongfu字段对应的是注解@ColumnInfo(name = "kongfu")中后面的值value："kongfu"
    //              SHIHAO字段对应的是注解@ColumnInfo(name = "SHIHAO", defaultValue = "jinguangbudaixi")中后面的值value："SHIHAO"
    /**
     * 而下面位于WHERE后面的两个“like”之间的字段，则是我们传进来的参数变量：
     *          字段“name”对应的是getRoleInfoByName()方法的入参：name:String
     *          字段“wugong”对应的是getRoleInfoBykONGfU()方法的入参：wugong:String
     *          字段“SHIHAO”对应的是getRoleInfoByShiHao()方法的入参：shihao:String
     * */
    //@ColumnInfo(name = "userName") var name: String,
    @Query("SELECT * FROM JinGuangBuDaiXi WHERE userName like '%'|| :name ||'%' LIMIT 1")
    fun getRoleInfoByName(name:String):Role

    @Query("SELECT * FROM JinGuangBuDaiXi WHERE kongfu like '%'|| :wugong ||'%' LIMIT 1")
    fun getRoleInfoBykONGfU(wugong:String):Role

    @Query("SELECT * FROM JinGuangBuDaiXi WHERE SHIHAO like '%'|| :shihao ||'%' LIMIT 1")
    fun getRoleInfoByShiHao(shihao:String):Role

    @Update
    fun updateRoleByRole(user: Role)

    @Delete
    fun deleteRoleByRole(mRole: Role)
}