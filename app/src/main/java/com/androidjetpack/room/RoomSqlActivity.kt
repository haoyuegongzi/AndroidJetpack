package com.androidjetpack.room

import android.os.Bundle
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import kotlinx.android.synthetic.main.activity_room_sql.*

class RoomSqlActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_sql)

        var roleDao = RoleDatabase.getInstance(this, false, 1, 1).roleDao()

        var name = "任缥缈"
        var shihao = "风满楼，卷黄沙，舞剑春秋，名震天下。雨飘渺，倦红尘，还君明珠，秋水浮萍。"
        var wugong = "飘渺剑法：虚无飘渺，无迹可寻，精妙绝伦，变幻莫测。无形无相"

        btnAdd.setOnClickListener {
            var ID = System.currentTimeMillis()
            var role01 = Role(ID, name, shihao, wugong)
            roleDao.addUser(role01)

            ID = System.currentTimeMillis()
            name = "俏如来"
            shihao = "红尘轮回众生顾，因果循环有定数，放下屠刀虽成佛，愿坠三途灭千魔。"
            wugong =
                "圣印六式；诛魔之利：止戈流·「鬼破、星流、星陨、星痕、月痕、日殒、破日、天誓」；止戈流·真阵·「初式·十剑山河荡狼烟、继式·十面江海靖尘嚣、终式·十万沙劫漫云天」"
            var role02 = Role(ID, name, shihao, wugong)
            roleDao.addUser(role02)

            ID = System.currentTimeMillis()
            name = "藏镜人"
            shihao = "踏烽火，折兵锋，正邪无用；斩敌颅，杀魍魉，天地不容"
            wugong = "以纯阳金刚体强行逆练纯阴功法：飞瀑掌；纯阳掌；纯阳行左·飞瀑走右·阴行阳招·阳行阴招·阴阳融合·袭地贯天；啸问岁月·天狼影"
            var role03 = Role(ID, name, shihao, wugong)
            roleDao.addUser(role03)

            ID = System.currentTimeMillis()
            name = "遥星公子别小楼"
            shihao = "沉刀埋霜小楼庭，回首江湖风云轻。君有才能纵捭阖，清溪仰望有遥星"
            wugong =
                "纵横诀·『吴钩霜月明、飒沓如流星、千里不留行、十步杀一人、赵客缦胡缨、银鞍照白马；星月合招：十方萧索无涯·千古夕阳有主·诗仙纵横·刀剑茫茫去不还』、碧海定涛掌"
            var role04 = Role(ID, name, shihao, wugong)
            roleDao.addUser(role04)

            println("TAGTAG：执行了添加操作")
            tvResult.text = "执行了添加操作"
        }

        btnQuery.setOnClickListener {
            var result = ""
            roleDao.getAll().forEach() {
                result = result + "\n" + it.toString()
                println("TAGTAG：执行了查询操作：${it.toString()}")

            }
            tvResult.text = "执行了查询操作：${result}"
        }
        btnInsert.setOnClickListener {
            var ID = System.currentTimeMillis()
            name = "宫本总司"
            shihao = "萧无名、曲无名、声幽幽、声悲鸣，心何闷？情何困？眉深锁、孤独行。"
            wugong = "无常无定。神魔一念：以魔入心，以神出招，心法极意，不在魔心控杀，而在神意止杀，忘情忘仇，亦神亦魔，神魔非我。一剑无极、一剑无尽、一剑无声、一剑无悔"
            var roleInsert = Role(ID, name, shihao, wugong)
            roleDao.insertRole(roleInsert)
            println("TAGTAG：执行了  插入  操作")
            tvResult.text = "TAGTAG：执行了  插入  操作"
        }

        btnQuery.setOnClickListener {
            var result = ""
            name = "任缥缈"
            var role = roleDao.getRoleInfoByName(name);
            result = result + role.toString()
            println("TAGTAG：通过${name}查询到的信息：${role.toString()}")

            wugong = "飘渺剑法：虚无飘渺，无迹可寻，精妙绝伦，变幻莫测。无形无相"
            role = roleDao.getRoleInfoBykONGfU(wugong)
            result = result + role.toString()
            println("TAGTAG：通过${wugong}查询到的信息：${role.toString()}")

            shihao = "萧无名、曲无名、声幽幽、声悲鸣，心何闷？情何困？眉深锁、孤独行。"
            role = roleDao.getRoleInfoByShiHao(shihao)
            result = result + role.toString()
            println("TAGTAG：通过${shihao}查询到的信息：${role.toString()}")
            tvResult.text = "通过${shihao}查询到的信息：" + result

            var nameList = listOf<String>("任缥缈", "俏如来")
            var nameQueryList = roleDao.getRolesByMames(nameList)

            result = result + "\n\n\n"
            for (item in nameQueryList){
                result = result + item.toString()
                println("TAGTAG：通过namelist查询到的结果：${item.toString()}")
            }
            tvResult.text = "通过namelist查询到的结果：" + result
        }

        btnUpdate.setOnClickListener {
            name = "俏如来"
            shihao = "天堂地狱一道门，道门无扉三朵云。云中难觅五形气，气化心逢七彩君。"
            wugong = "圣印六式；诛魔之利：止戈流·「鬼破、星流、星陨、星痕、月痕、日殒、破日、天誓」；止戈流·真阵·「初式·十剑山河荡狼烟、继式·十面江海靖尘嚣、终式·十万沙劫漫云天」"

            val beforeUpdateRole = roleDao.getRoleInfoByName(name);
            var roleUpdate = Role(beforeUpdateRole.roleId, name, shihao, wugong)
            roleDao.updateRoleByRole(roleUpdate)

            roleUpdate = roleDao.getRoleInfoByName(name)
            println("TAGTAG：更新后的结果：$roleUpdate")
            tvResult.text = "更新后的结果：" + roleUpdate.toString()
        }

         btnDelete.setOnClickListener {
             name = "俏如来"
             shihao = "天堂地狱一道门，道门无扉三朵云。云中难觅五形气，气化心逢七彩君。"
             wugong = "圣印六式；诛魔之利：止戈流·「鬼破、星流、星陨、星痕、月痕、日殒、破日、天誓」；止戈流·真阵·「初式·十剑山河荡狼烟、继式·十面江海靖尘嚣、终式·十万沙劫漫云天」"
             val beforeUpdateRole = roleDao.getRoleInfoByName(name);
             val roleUpdate = Role(beforeUpdateRole.roleId, name, shihao, wugong)
             roleDao.deleteRoleByRole(roleUpdate)
            var result = ""
             val list = roleDao.getAll()
             for (item in list){
                 result = result + item.toString()
                 println("TAGTAG：删除指定数据：俏如来后查询到的结果：${item.toString()}")
             }

             tvResult.text = "TAGTAG：删除指定数据：俏如来后查询到的结果：" + result
         }
    }
}