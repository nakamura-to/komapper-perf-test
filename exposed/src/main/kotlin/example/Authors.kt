package example

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Authors : IntIdTable("author") {
    val name = varchar("name", length = 50)
}

class Author(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Author>(Authors)
    var name by Authors.name
}
