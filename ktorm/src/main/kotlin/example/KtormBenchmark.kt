package example

import org.ktorm.database.Database
import org.ktorm.dsl.insert
import org.ktorm.entity.add
import org.ktorm.entity.sequenceOf
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
class KtormBenchmark {

    lateinit var db: Database

    val Database.authors get() = this.sequenceOf(Authors)

    @Setup
    fun setup() {
        db = Database.connect(Constants.url)
        db.useTransaction {
            db.useConnection { con ->
                con.createStatement().use {
                    it.execute(Constants.sql)
                }
            }
        }
    }

    @Benchmark
    fun insert_sql() {
        db.useTransaction {
            db.insert(Authors) {
                set(it.name, "a")
            }
        }
    }

    @Benchmark
    fun insert_entity() {
        db.useTransaction {
            db.authors.add(
                Author {
                    name = "a"
                },
            )
        }
    }
}
