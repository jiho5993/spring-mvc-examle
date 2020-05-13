## JDBC와 MyBatis
JDBC(Java DataBase Connectivity)는 RDBMS에 접근하여 SQL문을 실행하기 위한 Java 라이브러리를 표준으로 만든것이다.  
대부분 인터페이스로 이루어져 있어 어떤 DB를 사용하더라도 동일한 코드를 사용할 수 있는 장점이 있다.  
그러나 드라이버 로딩, 연결, 쿼리수행을 위한 세그먼트 생성 등 일일히 작업해야하는 단점이 있다.  

MyBatis는 JDBC 코드 및 수동셋팅 과정이 없으며,  
기존 JDBC와 다르게 쿼리문을 프로그램에서 분리하여 XML파일에 작성한다.  
때문에, 이식성이 높고 SQL문은 짧으며, 유지보수성이 높다는 장점이 있다.

## MyBatis의 SqlSession
Mybatis를 사용하기 위한 기본적인 자바 Interface로 SqlSession이 있다.  
이 인터페이스를 이용하여 명령어를 실행하고 맵퍼를 얻으며, 트랜잭션을 관리할 수 있다.  
SqlSession은 SqlSessionFactory 인스턴스를 이용해서 만들며,  
SqlSessionFactory는 XML, 애노테이션 또는 자바 설정에서  
SqlSessionFactory를 생성할 수 있는 SqlSessionBuilder를 통해 만들어진다.

## Connection Pool, DataSource
기존 JDBC 프로그램 구현으로 DBMS와 연동 작업을 할때는 웹 클라이언트로부터 요청이 있을 때마다 DB서버에 연결하기 위해 Connection 객체를 얻어내야 했다.  
Connection 과정은 일정 시간이 필요한 부담과 작업이고 불필요한 연결에 의한 서버 자원의 낭비를 발생시킨다.
때문에 Connection Pool이란 개념이 생겼는데,  
Connection 객체를 웹 애플리케이션이 서비스되기 전에 웹서버에서 미리 생성하여 준비한 다음,  
필요할 때 준비된 Connection을 가져다 사용함으로써 JDBC 프로그래밍의 문제점들을 개선한 기술이다.  
Connection Pool에는 여러개의 Connection 객체가 생성되어 운용되는데, 이를 직접 웹 애플리케이션에서 다루기 힘들기 때문에 DataSource라는 개념을 도입하여 사용한다.
* Connection Pool의 Connection을 관리하기 위한 객체이다.
* JNDI Server를 통해서 이용된다.
* DataSource 객체를 통해서 필요한 Connection을 획득, 반납 등의 작업을 한다.

## MyBatis 장점 간단 요약
* 간결한 코드 처리: JDBC작업을 위한 반복적인 코드를 직접 작성하지 않아도 됨
* SQL문 분리 운영: XML 또는 애너테이션 방식으로 SQL문을 별도로 처리하는 작업 가능
* Spring과 연동으로 자동화된 처리: MyBatis-Spring라이브러리를 이용하여 직접 SQL문 호출없이도 원하는 결과를 얻을 수 있다.
* 동적 SQL을 이용한 제어기능: 제어문이나 반복문 등의 처리 기능을 통해 SQL관련된 Java코드에서 분리 가능

## 설정
### MyBatis 연동을 위한 설정
`pom.xml`에 라이브러리 추가
```xml
<!--spring-jdbc 라이브러리-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-jdbc</artifactId>
  <version>${org.springframework-version}</version>
</dependency>
<!--spring-test 라이브러리-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-test</artifactId>
  <version>${org.springframework-version}</version>
</dependency>
<!--mybatis 라이브러리-->
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis</artifactId>
  <version>3.5.4</version>
</dependency>
<!--mybatis-spring 라이브러리-->
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis-spring</artifactId>
  <version>2.0.4</version>
</dependency>
```
`applicationContext.xml`에 DataSource 설정
```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
    <property name="url" value="jdbc:log4jdbc:mysql://127.0.0.1:3306/스키마 이름?serverTimezone=UTC&amp;verifyServerCertificate=false&amp;useSSL=false"/>
    <property name="username" value="아이디"/>
    <property name="password" value="비밀번호"/>
</bean>
```

### MyBatis 연결 설정
`applicationContext.xml`에 SqlSessionFactory 객체를 설정
```xml
<!--SqlSessionFactory 설정 : dataSource를 참조, mybatis-config.xml 경로설정-->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <property name="configLocation" value="classpath:/mybatis-config.xml"/>
    <property name="mapperLocations" value="classpath:mappers/**/*Mapper.xml"/>
</bean>
```
`mybatis-config.xml`은 MyBatis 설정 파일로 `src/main/resources`디렉토리에 xml파일 생성한 뒤 아래와 같이 작성
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>
```

## Mapper
getter method의 이름과 mapper로 받는 매개변수가 일치해야만 쿼리가 제대로 작동한다.  
ex)
```java
public int getArticleNo();
```
```xml
<select id="read" resultMap="ArticleResultMap">
    select
        article_no,
        title,
        content,
        writer,
        regdate,
        viewcnt
    from
        tbl_article
    where article_no = #{articleNo}
</select>

<!--getArticleNo에서 ArticleNo가 #{articleNo}와 일치해야함-->
<!--만약 getArticleNumber이면 매개변수는 #{articleNumber}-->
```
