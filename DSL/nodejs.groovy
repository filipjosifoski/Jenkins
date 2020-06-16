job('NodeJS example') { //Name for the job we want to create
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node ->//Job will be downloaded from this link
            node / gitConfigName('Filip')
            node / gitConfigEmail('test@mail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')  //Check for update eveery 5 minutes?
    }
    wrappers {
        nodejs('nodejs')  //Name of the nodejs installation
    }
    steps {
        shell("npm install") //The shelll script we need the job to run 
    }
}
