import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.projectFeatures.awsConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.10"

project {

    buildType(Build)

    features {
        awsConnection {
            id = "AmazonWebServicesAws"
            name = "Amazon Web Services (AWS)"
            credentialsType = static {
                accessKeyId = "test"
                secretAccessKey = "credentialsJSON:9018ffd9-9e71-409b-a392-53f729509560"
            }
        }
        awsConnection {
            id = "AmazonWebServicesAws1"
            name = "Amazon Web Services (AWS)"
            credentialsType = static {
                accessKeyId = "test"
                secretAccessKey = "credentialsJSON:9018ffd9-9e71-409b-a392-53f729509560"
            }
        }
    }
}

object Build : BuildType({
    name = "Build"

    artifactRules = "build/libs/ktor-kubernetes-test-app-all.jar => distribution"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            name = "Gradle build"
            tasks = "build"
            buildFile = "build.gradle.kts"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
