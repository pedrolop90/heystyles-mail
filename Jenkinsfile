pipeline {
    agent any

    stages {
         stage ('install core') {
              steps {
                  sh 'cd mail-core'
                  sh 'mvn install'
             }
         }
        stage ('install api') {
            steps {
                 sh 'cd ..'
                 sh 'mvn install'
            }
        }
        stage ('install repo home') {
                 steps {
                    sh 'cd /home/ubuntu/heystyles-mail'
                    sh 'git pull origin/develop'
                    sh 'mvn install'
               }
         }
         stage ('deploy') {
            steps {
                sh '/usr/bin/java -jar /home/ubuntu/heystyles-mail/mai-api/target/mai-api-1.0.0-SNAPSHOT.jar'
            }
         }
    }
}