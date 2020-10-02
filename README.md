# cu-bx-homework-md

To run web suit use:
`gradle web` - User creation test should fail

To run api:
`gradle api`

check report:
`allure serve build/allure-results/`

To run in container:

pull selenoid chrome image: `docker pull selenoid/chrome:85.0`

build an image `docker-compose build`

run the `web` suit `docker-compose up`

reports could be checked in the way described before 