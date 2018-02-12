pipeline {
    agent any
    stages {
        stage("Code coverage") {
            steps {
                sh "./gradlew jacooTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html'
                    reportNamge: "JaCoCo Report"
                 ]}
                sh "./gradlew jacocoTestCoverageVerification"
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
    }
}