buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "spotless")
}


/**
 * Return property value or default value
 * TODO: use this function to pass TMDB_API_KEY to buildConfigField in app build.gradle.kts
 */
fun propOrDefault(propertyName:String, defaultValue:Any): Any {
    return project.property(propertyName)?:defaultValue
}