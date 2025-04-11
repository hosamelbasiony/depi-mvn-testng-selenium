pipeline {
    agent any
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "3.9.9"
    }

    stages {
        stage('Build') {
            steps {
                // git 'https://github.com/hosamelbasiony/depi-mvn-testng-selenium.git'
                
                sh '''
                    echo "testing"
                    mvn --version
                    mvn test
                    #mvn clean install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
                    #mvn test -Dmaven.test.failure.ignore=true -B -V
                '''
            }
        }
    }
}
