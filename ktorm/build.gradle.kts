dependencies {
    val ktormVersion = "3.6.0"
    implementation(kotlin("reflect"))
    implementation("org.ktorm", "ktorm-core", ktormVersion)
    implementation("com.h2database:h2:2.1.214")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.5")
}
