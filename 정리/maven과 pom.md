## Maven
maven은 자바 프로젝트의 빌드를 자동화 해주는 빌드 툴이다.  
즉, 자바 소스를 compile하고 package해서 deploy하는 일을 자동화 해주는 것이다.

maven이 참조하는 설정 파일은 두 가지가 있는데 settings.xml과 pom.xml이 있다.  
pom(Project Object Model)은 프로젝트 내 빌드 옵션을 설정하는 부분이다.

## pom.xml
```xml
<project>
    <modelVersion>...</modelVersion>    <!-- maven의 pom모델 버전 -->
    <groupId>...</groupId>              <!-- 프로젝트의 그룹명, url의 역순 -->
    <artifactId>...</artifactId>        <!-- 프로젝트에서 생성되는 기본 artifact의 고유 이름 -->
    <version>...</version>              <!-- 애플리케이션의 버전, SNAPSHOT이 붙으면 개발 단계라는 의미 -->
    <packaging>...</packaging>          <!-- jar, war, ear, pom 등 패키지 유형을 나타냄 -->
    
    <name>...</name>                    <!-- 프로젝트 명 -->
    <description>...</description>      <!-- 프로젝트 설명 -->
    <url>...</url>                      <!-- 프로젝트를 찾을 수 있는 URL -->

    <properties>
        <!--
        1. pom.xml에서 중복해서 사용되는 설정(상수) 값들을 지정해놓는 부분
        2. 다른 위치에서 ${...}로 표기해서 사용할 수 있음
           java.version에 1.8을 적용하고 다른 위치에서 ${java.version}이라고 쓰면 "1.8"이라고 쓴 것과 같음
        -->
    </properties>

    <dependencies>
        <!--
        1. 의존성 라이브러리 정보가 담겨있음
        2. 최소한 groupId, artifactId, version 정보가 필요
        3. A라는 라이브러리를 사용하는데 B,C,D가 의존성을 가진다면
           A를 dependency에 추가하면 자동으로 필요한 B,C,D도 가져오는 기능이 있음
        4. dependency에 <scope>의 경우 compile, runtime, provided, test등이 올 수 있는데
           해당 라이브러리가 언제 필요한지, 언제 제외되는지를 나타내는 것
        -->
    </dependencies>

    <build>                             <!-- maven의 핵심인 빌드와 관련된 정보를 설정할 수 있는 곳, life cycle이 뭔지 알 필요가 있음 -->
        <finalName>...</finalName>      
        <resources>
            <!--
            리소스(각종 설정 파일)의 위치를 지정할 수 있음
            없으면 기본으로 "src/main/resources"
            -->
        </resources>
        <testResources>
            <!--
            테스트 리소스의 위치를 지정할 수 있음
            없으면 기본으로 "src/test/resources"
            -->
        </testResources>
        <Repositories>
            <!--
            빌드할 때 접근할 저장소의 위치를 지정할 수 있음
            기본적으로 메이븐 중앙 저장소인 http://repo1.maven.org/maven2로 지정되어 있음
            -->
        </Repositories>
        <outputDirectory>
            <!--
            컴파일한 결과물 위치 값 지정
            기본 "target/classes"
            -->
        </outputDirectory>
        <testOutputDirectory>
            <!--
            테스트 소스를 컴파일한 결과물 위치 값 지정
            기본 "target/test-classes"
            -->
        </testOutputDirectory>
        <pluginManagement>
            <plugins>
                <plugin>
                    <!--
                    1. 어떠한 액션 하나를 담당하는 것으로 가장 중요하지만 들어가는 옵션은 제 각각임
                       플러그인 형식에 대한 것은 안내가 나와있음
                    2. plugin이 작성되어 있다고 무조건 실행되는 것은 아님
                       명확한 것은 아니지만 따로 실행할 플러그인을 메이븐 명령어로 실행해야 함
                    3. <executions> : 플러그인 goal과 관련된 실행에 대한 설정
                    4. <configuration> : 플러그인에서 필요한 설정 값 지정
                    -->
                </plugin>
            </plugins>
        </pluginManagement>
    </build>

</project>
```