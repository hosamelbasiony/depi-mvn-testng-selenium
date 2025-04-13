pipeline {
    agent any
    
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'markhobson/maven-chrome:jdk-17'
                }
            }
            steps {                
                sh '''
                    mvn clean test
                '''
            }
        }
    }
}
