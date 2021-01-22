repositories {
    jcenter()
}

plugins {
    `kotlin-dsl`
}

sourceSets {
    map { it.java.srcDir("src/${it.name}/kotlin") }
}
