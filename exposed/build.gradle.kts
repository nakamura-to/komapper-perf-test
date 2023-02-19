dependencies {
    val exposedVersion = "0.41.1"
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.exposed", "exposed-core", exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-dao", exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-jdbc", exposedVersion)
    implementation("com.h2database:h2:2.1.214")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.5")
}
