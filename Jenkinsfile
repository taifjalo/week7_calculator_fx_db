pipeline {
    agent any

    environment {
        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"

        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'taifjalo1/sum-product_fx'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'latest'
    }

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Check Docker') {
            steps {
                bat 'docker --version'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/taifjalo/week7_calculator_fx_db.git' //CHECK THE GITHUB REPO
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: '5005ab2d-4cd7-489a-8b0b-4edc13dadc81',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat 'docker login -u %DOCKER_USER% -p %DOCKER_PASS%'
                    bat 'docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%'
                    bat 'docker logout'
                }
            }
        }
    }
}
