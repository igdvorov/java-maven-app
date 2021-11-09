#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
	withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
		sh 'docker build -t yukiisoya23/my-repo:jma-2.0 .'
		sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push yukiisoya23/my-repo:jma-2.0'
    }
}