<h1>ReadMe</h1>

<h3> <a href="https://devops.datenkollektiv.de/banner.txt/index.html">Banner</a></h3>

<h2>1. Create Customer Service</h2>
<h3><a href="https://www.youtube.com/watch?v=p485kUNpPvE&list=PLwvrYc43l1Mwqpf9i-1B1gXfMeHOm6DeY"> Link to Tutorial</a></h3>
<li>Spring MVC Patten </li><br>
<li>Model - "Customer" - @Entity </li>
<li>JPA Rep - "CustomerRepository" - Extends from "JpaRepository" </li>
<br>
<li>Controller - "CustomerService" is injected </li>
<br>
<li>CustomerService - A Spring Bean: copy "CustomerRegistrationRequest" to "CustomerRepository" </li>
<li>"CustomerRepository" is injected via constructor</li>
<br>
<li>Postgres provision via Docker Compose</li>
<br>

```
docker-compose up -d #provision the db
docker exec -it postgres bash #bash to the container - "postgres"
psql -U mg -d customer #psql to the db - "customer" with the username - "mg"
```

<h2>2. Create Fraud Service</h2>
<h3><a href="https://www.youtube.com/watch?v=QWOgkI4DuE8&t=552s"> Link to Tutorial</a></h3>
<li>Spring MVC Patten </li><br>
<li>Model - "FraudCheckHistory" - @Entity </li>
<li>JPA Rep - "FraudCheckHistoryRepository" - Extends from "JpaRepository" </li>
<br>
<li>Controller - "FraudCheckService" is injected </li>
<br>
<li>FraudCheckService - A Spring Bean @Service: "FraudCheckHistory" is built and saved to "FraudCheckHistoryRepository" </li>
<li>"FraudCheckHistoryRepository" is injected via constructor</li>
<br>
<li>Postgres provision via Docker Compose</li>
<br>

<h2>3. Use RestTemplate</h2>
<h3><a href="https://www.youtube.com/watch?v=l2LY5KqY8Mg"> Link to Tutorial</a></h3>
<li>CustomerConfig </li>
<li>"RestTemplate" @Bean is created</li>
<li>"RestTemplate" Bena is jected to "CustomerService" via Constructor</li><br>

```
 FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
```
<h2>4. Service Discovery</h2>
<h3><a href="https://youtu.be/-gLLeoS1m6s"> Link to Tutorial</a></h3>
<li>Eureka Server</li>
<li>"RestTemplate" @Bean is created</li>
<li>"RestTemplate" Bena is jected to "CustomerService" via Constructor</li><br>
