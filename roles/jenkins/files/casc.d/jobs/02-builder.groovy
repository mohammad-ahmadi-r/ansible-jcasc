pipelineJob('mamad/pipeline') {
  triggers {
    authenticationToken('${AUTH_TOKEN}')
  }
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/${GITHUB_USER}/fastapi-jenkins.git')
            credentials('${GITHUB_CREDS}')
          }
          branches('*/main')
        }
      }
      scriptPath('Jenkinsfile')
    }
  }
}