pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Checkout the source code from your Git repository
                git 'https://github.com/UtkarshSingh226/Cucumber_BBD_Frameworks.git'
                
                // Build the Maven project
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Run Maven tests
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy the application (example: copying files to a remote server)
                // Replace 'user', 'example.com', and '/path/to/deployment' with your server details
                sh 'scp target/my-app.war user@example.com:/path/to/deployment'
            }
        }
        
        stage('Clean Up') {
            steps {
                // Clean up any temporary files or resources
                sh 'mvn clean'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded! Application deployed successfully.'
        }
        failure {
            echo 'Pipeline failed! Deployment unsuccessful.'
        }
    }
}
