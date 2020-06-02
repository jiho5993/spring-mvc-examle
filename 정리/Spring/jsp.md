## jsp(Java Server Pages)란
Java 언어를 기반으로 한 Server Side 스크립트 언어

## jsp 문법
1. `<%@ %>`
    * `<%@ page %>`
        * JSP 페이지에 대한 정보를 page 디렉티브(Directive)의 속성들을 사용해서 정의한다.
        * `<%@ page contentType="text/html;charset=UTF-8" language="java" %>`
            * `contentType="text/html;charset=UTF-8"` :JSP 페이지가 생성할 문서의 타입을 지정하는 속성 
            * `language="java"` : JSP 페이지의 스크립트 요소에서 사용할 언어를 지정하는 속성
    * `<%@ include %>`
        * include directive (지시어)
            * 페이지가 단순히 텍스트 위주로 구성되어 있을때 사용하기 좋다.  
            (페이지 헤더 또는 메타태그 등등)
            * `<%@ include file="file.jsp"%>` : 가져올 파일의 경로를 넣어 다른 파일을 가져와 현재 파일에 뿌려준다.
        * include action (액션)
            * 모듈화 되어있는 페이지들을 합쳐서 보여줘야 할 때 사용하기 좋다.  
            (온라인 마켓같은 곳의 카테고리만 분류하고 레이아웃이 같은 상품 정보만 보여주는 곳 등등)
            * `<jsp:include page="file.jsp" />`
2. `<c:forEach>...</c:forEach>`
    * 만약 items가 어떤 객체라면 객체변수를 참조할 수 있다.
      ```jsp
      <c:forEach var="변수이름" items="반복할 객체명" 
      begin="시작값" end="마지막값" step="증가값" varStatus="반복상태 변수명">
      ...
      </c:forEach>
      ```
3. `<fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a hh:mm"/>`
    * value : 날짜
    * pattern
        * y : 년
        * M : 월
        * d : 일
        * a : am/pm
        * h(12), H(24) : 시
        * m : 분
        * s : 초
4. `<c:set/>`        
    * `<c:set var="변수명" value="값" scope="영역"/>`
        * var속성에는 만들 변수명을 입력하고 value속성에는 변수에 들어갈 값을 입력한다.
        * scope속성에는 해당 변수가 저장될 영역으로, page, request, session, application 중 하나를 입력한다.
        * 입력하지 않으면 기본값인 page로 지정한다.
        * `<c:set var="name" value="1"/>` : name = 1
    * `<c:set target="대상" property="속성명" value="값"/>`
        * target, property, value 속성을 이용해 자바 빈 클래스와 Map 객체를 대상으로 하여 속성과 값을 설정하는 방법
        * 이 경우에 대상으로 정한 객체에는 속성 값을 얻을 수 있는 setter 메서드가 필요하다.
        * 예시
          ``` java
          public class Number {
          	
              private String value;
              
              public void setValue(value) {
              	this.value = value;
              }
              
              public String getValue() {
              	return value;
              }
          }
          ```
          ```jsp
          <% Number number = new Number(); %>
          
          <c:set target="${number}" property="value" value="10"/>
          <p>${number.value}</p> // 10
          
          // number 객체가 생성이 되었고 target속성에 표현 언어 형식으로 객체를 지정해준다.
          // 그다음 변경할 객체의 속성명과 값을 입력하고 있다.
          ```
다른 내용은 추후 추가 예정