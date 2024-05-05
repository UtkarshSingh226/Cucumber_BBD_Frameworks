node {
    // Define stages
    stage('Build') {
        steps {
            // Build the application
            sh 'mvn clean install'
        }
    }
    
    stage('Test') {
        steps {
            // Run tests
            sh 'mvn test'
        }
        post {
            // Handle test failure
            failure {
                echo 'Tests failed! Failing the build.'
                currentBuild.result = 'FAILED'
            }
        }
    }
    
    stage('Deploy') {
        steps {
            // Deploy the application 
            sh 'scp target/my-app.war IN-B10D5S3@nagarro\utkarshsingh01:/var/www/html'
        }
    }
    
    stage('Cleanup') {
        steps {
            // Clean up temporary files or resources
            sh 'rm -rf target'
        }
    }
}
