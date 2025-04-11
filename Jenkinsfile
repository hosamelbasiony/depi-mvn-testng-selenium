pipeline {
    agent any
    
    stages {
        stage('Build') {
            agent {
                docker {
                    // image 'maven:latest'
                    image 'markhobson/maven-chrome:latest'
                    reuseNode true
                }
            }
            steps {                
                sh '''
                    mvn --version
                    java -version
                    mvn clean test
                    # mvn clean install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
                    # mvn test -Dmaven.test.failure.ignore=true -B -V
                '''
            }
        }
    }
}
