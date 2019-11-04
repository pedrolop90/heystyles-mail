pipeline {
    agent any

    stages {
         stage ('install core') {
              steps {
                  sh 'cd mai-api'
                  sh 'mvn install'
             }
         }
        stage ('install api') {
            steps {
                 sh 'cd ..'
                 sh 'mvn install'
            }
        }
    }
}