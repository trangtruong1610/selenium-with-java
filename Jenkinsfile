pipeline{
    agent any

    tools{
        maven{
            name "maven"
            type "maven"
        }
    }
    stages{
        stage(build){
            steps{
                sh "mvn --version"
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