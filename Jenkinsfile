pipeline{
    agent any

    stages{
        stage("Initialize"){
            steps{
                echo 'Inside the Initialize stage'
                echo ' '
            }
         }
        stage("Build Code"){
            steps{
                echo 'Inside Build Stage'
                sh 'mvn clean package -Dskiptests=true -Dmaven.test.skip=treu'
            }
        }
        stage("Dependency check"){
            steps{
                dependencyCheck additionalArguments: '', odcInstallation: 'OwaspDep'
                dependencyCheckPublisher pattern: ''
            }
        }
        stage("Test Stages"){
            parallel{
                stage('Unit Tests'){
                    steps{
                        echo 'Inside unit tests stage'
                        //sh 'mvn clean package'
                    }
                }
                stage('Integration Tests'){
                    steps{
                        echo 'Inside Integration tests stage'
                    }
                }
                stage('Functional UI Tests'){
                    steps{
                        echo 'Inside UI tests'
                    }
                }
            }
        }
        stage("Code Scan"){
            parallel{
                stage('Static Scan'){
                    steps{
                        echo 'Inside Static Scan'
                    }
                }
                stage('SonarQube'){
                    steps{
                        echo 'Inside SonarQube stage'
                    }
                }
                stage('BlackDuck scans'){
                    steps{
                        echo 'Inside blackduck scans'
                    }
                }
            }
        }
        stage("Upload to Artefactory"){
            steps{
                echo 'Inside Artefactory stage'
            }
        }
        stage("Pre-Deploy Tasks"){
            steps{
                echo 'Predeploy tasks'
            }
        }

        stage('performance Tests'){
            steps{
                echo 'Inside perf tests'
            }
        }
        stage("Emails/Notifications"){
            steps{
                echo 'Inside Notifications stage'
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



