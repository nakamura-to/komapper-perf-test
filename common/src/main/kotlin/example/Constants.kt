package example

object Constants {
    const val url = "jdbc:h2:mem:benchmark;DB_CLOSE_DELAY=-1"
    const val sql = "CREATE TABLE IF NOT EXISTS AUTHOR (ID INT AUTO_INCREMENT PRIMARY KEY, \"NAME\" VARCHAR(50) NOT NULL)"
}
