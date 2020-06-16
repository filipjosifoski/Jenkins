job('NodeJS App') {
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {
        }
    }
    triggers {
        scm('H/5 * * * *') //Check for update every 5 minutes
    }
    wrappers {
        nodejs('nodejs') // the namee of nodejs installation 
                         
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('munmo/jenkins-docker-demeo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
