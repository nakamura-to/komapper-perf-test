plugins {
    id("com.google.devtools.ksp")
}

dependencies {
    platform("org.komapper:komapper-platform:1.7.1").let {
        implementation(it)
        ksp(it)
    }
    implementation("org.komapper:komapper-starter-jdbc")
    implementation("org.komapper:komapper-dialect-h2-jdbc")
    ksp("org.komapper:komapper-processor")
}
