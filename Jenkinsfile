pipeline {
    agent any

    environment {
        // Define environment variables if needed
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub repository
                git 'https://github.com/AkashKur976/Assignment.git'
            }
        }

        stage('Compile') {
            steps {
                // Compile the project using Maven
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run unit tests using Maven
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                // Build the project into a JAR file using Maven
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (optional, can be customized)
                echo 'Deploying the application...'
            }
        }
    }

    post {
        always {
            // Clean up resources or perform any post-build actions
            echo 'Cleaning up after the build...'
        }

        success {
            // Actions to take on successful build
            echo 'Build Successful!'
        }

        failure {
            // Actions to take on failed build
            echo 'Build Failed!'
        }
    }
}
