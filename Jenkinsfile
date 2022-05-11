pipeline{
    agent any

    stages{
        stage ('Compile Stage') {
            steps {
                withMaven(maven: 'apache-maven-3.8.5') {
                    sh 'mvn clean install'
                }
            }
        }

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