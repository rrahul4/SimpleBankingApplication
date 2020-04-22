node {
  def commit_id
  def mvnHome
  stage('preparation')
  {
    checkout scm
    sh "git rev-parse --short HEAD > .git/commit-id"
    commit_id=readFile('.git/commit-id').trim()
    mvnHome = '/opt/apache-maven-3.5.2'
  }

  stage('Build')
  {
  if(isUnix())
  {
      sh "'${mvnHome}/bin/mvn' Batch1/Capstone/SimpleBankingApplication/pom.xml clean package"
  }
  else
  {
      bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
  }
  }
  
  stage('Results')
  {
    junit '**/target/surefire-reports/TEST-*.xml'
  }
 
  stage('docker build/push')
  {
    docker.withRegistry('https://index.docker.io/', 'docker_credentials')
    {
      def app = docker.build("987325/capstone:${commit_id}", '.').push()
    }
  }
}
