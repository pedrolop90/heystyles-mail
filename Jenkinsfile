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
         stage ('deploy') {
            steps {
                sh 'sudo su systemctl restart heystyles_mail'
            }
         }
    }
}