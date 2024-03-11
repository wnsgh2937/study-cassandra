# 카산드라  스터디

## 카산드라 띄우기
```
docker run -p 9042:9042 --rm --name cassandra -d cassandra:4.0.7

docker exec -it cassandra bash -c "cqlsh -u cassandra -p cassandra"
(cqlsh = 카산드라 인터페이스 CQL(Cassandra Query Language) shell)

docker exec -it cassandra bash -c "cqlsh CREATE KEYSPACE spring_cassandra WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};"
안에 들어가서 치던 무튼, 키스페이스를 만든다.
키스페이스는 DB개념임.

CREATE TABLE IF NOT EXISTS mytable (
    id UUID PRIMARY KEY,
    name text,
    age int
);
이런식으로 테이블을 만들수있음. 근데 no sql인데 테이블이라고 하냐?

INSERT INTO mytable (id, name, age) VALUES (uuid(), 'John Doe', 25);
INSERT INTO mytable (id, name, age) VALUES (uuid(), 'Jane Smith', 30);
이런식으로 데이터 넣을 수 있음. NoSql 맞냐?



```

## 카산드라 이론
일단 분산 DB의 CAP 이론에 대해 알아야함.  
C -> Consistency  
데이터가 일관되어야함  
A -> Availability
데이터가 일관되지 않아도 사용자가 데이터를 읽을 수 있어야함  
P -> Partition Tolerance
노드 하나가 뒤져도 시스템은 돌아가야함.  
즉, 복제본 시스템을 운용한다는 뜻  

요 세개중에 두개를 골라야하는데  
CA, CP, AP 로 생각되지만, P는 필수임. 
즉, CA AP 두 시스템으로 주로 분류가 되며  
몽고는 CA  
카산드라는 AP 시스템임.

몽고에서 프라이머리가 죽으면 세컨더리가 프라이머리로 승격되는데 이때 쓰기 불능 상태에 빠지므로, CA 시스템임.  
몽고는 복제본이 프라이머리 -> 세컨더리로 이동하는 시스템임.  

카산드라는 그런거 없음. 모든 노드가 읽기 쓰기를 함. 
데이터 복제는 시계 방향으로 돈다.  
그래서 노드 하나 죽는다고 시스템이 멈추지 않음.

결론 :
몽고는 데이터 일관성이 좋지만, 가용성이 떨어진다. 
카산드라는 가용성이 좋고 데이터 일관성이 떨어진다.

## 이론 고급

## 사용법
```
JPA임 뭐 다를게 없는뎁쇼  

```

## 참고
https://spring.io/guides/gs/accessing-data-cassandra  

