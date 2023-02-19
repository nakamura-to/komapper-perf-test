package example

import org.komapper.annotation.KomapperAutoIncrement
import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId

@KomapperEntity
data class Author(
    @KomapperId
    @KomapperAutoIncrement
    val id: Int? = null,
    val name: String,
)
