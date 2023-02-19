package example

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
class ExposedBenchmark {

    lateinit var db: Database

    @Setup
    fun setup() {
        db = Database.connect(Constants.url)
        transaction {
            exec(Constants.sql)
        }
    }

    @Benchmark
    fun insert_sql() {
        transaction {
            Authors.insert {
                it[name] = "a"
            }
        }
    }

    @Benchmark
    fun insert_entity() {
        transaction {
            Author.new {
                name = "a"
            }
        }
    }
}
