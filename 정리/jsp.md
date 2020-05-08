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
        
다른 내용은 추후 추가 예정