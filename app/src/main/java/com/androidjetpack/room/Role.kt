package com.androidjetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 作者：Nixon
 * date：2020/7/5.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
@Entity(tableName = "JinGuangBuDaiXi")
data class Role(
    /**
     * roleId字段
     * 必须
     * 指定，系统会自动生产这个字段的值。请注意上面的<!-----“必须”----->二字
     * */
    @PrimaryKey(autoGenerate = true) var roleId: Long,
    @ColumnInfo(name = "userName") var name: String,
    @ColumnInfo(name = "SHIHAO", defaultValue = "jinguangbudaixi") var shihao: String,
    @ColumnInfo(name = "kongfu") var wugong: String
) {

//实际使用中，上面的方法里面，roleId字段必须指定，添加了Ignore的字段也必须指定，但是按理说这两个都不应该必须指定的。
//roleId是id，每次添加的时候自增1，不指定的话，按其默认的规则来。但实际使用的时候，必须指定ID。
//Ignore：既然都说可以忽略了，那么我没有指定你系统忽略就是了，为什么还必须要指定？
}