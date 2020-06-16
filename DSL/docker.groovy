job('NodeJS Docker') { 
scm {
git('git://github.com/wardviaene/docker-demo.git') {  node -> 
            node / gitConfigName('Filip')
            node / gitConfigEmail('test@teest.com')

   }
}
triggers { 
scm('H/5****') //Check for update every 5minutes
  }
wrappers { 
nodejs('nodejs') 
 }
steps {
        dockerBuildAndPublish {
            repositoryName('munmo/jenkins-dockere-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
