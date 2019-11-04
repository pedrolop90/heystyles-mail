pipeline {
    agent any

    stages {
        stage ('install') {
            steps {
                 sh 'mvn install'
            }
        }
         stage ('deploy') {
            steps {
                sh 'cd mai-api/target'
                sh 'java -jar mai-api-1.0.0-SNAPSHOT.jar'
            }
         }
    }
}