package example

import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.jdbc.JdbcDatabase
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
class KomapperBenchmark {

    lateinit var db: JdbcDatabase

    @Setup
    fun setup() {
        db = JdbcDatabase(Constants.url)
        db.runQuery {
            QueryDsl.executeScript(Constants.sql)
        }
    }

    @Benchmark
    fun insert_sql() {
        db.withTransaction {
            val query = QueryDsl.insert(Meta.author).values { 
                Meta.author.name eq "a"
            }
            db.runQuery(query)
        }
    }

    @Benchmark
    fun insert_entity() {
        db.withTransaction {
            val query = QueryDsl.insert(Meta.author).single(Author(name = "a"))
            db.runQuery(query)
        }
    }

}
