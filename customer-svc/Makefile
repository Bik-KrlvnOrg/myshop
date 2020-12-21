start:
	docker-compose up -d
stop:
	docker-compose down

image:
	docker build -t "customer-svc" .

artifact:
	gradlew clean
	gradlew build

build:
	artifact image


