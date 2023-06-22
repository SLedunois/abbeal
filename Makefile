start:
	mvnw compile quarkus:dev

build:
	./mvnw package -Pnative -D"quarkus.native.container-build=true" -Dmaven.test.skip