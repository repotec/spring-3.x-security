# spring-security

## custom DAO-authentication-provider


in this implementation we don't need for login endpoint, all endpoints need to be authenticated

curl -i \
-H "Content-Type: application/json, Authorization: Basic YWRtaW46YWRtaW4=" \
-X POST http://localhost:8000/account
