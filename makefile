# test execution variable
TEST_ENV=local
TEST_BROWSER=chrome

.PHONY:test
test:
	docker-compose up --detach && \
       mvn clean test -Denvironment=${TEST_ENV} -Dbrowser=${TEST_BROWSER} && \
    	docker-compose down
	else

	mvn clean test Denvironment=${TEST_ENV} -Dbrowser=${TEST_BROWSER}
	 endif