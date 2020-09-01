## HTTP 프로토콜
HTTP(Hypertext Transfer Protocol)에서 프로토콜이란 상호 간에 정의한 규칙을 의미하며
특정 기기 간에 데이터를 주고 받기 위해 정의되었다. 통신 프로토콜을 쉽게 풀어보면
"나는 이렇게 줄테니 넌 이렇게 받고 난 너가 준거 그렇게 받을께" 정도가 된다.

## HTTP 프로토콜 특징
HTTP 프로토콜은 상태가 없는 (stateless) 프로토콜이다.
여기서 상태가 없다는 말은 데이터를 주고 받기 이한 각각의 데이터 요청이 서로 독립적으로 관리가 된다는 말이다.
  
이러한 특징 덕분에 서버는 세션과 같은 별도의 추가 정보를 관리하지 않아도 되고,
다수의 요청 처리 및 부하를 줄일 수 있는 성능 상의 이점이 생긴다.  

HTTP 프로토콜은 일반적으로 TCP/IP 통신 위에서 동작하며 기본 포트는 80번이다.

## HTTP Request & HTTP Response
HTTP 프로토콜로 데이터를 주고 받기 위해서는 요청(Request)을 보내고 응답(Response)을 받아야 한다.  

요청과 응답을 이해하기 위해서는 클라이어언트(Client)와 서버(Server)를 이해해야 한다.  

* `클라이언트(Client)` : 요청을 보내는 쪽을 의미하며 일반적으로 웹 관점에서는 브라우저를 의미  
* `서버(Server)` : 요청을 받는 쪽을 의미하며 일반적으로 데이터를 보내주는 원격지의 컴퓨터를 의미

## URL
URL(Uniform Resource Locators)은 서버에 자원을 요청하기 위해 입력하는 영문 주소이다.
`http://www.domain.com:1234/path/to/resource?a=b&x=y`  
* `http` : protocol  
* `domain` : host  
* `1234` : port  
* `/path/to/resource` : resource path  
* `?a=b&x=y` : query

## HTTP 요청 메서드
HTTP 요청 메서드는 HTTP Verbs라고도 불리우며 아래와 같은 주요 메서드를 가진다.

* `GET` : 존재하는 자원에 대한 **요청**
* `POST` : 새로운 자원을 **생성**
* `PUT` : 존재하는 자원에 대한 **변경**
* `DELETE` : 존재하는 자원에 대한 **삭제**

## HTTP 상태 코드
HTTP 상태 코드(HTTP Status Code)는 서버에서 설정해주는 응답(Response)정보이다.

### 2xx - 성공
200번대의 상태 코드는 대부분 성공을 의미
* `200` : GET요청에 대한 성공 (GET)
* `201` : 클라이언트의 요청을 서버가 정상적으로 처리했고 새로운 리소스가 생김 (POST, PUT)
* `204` : No Content. 성공했으나 응답 본문에 데이터가 없음 (DELETE)
* `205` : Reset Content. 성공했으나 클라이언트의 화면을 새로 고침하도록 권고
* `206` : Partial Content. 성공했으나 일부 범위의 데이터만 반환

### 3xx - 리다이렉션
300번대의 상태 코드는 대부분 클라이언트가 이전 주소로 데이터를 요청하여 서버에서 새 URL로 리다이렉트를 유도하는 경우
* `301` : Moved Permanently, 여청한 자원이 새 URL에 존제
* `303` : See Other, 요청한 자원이 임시 주소에 존재
* `304` : Not Modified, 요청한 자원이 변경되지 않았으므로 클라이언트에서 캐싱된 자원을 사용하도록 권고

### 4xx - 클라이언트 에러
400번대 상태 코드는 대부분 클라이언트의 코드가 잘못된 경우다.
유효하지 않은 자원을 요청했거나 요청이나 권한이 잘못된 경우 발생한다.
* `400` : Bad Request, 잘못된 요청
* `401` : Unauthorized, 권한 없이 요청. Authorization 헤더가 잘못된 경우
* `403` : Forbidden, 서버에서 해당 자원에 대해 접근 금지
* `404` : Not Found, 요청한 자원이 서버에 없다는 의미
* `405` : Method Not Allowed, 허용되지 않은 요청 메서드

### 5xx - 서버 에러
500번대 상태 코드는 서버 쪽에서 오류가 난 경우
* `501` : Not Implemented, 요청한 동작에 대해 서버가 수행할 수 없는 경우
* `503` : Service Unavailable, 서버가 과부하 또는 유지 보수로 내려간 경우

출처: https://joshua1988.github.io/web-development/http-part1/
