node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/apr-utilport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/apr-utilport.git'), string(name: 'PORT_DESCRIPTION', value: 'The Apache Portable Runtime Utility Library provides a predictable and consistent interface to underlying client library interfaces.' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
