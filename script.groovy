def buildJar() {
	echo "building the application..."
	sh 'mvn package'
}

def buildImage() {
	echo "building the docker image..."
			withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
				sh 'docker built -t yukiisoya23/my-repo:jma-2.0 .'
				sh "echo $PASS | docker login -u $USER --password-stdin"
				sh 'docker push yukiisoya23/my-repo:jma-2.0'
}

def deployApp() {
	echo "deploying the application..."
}

return this
