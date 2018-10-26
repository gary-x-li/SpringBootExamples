node {
    stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/superm1a3/SpringBootExamples.git'
   }
   stage('Build') {
      sh "./gradlew bootJar"
   }
}
