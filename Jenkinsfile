pipeline {
    agent { label 'exp' }
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("Static code analysis") {
            steps {
                sh "./gradlew checkstyleMain"
                 publishHTML (target: [
                       reportDir: 'build/reports/checkstyle/',
                        reportFiles: 'main.html',
                        reportName: "Checkstyle Report"
                     ])

            }
        }
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }

        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: "JaCoCo Report"
                 ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }

        stage("Package") {
            steps {
                sh "./gradlew build"
            }
        }

        stage("Docker build") {
            steps {
                sh "docker build -t computenow/main:calculator ."
            }
        }
    }
    post {
        failure {
          sleep(60)
        }
    }
}