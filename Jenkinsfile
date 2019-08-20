pipeline{
    agent any

    stages{
        stage("Initialize"){
            steps{
                echo 'Inside the Initialize stage'
            }
         }
        stage("Build Code"){
            steps{
                echo 'Inside Build Stage'
                sh 'mvn clean package -Dskiptests=true -Dmaven.test.skip=true'
            }
        }
        stage("Dependency check"){
            steps{
                dependencyCheck additionalArguments: '', odcInstallation: 'OwaspDep'
                dependencyCheckPublisher pattern: ''
            }
        }
        
    }
     post{
        always{
            archive "target/**/*"
            junit 'target/surefire-reports/*.xml'
        }
    }
}



