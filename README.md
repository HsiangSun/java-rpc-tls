# java rpc call with TLS demo

## Generate class from proto file

```shell
mvn protobuf:compile
mvn protobuf:compile-custom
```

## Run project
```shell
mvn spring-boot:run
```

## Test 
```shell
curl localhost:8080/hello
```
