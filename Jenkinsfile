pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from Git repository
                git 'https://github.com/AkashKur976/Assignment.git'
            }
        }

        stage('Compile') {
            steps {
                // Compile the Java code (assuming 'CalculatorMain.java' is in the 'src' folder)
                sh 'javac CalculatorMain.java'
            }
        }

        stage('Run') {
            steps {
                // Run the CalculatorMain class after compilation
                sh 'java -cp CalculatorMain'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up after the build...'
        }
        success {
            echo 'Build Successful and Program Ran!'
        }
        failure {
            echo 'Build Failed!'
        }
    }
}
