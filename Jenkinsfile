pipeline{
    agent {
        docker{
            image "maven:3.6.0-jdk-10"
            label "docker"
        }
    }

    stages{
        stage(build){
            steps{
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }

    post{
        always{
            cleanWs()
        }
    }
}