package 开房数据库

import java.io.File

data class Person(
        val name: String,
        val idNum: String,
        val province: String,
        val sex: String,
        val hotel: String,
        val startTime: Long,
        val endTime: Long
) {}

private val list = mutableListOf<Person>()
/**
 * 获取数据
 */
fun getPersonRepository():List<Person> {
    if(list.size != 0) return list

    File("repo.data").readLines().forEach {
        val split = it.split("\t")
        val name = split[0]
        val idNum = split[1]
        val province = split[2]
        val sex = split[3]
        val hotel = split[4]
        val startTime = split[5]
        val endTime = split[6]
        list.add(Person(name, idNum, province, sex, hotel, startTime.toLong(), endTime.toLong()))
    }
    return list
}