package example

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Authors : Table<Author>("author") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("NAME").bindTo { it.name }
}

interface Author : Entity<Author> {
    companion object : Entity.Factory<Author>()
    var id: Int?
    var name: String
}
